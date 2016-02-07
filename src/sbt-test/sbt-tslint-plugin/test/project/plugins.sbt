resolvers ++= Seq(
    Resolver.url("sbt snapshot plugins", url("http://repo.scala-sbt.org/scalasbt/sbt-plugin-snapshots"))(Resolver.ivyStylePatterns),
    Resolver.mavenLocal,
    Resolver.sonatypeRepo("snapshots"),
    "Typesafe Snapshots Repository" at "http://repo.typesafe.com/typesafe/snapshots/"
    )

addSbtPlugin("name.de-vries" % "sbt-tslint" % sys.props("project.version"))