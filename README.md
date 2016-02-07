sbt-tslint
==========


To use this plugin use the addSbtPlugin command within your project's plugins.sbt (or as a global setting) i.e.:

    addSbtPlugin("name.de-vries" % "sbt-tslint" % "0.9.0")

Your project's build file also needs to enable sbt-web plugins. For example with build.sbt:

    lazy val root = (project in file(".")).enablePlugins(SbtWeb)

By default linting occurs as part of your project's `tslint` task. Both src/main/assets/\*\*/\*.ts and
src/test/assets/\*\*/\*.ts sources are linted.

Options can be specified in accordance with the
[JSHint website](http://www.jshint.com/docs) and they share the same set of defaults. To set an option you can
provide a `tslint.json` file within your project's base directory. If there is no such file then a `tslint.json` file will
be search for in your home directory. 
