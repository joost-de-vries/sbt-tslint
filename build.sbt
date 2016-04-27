sbtPlugin := true
organization := "name.de-vries"
name := "sbt-tslint"
version := "0.9.5"

homepage := Some(url("https://github.com/joost-de-vries/sbt-tslint"))
licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0"))

scalaVersion := "2.10.6"

resolvers ++= Seq(
    Resolver.typesafeRepo("releases"),
    Resolver.url("sbt snapshot plugins", url("http://repo.scala-sbt.org/scalasbt/sbt-plugin-snapshots"))(Resolver.ivyStylePatterns),
    Resolver.sonatypeRepo("releases"),
    Resolver.mavenLocal
)

libraryDependencies ++= Seq(
  "org.webjars.npm" % "typescript" % "1.8.10",
  "org.webjars.npm" % "tslint" % "3.8.1",
  "org.webjars.npm" % "minimatch" % "2.0.10",
  "org.webjars" % "strip-json-comments" % "1.0.2-1"
)

addSbtPlugin("com.typesafe.sbt" % "sbt-js-engine" % "1.1.3")

publishMavenStyle := false
bintrayRepository in bintray := "sbt-plugins"
bintrayOrganization in bintray := None
bintrayVcsUrl := Some("git@github.com:joost-de-vries/sbt-tslint.git")

scriptedSettings

scriptedLaunchOpts <+= version apply { v => s"-Dproject.version=$v" }
