sbtPlugin := true
organization := "name.de-vries"
name := "sbt-tslint"
version := "5.7.0"

homepage := Some(url("https://github.com/joost-de-vries/sbt-tslint"))
licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0"))

scalaVersion := (CrossVersion partialVersion sbtCrossVersion.value match {
  case Some((0, 13)) => "2.10.6"
  case Some((1, _))  => "2.12.3"
  case _             => sys error s"Unhandled sbt version ${sbtCrossVersion.value}"
})

crossSbtVersions := Seq("0.13.16", "1.0.1")

val sbtCrossVersion = sbtVersion in pluginCrossBuild

updateOptions := updateOptions.value.withCachedResolution(cachedResoluton = true)

resolvers ++= Seq(
    Resolver.bintrayRepo("webjars","maven"),
    Resolver.jcenterRepo,
    Resolver.typesafeRepo("releases"),
    Resolver.url("sbt snapshot plugins", url("http://repo.scala-sbt.org/scalasbt/sbt-plugin-snapshots"))(Resolver.ivyStylePatterns),
    Resolver.sonatypeRepo("releases"),
    Resolver.mavenLocal
)

libraryDependencies ++= Seq(

  "org.webjars.npm" % "typescript" % "2.5.2",
  "org.webjars.npm" % "tslint" % "5.7.0",
  "org.webjars.npm" % "minimatch" % "3.0.0",
  "org.webjars" % "strip-json-comments" % "1.0.2-1",
  "org.webjars.npm" % "sprintf-js" % "1.0.3"  //used by codelyzer,

)

dependencyOverrides ++= Seq(
  "org.webjars" % "webjars-locator" % "0.32",
  "org.webjars" % "webjars-locator-core" % "0.32",

  "org.webjars" % "npm" % "3.9.3"
)

addSbtPlugin("com.typesafe.sbt" % "sbt-js-engine" % "1.2.2")
addSbtPlugin("com.typesafe.sbt" % "sbt-web" % "1.4.2")

publishMavenStyle := false
bintrayRepository in bintray := "sbt-plugins"
bintrayOrganization in bintray := None
bintrayVcsUrl := Some("git@github.com:joost-de-vries/sbt-tslint.git")

scriptedLaunchOpts += s"-Dproject.version=${version.value}"
scriptedBufferLog := false