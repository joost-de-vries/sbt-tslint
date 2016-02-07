package name.devries.tslint

import sbt._
import sbt.Keys._
import sbt.File
import spray.json.{JsString, JsonParser, JsObject}
import scala.Some
import com.typesafe.sbt.jse.SbtJsTask
import com.typesafe.sbt.web.SbtWeb

object SbtTSLint extends AutoPlugin {

  override def requires = SbtJsTask

  override def trigger = AllRequirements

  object autoImport {

    val tslint = TaskKey[Seq[File]]("tslint", "Perform Typescript linting.")

    val config = SettingKey[Option[File]]("tslint-config", "The location of a JSHint configuration file.")
    val resolvedConfig = TaskKey[Option[File]]("tslint-resolved-config", "The actual location of a tslint configuration file if present. If tslint-config is none then the task will seek a tslint.json in the project folder. If that's not found then tslint.json will be searched for in the user's home folder.")

  }

  import SbtWeb.autoImport._
  import WebKeys._
  import SbtJsTask.autoImport.JsTaskKeys._
  import autoImport._

  val tslintUnscopedSettings = Seq(
    includeFilter in tslint := GlobFilter("*.ts"),
    config := None,
    resolvedConfig := {
      config.value.orElse {
        val tsLintConfig = "tslint.json"
        val projectRc = baseDirectory.value / tsLintConfig
        if (projectRc.exists()) {
          Some(projectRc)
        } else {
          val homeRc = file(System.getProperty("user.home")) / tsLintConfig
          if (homeRc.exists()) {
            Some(homeRc)
          } else {
            None
          }
        }
      }: Option[File]
    },
    jsOptions := JsObject(
      "tslintConfiguration" -> resolvedConfig.value.fold(JsObject()) { (file) =>
        val jsonString = IO.read(file)
        JsonParser(jsonString).asJsObject
      }
    ).toString


  )

  override def projectSettings = Seq(
  ) ++ inTask(tslint)(
    SbtJsTask.jsTaskSpecificUnscopedSettings ++
      inConfig(Assets)(tslintUnscopedSettings) ++
      inConfig(TestAssets)(tslintUnscopedSettings) ++
      Seq(
        moduleName := "tslint",
        shellFile := getClass.getClassLoader.getResource("tslint.js"),
        taskMessage in Assets := "Typescript linting",
        taskMessage in TestAssets := "Typescript test linting"
      )
  ) ++ SbtJsTask.addJsSourceFileTasks(tslint) ++ Seq(
    tslint in Assets := (tslint in Assets).dependsOn(nodeModules in Assets).value,
    tslint in TestAssets := (tslint in TestAssets).dependsOn(nodeModules in TestAssets).value
  )

}
