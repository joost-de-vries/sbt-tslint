#sbt-tslint [![Build Status](https://travis-ci.org/joost-de-vries/sbt-tslint.png?branch=master)](https://travis-ci.org/joost-de-vries/sbt-tslint)

An sbt plugin for [tslint](http://palantir.github.io/tslint/). It will statically check your typescript files for error prone code.
By default linting occurs as part of your project's `tslint` task. Both src/main/assets/\*\*/\*.ts and
src/test/assets/\*\*/\*.ts sources are linted.
The rules that will be checked in your project can be specified with a `tslint.json` file. 

## Installing
To use this plugin use the addSbtPlugin command within your project's plugins.sbt (or as a global setting) i.e.:

    addSbtPlugin("name.de-vries" % "sbt-tslint" % "5.7.0")

Your project's build file also needs to enable sbt-web plugins. For example with build.sbt:

    lazy val root = (project in file(".")).enablePlugins(SbtWeb)
    
If you want to use just the tslint rules you can use [this tslint.json](https://github.com/palantir/tslint/blob/master/docs/sample.tslint.json) as a starter.

You can also use different linting rule sets. The plugin provides convenience settings for the following rule sets:
- [tslint-eslint-rules set](https://github.com/buzinas/tslint-eslint-rules). Use setting `tsLintEsLintRulesDir`  
- [tslint-mscontrib-rules](https://github.com/Microsoft/tslint-microsoft-contrib). Use setting `tslintMsContribRulesDir`  
- [ng2 lint rules](https://github.com/mgechev/codelyzer). Use setting `ng2LintRulesDir`  

To add f.i. tslint-eslint add the following to your `build.sbt`.

    libraryDependencies ++=Seq(   "org.webjars.npm" % "tslint-eslint-rules" % "3.1.0")

    (rulesDirectories in tslint) := Some(List((tslintEslintRulesDir).value))

See the [setting keys](https://github.com/joost-de-vries/sbt-tslint/blob/master/src/main/scala/name/devries/tslint/SbtTSLint.scala) for configuration options. For example: the default formatter is "prose". 



## History

### v5.7.0
- version upgrade
- upgrade to sbt 1.0

### v5.1.0
- version upgrade
- support tslint.json#lintOptions

### v4.4.2
- version upgrade

### v4.0.2-1
- upgrades to tslint 4.0.2 and typescript 2.1.1

### v3.15.1-1
- fixes tslint 'extends' feature. tx [jsebrech](https://github.com/jsebrech)

### v3.15.1
- upgrades to tslint 3.15.1 and typescript 2.0.10
- upgrades webjars-locator, sbt-web and sbt-js-engine

### v3.13.0
- follows tslint version nr
- adds support for ts 2 in combination with codelyzer

### v0.9.7
- fixes ng2 linting

### v0.9.6
- add convenience setting for ng2 lint rules.

### v0.9.5

- upgrades to typescript 1.8.10 
- extended example tslint.json with eslint configurations

### v0.9.4

- upgrades to typescript 1.8.7 and tslint 3.6.0

### v0.9.3 

- allows for comments in the tslint.json

### v0.9.1_01

- Fixes a bug in the tslint-eslint example.

### v0.9.1
- support for configuring different rules directories, different formatters, different formatter directories.  
- convenience setting for [tslint-eslint-rules](https://github.com/buzinas/tslint-eslint-rules) rules. See the example [build.sbt](https://github.com/joost-de-vries/sbt-tslint/blob/master/sbt-tslint-plugin-tester/build.sbt) for an example of how to use these rules that lint both ES6 and Typescript.
