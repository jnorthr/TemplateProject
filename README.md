# TemplateProject

Travis Build Status for Master Branch: [![Build Status](https://travis-ci.org/jnorthr/TemplateProject.svg?branch=master)](https://travis-ci.org/jnorthr/TemplateProject)

A Gradle project for users who develop with Git, GitHub, Travis, Gradle and Groovy/Java/Scala . Clone includes gradle build tool wrapper and folder structure like maven/gradle so you don't need an installed gradle build tool.
 
Pre-requisites

1. Working internet connection
2. Installed Git client to copy/clone this repo
3. Ability to use terminal console

Steps  
1. Open terminal console

1. Change directory \( cd \) into target folder location

2. Run this command to create a folder named GParsGroovyTests and copy down all the pieces :

   [git clone https://github.com/jnorthr/TemplateProject.git](git clone https://github.com/jnorthr/TemplateProject.git)

3. **cd TemplateProject /**

4. **./gradlew** runs a series of defined tasks to build and test code samples

5. After prior step completes, examine ** TemplateProject /** folder to find the **/build/** folder with test results

Note: **.travis.yml** needed extra logic to be able to push to github repo and have Travis C/I testing work as expected.

