/* global process, require */

/*
 * Lint a number of files.
 *
 * Arguments:
 * 0 - name given to the command invoking the script (unused)
 * 1 - filepath of this script (unused)
 * 2 - array of file paths to the files to lint
 * 3 - the target folder to write to (unused - not required)
 * 4 - jshint options as a Json object
 *
 * Json array tuples are sent to stdout for each file in error (if any). Each tuple is an array where the
 * element 0 corresponds to the file path of the file linted, and element 1 is JSHINT.errors.
 */

(function () {

    "use strict";

    var args = process.argv;
    var console = require("console");
    var fs = require("fs");
    var typescript = require("typescript");
    var Tslint = require("tslint");
    var stripJsonComments = require("strip-json-comments");
    var path=require("path");

    var SOURCE_FILE_MAPPINGS_ARG = 2;
    var OPTIONS_ARG = 4;


    //export interface ILinterOptions {
    //    configuration: any;
    //    formatter: string;
    //    formattersDirectory: string;
    //    rulesDirectory: string | string[];
    //}
    var jsLintOptions =  JSON.parse(stripJsonComments(args[OPTIONS_ARG]));

    //console.log("using",jsLintOptions)

    var sourceFileMappings = JSON.parse(args[SOURCE_FILE_MAPPINGS_ARG]);
    var sourceFilesToProcess = sourceFileMappings.length;
    var results = [];
    var problems = [];
    sourceFileMappings.forEach(function (sourceFilePath) {
        var sourceFile = sourceFilePath[0];
        fs.readFile(sourceFile, "utf8", function (e, source) {
            if (e) {
                console.error("Error while trying to read " + source, e);
            } else {
                var linter = new Tslint(sourceFile, source,jsLintOptions);

            //export interface LintResult {
            //        failureCount: number;
            //        failures: RuleFailure[];
            //        format: string;
            //        output: string;
            //    }
                var lintResult=linter.lint();
                var actualErrors = 0;

                //export class RuleFailure {
                //    private sourceFile: ts.SourceFile;
                //    private fileName: string;
                //    private startPosition: RuleFailurePosition;
                //    private endPosition: RuleFailurePosition;
                //    private failure: string;
                //    private ruleName: string;

                    lintResult.failures.forEach(function (rf) {
                    if (rf) {
                        problems.push({
                            message: rf.failure,
                            severity:  "error",
                            lineNumber: rf.startPosition.lineAndCharacter.line,
                            characterOffset: rf.startPosition.lineAndCharacter.character - 1,
                            lineContent: source.substring(rf.startPosition.position,rf.endPosition.position),
                            source: sourceFile
                        });
                        ++actualErrors;
                    }
                });
                results.push({
                    source: sourceFile,
                    result: (actualErrors === 0 ? {filesRead: [sourceFile], filesWritten: []} : null)
                });
            }
            if (--sourceFilesToProcess === 0) {
                console.log("\u0010" + JSON.stringify({results: results, problems: problems}));
            }
        });
    });
}());
