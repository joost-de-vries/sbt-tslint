lazy val root = Project("plugins", file(".")).dependsOn(plugin)

lazy val plugin = RootProject(file("../").getCanonicalFile.toURI)

resolvers ++= Seq(
    Resolver.sbtPluginRepo("snapshots"),
    Resolver.mavenLocal,
    Resolver.sonatypeRepo("snapshots"),
    Resolver.typesafeRepo("snapshots"),
  Resolver.bintrayRepo("webjars","maven")
    )