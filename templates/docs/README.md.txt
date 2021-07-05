# ${projectName} Project

Travis Build Status for Master Branch: [![Build Status](https://travis-ci.org/${gitHubUser}/${projectName}.svg?branch=master)](https://travis-ci.org/${gitHubUser}/${projectName})

A Gradle project for users who develop with Git, GitHub, Travis, Gradle and Groovy/Java/Scala. 
Clone includes gradle build tool wrapper and folder structure like maven/gradle so you don't need an installed gradle build tool.
 
Pre-requisites

1. Working internet connection
2. Installed Git client to copy/clone this repo
3. Ability to use terminal console

Steps  
1. Open terminal console

1. Change directory into target folder location

2. Run this command to create a folder named  and copy down all the pieces :

   [git clone https://github.com/${gitHubUser}/${projectName}.git](git clone https://github.com/${gitHubUser}/${projectName}.git)

3. **cd ${projectName} /**

4. **./gradlew** runs a series of defined tasks to build and test code samples

5. After prior step completes, examine ** ${projectName} /** folder to find the **/build/** folder with test results

Note: **.travis.yml** needed extra logic to be able to push to github repo and have Travis C/I testing work as expected.


