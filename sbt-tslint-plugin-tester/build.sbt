import com.typesafe.sbt.web.Import.WebKeys._

lazy val root = (project in file(".")).enablePlugins(SbtWeb)

incOptions := incOptions.value.withNameHashing(true)
updateOptions := updateOptions.value.withCachedResolution(cachedResoluton = true)

libraryDependencies ++= Seq("org.webjars.npm" % "tslint-eslint-rules" % "1.0.1",
  "org.webjars.npm" % "tslint-microsoft-contrib" % "2.0.1")

dependencyOverrides += "org.webjars.npm" % "minimatch" % "2.0.10"

//(formatter in tslint) := Some("json")

(rulesDirectories in tslint) := Some(List(tslintEslintRulesDir.value, tslintMsContribRulesDir.value))
JsEngineKeys.engineType := JsEngineKeys.EngineType.Node
