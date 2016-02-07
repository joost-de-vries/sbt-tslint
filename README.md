sbt-tslint [![Build Status](https://travis-ci.org/joost-de-vries/sbt-tslint.png?branch=master)](https://travis-ci.org/joost-de-vries/sbt-tslint)
==========

An sbt plugin for [tslint](http://palantir.github.io/tslint/). It will statically check your typescript files for error prone code.

To use this plugin use the addSbtPlugin command within your project's plugins.sbt (or as a global setting) i.e.:

    addSbtPlugin("name.de-vries" % "sbt-tslint" % "0.9.0")

Your project's build file also needs to enable sbt-web plugins. For example with build.sbt:

    lazy val root = (project in file(".")).enablePlugins(SbtWeb)

By default linting occurs as part of your project's `tslint` task. Both src/main/assets/\*\*/\*.ts and
src/test/assets/\*\*/\*.ts sources are linted.

Options can be specified with a `tslint.json` file within your project's base directory. Generate the file using tslint or use [this one](https://github.com/joost-de-vries/sbt-tslint/blob/master/sbt-tslint-plugin-tester/tslint.json) as a starting point. 
