scalaVersion := "2.11.8"
lazy val root = (project in file(".")).enablePlugins(SbtWeb)

WebKeys.reporter := new TestReporter(target.value)

JsEngineKeys.engineType := JsEngineKeys.EngineType.Node
