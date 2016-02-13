#sbt-tslint [![Build Status](https://travis-ci.org/joost-de-vries/sbt-tslint.png?branch=master)](https://travis-ci.org/joost-de-vries/sbt-tslint)

An sbt plugin for [tslint](http://palantir.github.io/tslint/). It will statically check your typescript files for error prone code.
By default linting occurs as part of your project's `tslint` task. Both src/main/assets/\*\*/\*.ts and
src/test/assets/\*\*/\*.ts sources are linted.
The rules that will be checked in your project can be specified with a `tslint.json` file. 

## Installing
To use this plugin use the addSbtPlugin command within your project's plugins.sbt (or as a global setting) i.e.:

    addSbtPlugin("name.de-vries" % "sbt-tslint" % "0.9.1")

Your project's build file also needs to enable sbt-web plugins. For example with build.sbt:

    lazy val root = (project in file(".")).enablePlugins(SbtWeb)
    
If you want to use just the tslint rules you can generate a starter file using tslint or use [this one](https://github.com/joost-de-vries/sbt-tslint/blob/master/sbt-tslint-plugin-tester/tslint.json) as a starting point. The tslint standard rules will be used by default.

See the plugins [setting keys](https://github.com/joost-de-vries/sbt-tslint/blob/master/src/main/scala/name/devries/tslint/SbtTSLint.scala) for configuration options. For example: the default formatter is "prose". 



