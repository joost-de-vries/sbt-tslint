resolvers ++= Seq(
  Resolver.sbtPluginRepo("releases"),
  Resolver.mavenLocal,
  Resolver.sonatypeRepo("releases"),
  Resolver.typesafeRepo("releases")
)

addSbtPlugin("name.de-vries" % "sbt-tslint" % sys.props("project.version"))