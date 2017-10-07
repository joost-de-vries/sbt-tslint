import com.typesafe.sbt.web.Import.WebKeys._

lazy val root = (project in file(".")).enablePlugins(SbtWeb)

updateOptions := updateOptions.value.withCachedResolution(cachedResoluton = true)

libraryDependencies ++= Seq(

//  "org.webjars.npm" % "tslint-eslint-rules" % "3.1.0",
//  "org.webjars.npm" % "tslint-microsoft-contrib" % "2.0.12",
//  "org.webjars.npm" % "codelyzer" % "2.0.0-beta.1"
)

dependencyOverrides += "org.webjars.npm" % "minimatch" % "2.0.10"

(rulesDirectories in tslint) := Some(List(tslintEslintRulesDir.value))
JsEngineKeys.engineType := JsEngineKeys.EngineType.Node
