addSbtPlugin("me.lessis" % "bintray-sbt" % "0.3.0")
addSbtPlugin("com.gilt" % "sbt-dependency-graph-sugar" % "0.7.5-1")

// set sbt to use eclipse aether instead of ivy
addMavenResolverPlugin

libraryDependencies += "org.scala-sbt" % "scripted-plugin" % sbtVersion.value
