package com.jim.toolkit.tools;

import groovy.transform.*;

/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/** 
 * ProjectProperties class description
 *
 * This is code with all bits needed to do a project

 *
 */ 
 @Canonical 
 @groovy.beans.Bindable
 public class ProjectProperties
 {
    /** an id of GitHub user who will host this project */
    String githubuser = "jnorthr";


    /** copyright year of authorship */ 
    String year = "2017";

        
   /** 
    * Variable full name of original author.
    */  
    String author = "Jim Northrop";


   /** 
    * Variable name of this generated project. Usually this is the projectDir folder name.
    */  
    String projectname = "Toolkit";


   /** 
    * Variable value of package statement copied into jvm language source code.
    */  
    String packagename = "package com.jim.toolkit.tools;";


   /** 
    * Hardware folder name hosting this project. Used to build folder hierarchy
    * within xxx/src/main/groovy etc.
    */  
    String packagefolder = "/com/jim/toolkit/tools";


   /** 
    * Software folder name hosting this project. Used in import statements
    * mirrors packagefolder structure.
    */  
    String packageid = "com.jim.toolkit.tools.";

   /** 
    * Variable name of the class being built in the chosen jvm language. Also
    * used to name the output script as Tools.java Tools.groovy. Can be changed
    * from gradle command line using option -Pclassname=xxx 
    */  
    String classname = "Tools";


   /** 
    * Variable name of emal for documentation purposes.
    */  
    String email = "men@work.com";


   /** 
    * Default Constructor 
    * 
    * @return ProjectProperties object
    */     
    public ProjectProperties()
    {
        println "running ProjectProperties constructor"
    } // end of constructor


   /** 
    * Method to display internal variables.
    * 
    * @return formatted content of internal variables
    */     
    public String toString()
    {
        return """githubuser=${githubuser}
year=${year}
author=${author}
projectname=${projectname}
packagename=${packagename}
packagefolder=${packagefolder}
packageid=${packageid}
classname=${classname}
email=${email}
"""
    }  // end of string

   /** 
    * Method to print audit log.
    * 
    * @param the text to be said
    * @return void
    */     
    public void say(txt)
    {
        println txt;
    }  // end of method



   // ======================================
   /** 
    * Method to run class tests.
    * 
    * @param args Value is string array - possibly empty - of command-line values. 
    * @return void
    */     
    public static void main(String[] args)
    {
        println "--- starting ProjectProperties ---"

        ProjectProperties obj = new ProjectProperties();
        
        println "ProjectProperties = [${obj.toString()}]"
        println "--- the end of ProjectProperties ---"
    } // end of main

} // end of class