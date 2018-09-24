# resharper-clt-plugin
SonarQube plugin for ReSharper Command Line Tools.

## Description
This plugin enables the analysis of C# and VisualBasic.NET source files contained in .NET projects using the output of the InspectCode [JetBrains ReSharper Command Line Tool](https://www.jetbrains.com/resharper/features/command-line.html).
* Supports the most recent version of the [JetBrains ReSharper Command Line Tools](https://www.jetbrains.com/resharper/download/index.html#section=resharper-clt) (at least version 2018.2.2)
* Compatible with [SonarQube 6.7.x (LTS)](https://www.sonarqube.org/downloads/)
* Compatible with the [SonarC# Plugin](https://docs.sonarqube.org/pages/viewpage.action?pageId=1441900) in version 7.5
* Compatible with the [SonarVB Plugin (Visual Basic .NET)](https://docs.sonarqube.org/display/PLUG/SonarVB) in version 5.2

## Properties declared/used by this plugin
|    Property     |   Description  |
| --------------- | -------------- |
| `resharper.clt.solutionFile`     | The path to the Visual Studio solution file (`.sln`) parsed by the InspectCode command line tool. |
| `resharper.clt.cs.reportPath`    | Used when analyzing C# projects. Defines the path to the XML report file generated by the InspectCode command line tool to be parsed by the plugin. |
| `resharper.clt.vbnet.reportPath` | Used when analyzing VisualBasic.NET projects. Defines the path to the XML report file generated by the InspectCode command line tool to be parsed by the plugin. |
| `resharper.clt.xsd.validation`   | Enables XML Schema validation of the XML report file generated by the InspectCode command line tool. (not yet working) |

## How to use
A more in-depth guide on how to analyze projects that are built using MSBuild can be found in article [Analyzing with SonarScanner for MSBuild](https://docs.sonarqube.org/display/SCAN/Analyzing+with+SonarQube+Scanner+for+MSBuild) of the official SonarQube documentation.
  1. Install the ReSharper Command Line Tools plugin (see [Installing a Plugin - SonarQube Documentation - Doc SonarQube](https://docs.sonarqube.org/display/SONAR/Installing+a+Plugin) for more details)
  2. Enable at least one of the rules provided by the plugin in your quality profile (see [Quality Profiles](https://docs.sonarqube.org/display/SONAR/Quality+Profiles) for more details)
  3. Open a command prompt, preferably the Developer Command prompt for Visual Studio
  4. Navigate to the root folder of the project/solution you want to build
  5. Execute the following steps:
      1. Begin the SonarQube analysis and provide the values for the required properties \
         `SonarScanner.MSBuild.exe begin /k:"sonarqube_project_key" /n:"sonarqube_project_name" /d:sonar.login="%SONAR_LOGIN_TOKEN%" /d:resharper.clt.cs.reportPath="inspectcode_result.xml" /d:resharper.clt.solutionFile="%SOLUTION_FILE%"`
      2. Build the project \
         `msbuild.exe "%SOLUTION_FILE"`
      3. Run ReSharper Command Line Tool `InspectCode.exe` \
         `inspectcode.exe /output="resharper.xml" "%SOLUTION_FILE%"`
      4. End the SonarQube analysis, which will upload the issues to the server \
         `SonarScanner.MSBuild.exe end /d:sonar.login=%SONAR_LOGIN_TOKEN%`

## License
This project is licensed under the Apache License 2.0 - see the [LICENSE](./LICENSE) file for details.
