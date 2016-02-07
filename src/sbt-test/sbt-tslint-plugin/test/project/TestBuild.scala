import sbt._
import sbt.Keys._

import com.typesafe.sbt.web.SbtWeb
import com.typesafe.sbt.web.SbtWeb.autoImport._

object TestBuild extends Build {

  class TestLogger(target: File) extends Logger {
    def trace(t: => Throwable): Unit = {}

    def success(message: => String): Unit = {}

    def log(level: Level.Value, message: => String): Unit = {
      if (level == Level.Error) {
        if (message.contains("forbidden var keyword")) {
          IO.touch(target / "forbidden-var-keyword")
        }
      }
    }
  }

  class TestReporter(target: File) extends LoggerReporter(-1, new TestLogger(target))

  lazy val root = Project(
    id = "test-build",
    base = file("."),
    settings = Seq(WebKeys.reporter := new TestReporter(target.value))
  ).enablePlugins(SbtWeb)

}