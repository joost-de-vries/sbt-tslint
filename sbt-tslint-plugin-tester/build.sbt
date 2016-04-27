import com.typesafe.sbt.web.Import.WebKeys._

lazy val root = (project in file(".")).enablePlugins(SbtWeb)

incOptions := incOptions.value.withNameHashing(true)
updateOptions := updateOptions.value.withCachedResolution(cachedResoluton = true)

libraryDependencies ++= Seq(
  "org.webjars.npm" % "tslint-eslint-rules" % "1.2.0",
  "org.webjars.npm" % "tslint-microsoft-contrib" % "2.0.3",
  "org.webjars.npm" % "codelyzer" % "0.0.18"
)

dependencyOverrides += "org.webjars.npm" % "minimatch" % "2.0.10"

(rulesDirectories in tslint) := Some(List(tslintEslintRulesDir.value))
JsEngineKeys.engineType := JsEngineKeys.EngineType.Node
