#sbt-tslint [![Build Status](https://travis-ci.org/joost-de-vries/sbt-tslint.png?branch=master)](https://travis-ci.org/joost-de-vries/sbt-tslint)

An sbt plugin for [tslint](http://palantir.github.io/tslint/). It will statically check your typescript files for error prone code.
By default linting occurs as part of your project's `tslint` task. Both src/main/assets/\*\*/\*.ts and
src/test/assets/\*\*/\*.ts sources are linted.
The rules that will be checked in your project can be specified with a `tslint.json` file. 

## Installing
To use this plugin use the addSbtPlugin command within your project's plugins.sbt (or as a global setting) i.e.:

    addSbtPlugin("name.de-vries" % "sbt-tslint" % "0.9.1_01")

Your project's build file also needs to enable sbt-web plugins. For example with build.sbt:

    lazy val root = (project in file(".")).enablePlugins(SbtWeb)
    
If you want to use just the tslint rules you can use [this tslint.json](https://github.com/palantir/tslint/blob/master/docs/sample.tslint.json) as a starter.

See here for the eslint rules add by using the [tslint-eslint-rules set](https://github.com/buzinas/tslint-eslint-rules)  
You can use these rules by adding the following to your `build.sbt`.

    libraryDependencies ++=Seq(   "org.webjars.npm" % "tslint-eslint-rules" % "1.0.1")
    dependencyOverrides += "org.webjars.npm" % "minimatch" % "2.0.10"

    (rulesDirectories in tslint) := Some(List((tslintEslintRulesDir).value))

See the plugins [setting keys](https://github.com/joost-de-vries/sbt-tslint/blob/master/src/main/scala/name/devries/tslint/SbtTSLint.scala) for configuration options. For example: the default formatter is "prose". 



