import com.typesafe.sbt.web.Import.WebKeys._
lazy val root = (project in file(".")).enablePlugins(SbtWeb)

libraryDependencies ++=Seq(   "org.webjars.npm" % "tslint-eslint-rules" % "1.0.1")

dependencyOverrides += "org.webjars.npm" % "minimatch" % "2.0.10"
rulesDirectories := List((tslintEslintRulesDir).value)
JsEngineKeys.engineType := JsEngineKeys.EngineType.Node
