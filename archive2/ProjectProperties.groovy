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
    * Variable name of external file holding data values for this module.
    */  
	String propertyFileName = "TemplateProject/templates/docs/gradle.properties.txt";
	
	
   /** 
    * Default Constructor 
    * 
    * @return ProjectProperties object
    */     
    public ProjectProperties()
    {
        println "running ProjectProperties constructor"
        load();
    } // end of constructor


   /** 
    * Method to return a map of internal variables.
    * 
    * @return Map of internal variables
    */     
    public Map toMap()
    {
    	Map payload = [:]
    	payload['githubuser'] = githubuser;
    	payload['year'] = year;
    	payload['author'] = author;
    	payload['projectname'] = projectname;
    	payload['packagename'] = packagename;
    	payload['packagefolder'] = packagefolder;
    	payload['packageid'] = packageid;
    	payload['classname'] = classname;
    	payload['email'] = email;
    	
        return payload;
    }  // end of map 


   /** 
    * Method to unload a map into internal variables.
    * 
    * @return Map of internal variables
    */     
    public Map unloadMap(Map payload)
    {    	
    	githubuser = payload['githubuser'];
    	year = payload['year'];
    	author = payload['author'];
    	projectname = payload['projectname'];
    	packagename = payload['packagename'];
    	packagefolder = payload['packagefolder'];
    	packageid = payload['packageid'];
    	classname = payload['classname'];
    	email = payload['email'];
    	
        return payload;
    }  // end of map 


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


   /** 
    * Method to construct payload for external file from internal variables.
    * 
    * @return formatted content of internal variables
    */     
    public String toPayload()
    {
		String payload = """org.gradle.daemon=true
org.gradle.parallel=true
""";
		payload += this.toString();
		return payload;
    }  // end of string


   /** 
    * Method to read payload from external file and insert into internal variables.
    */     
    public load()
    {
		def file3 = new File(propertyFileName)
		def payload = (file3.exists()) ? file3.text : "";

		println "... ${propertyFileName} holds ${payload.size()} characters"
		System.out.println(file3.getAbsolutePath());

		payload.eachLine{ln->
			int i = ln.indexOf('=');
			if (i>0)
			{
				def k = ln.substring(0,i).trim();
				def v = ln.substring(i+1).trim();
				println "... k=[${k}] and v=[${v}]"
				switch (k)
				{
					case 'githubuser' : githubuser = v; 
            			break;
					
					case 'year' : year = v; 
            			break;
					
					case 'email' : email = v; 
            			break;
					
					case 'author' : author = v; 
            			break;
					
					case 'projectname' : projectname = v; 
            			break;
					
					case 'packagename' : packagename = v; 
            			break;
					
					case 'packagefolder' : packagefolder = v; 
            			break;
					
					case 'packageid' : packageid = v; 
            			break;
					
					case 'classname' : classname = v; 
            			break;
					
					default:
            				println "... cannot find variable for "+k;
            				break;
				} // end of switch
				
			} // end of if
			
		} // end of each
		
	}  // end of load()
    

   /** 
    * Method to write payload to external file from internal variables.
    */     
    public save()
    {
		def file3 = new File(propertyFileName)
		// Or a writer object:
		file3.withWriter('UTF-8') { writer ->
    		writer.write(this.toPayload())
		} // end of writer
    }  // end of save()
    
    

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
        
        println "\nProjectProperties toMap()"
        def m = obj.toMap()
		m.each{ k, v -> println "${k}:${v}" }

        println "\nProjectProperties toPayload()"
        println obj.toPayload()
		
		//obj.save();
		obj.load();
        
        println "ProjectProperties = [${obj.toString()}]"
        		        
        println "--- the end of ProjectProperties ---"
    } // end of main

} // end of class