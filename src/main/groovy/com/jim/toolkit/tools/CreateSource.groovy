package com.jim.toolkit.tools;

import groovy.transform.*;

/*
 * Copyright 2019 the original author or authors.
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
 * CreateSource class description
 *
 * This is code with bits needed to do construct a single source code file
 *
 */ 
 @Canonical 
 public class CreateSource
 {
    /** an O/S specific char. as a file path divider */
    String fs = java.io.File.separator;



   /** 
    * Variable name of the actual folder for this project. Usually this is the projectDir folder name.
    */  
    String projectRoot = "";


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
    * Variable name of the source class being built in the chosen jvm language.
    */  
    String classname = "Tools";

   /** 
    * Variable name holding all this project's properties that influence builds.
    */  
	ProjectProperties pp = new ProjectProperties();


   /** 
    * Default Constructor 
    * 
    * @return CreateSource object
    */     
    public CreateSource()
    {
        println "running CreateSource constructor"
        projectRoot = pp.getProjectDir();
        packagefolder = pp.packagefolder;
        packageid = pp.packageid;
        classname = pp.classname;
        //this.load();
    } // end of constructor


   /** 
    * Method to display internal variables.
    * 
    * @return formatted content of internal variables
    */     
    public String toString()
    {
        return """fs=${fs}
projectRoot=${projectRoot}
packagefolder=${packagefolder}
packageid=${packageid}
classname=${classname}
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


   /** 
    * Method to write new updated source code to persistent store.
    * 
    * @return true if write to new output file was successful
    */     
    public boolean dump(String fout)
    {
        def file5 = new File(fout);
        file5.withWriter('UTF-8') {
                it.writeLine 'org.gradle.daemon=true'  
                it.writeLine 'org.gradle.parallel=true'
        } // end of writer

        return true;        
    } // end of load



   /** 
    * Method to read language source code from persistent store into our vault.
    * 
    * @param fin - file in - the name of the language source file
    * @return void
    */     
    public int load(String fin)
    {
        def file3 = new File(fin);   //'gradle.properties')

        // Use a reader object:
        int count = 0
        def line
        file3.withReader { reader ->
            while (line = reader.readLine()) {
					
            } // end of while              
        } // end of reader
        
        println "... loaded $count lines"
        return count;        
    } // end of load
    
    
   // ======================================
   /** 
    * Method to run class tests.
    * 
    * @param args Value is string array - possibly empty - of command-line values. 
    * @return void
    */     
    public static void main(String[] args)
    {
        println "--- starting CreateSource ---"
	    CreateSource obj;
	    obj = new CreateSource();
    	println "... obj="+obj.toString();    	    		
        println "--- the end of CreateSource ---"
    } // end of main

} // end of class