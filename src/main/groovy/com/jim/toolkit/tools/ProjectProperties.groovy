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
    * Variable name of email for documentation purposes.
    */  
    String email = "men@work.com";


   /** 
    * Variable name of a series of classnames being built in the chosen jvm language. Also
    * used to name the output script as Tools.java Tools.groovy. Can be changed
    * from gradle command line using option -Pclassname=xxx 
    * Works just like 'classname' but for several sets of source files to be generated
    */  
    String classes = "";

   /** 
    * Variable name of Map of all internal variables.
    */  
	Map map = [:]


   /** 
    * Default Constructor 
    * 
    * @return ProjectProperties object
    */     
    public ProjectProperties()
    {
        println "running ProjectProperties constructor"
        this.load();
        map = this.toMap();
    } // end of constructor


   /** 
    * Method to display internal variables.
    * 
    * @return formatted content of internal variables
    */     
    public String toString()
    {
        return """githubuser=${githubuser}
author=${author}
year=${year}
projectname=${projectname}
packagename=${packagename}
packagefolder=${packagefolder}
packageid=${packageid}
classname=${classname}
email=${email}
classes=${classes}
"""
    }  // end of string


   /** 
    * Method to return a map variable.
    * 
    * @return formatted content of internal variables as a Map
    */     
    public Map toMap()
    {
    	def m = [:]
        m["githubuser"]=githubuser
        m["author"]=author
		m["year"]=year
		m["projectname"]=projectname
		m["packagename"]=packagename
		m["packagefolder"]=packagefolder	
		m["packageid"]=packageid
		m["classname"]=classname
		m["email"]=email
		m["classes"]=classes
		return m;
    }  // end of toMap

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
    * Method to write all object's variables to persistent store named gradle.properties.
    * 
    * @return true if write to new output file was successful
    */     
    public boolean dump()
    {
        def file5 = new File('gradle.properties');
        file5.withWriter('UTF-8') {
                it.writeLine 'org.gradle.daemon=true'  
                it.writeLine 'org.gradle.parallel=true'
                it.writeLine this.toString();
        } // end of writer

        return true;        
    } // end of load



   /** 
    * Method to read all Cell objects from persistent store into our list.
    * 
    * @param the Cells array to be loaded
    * @return void
    */     
    public int load()
    {
        def file3 = new File('gradle.properties')

        // Use a reader object:
        int count = 0
        def line
        def txs 
        def toks
        file3.withReader { reader ->
            while (line = reader.readLine()) {
                txs = line.trim();
                def i =  txs.indexOf("//");

                if ( i > -1 )
                {
                    txs = txs.substring(0,i);
                }

                //println "... txs=["+txs+"]";
                if (txs.trim().size() > 0 )
                {
                    // packagename =package com.jim.toolbag.tools; 
                    toks = txs.split('=')
                    //println "... toks.size()="+toks.size();
                    
                    def t1 = toks[0].trim(); // key
                    def t2 = toks[1].trim(); // value
					//println "... token 0 =[$t1] and token 1 = [${t2}]"
					
					switch (t1)
					{
						case "githubuser": githubuser = t2; 
							break;
						case "year": year = t2; 
							break;
						case "author": author = t2; 
							break;
						case "projectname": projectname = t2; 
							break;
						case "packagename": packagename = t2; 
							break;
						case "packagefolder": packagefolder = t2; 
							break;
						case "packageid": packageid = t2; 
							break;
						case "classname": classname = t2; 
							break;
						case "email": email = t2; 
							break;
						case "classes": classes = t2; 
							break;
									
					} // end of switch
					
				} // end of if
              } // end of while
              
        } // end of reader
        
        println "... loaded $count entries"
        map = this.toMap();
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
        println "--- starting ProjectProperties ---"

        ProjectProperties obj = new ProjectProperties();
        println "ProjectProperties = [${obj.toString()}]"
        println "--- the end of ProjectProperties ---"
    } // end of main

} // end of class