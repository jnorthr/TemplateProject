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
 * ProjectProperties class description
 *
 * This is code with all variable bits needed to do a project
 *
 */ 
 @Canonical 
 @groovy.beans.Bindable
 public class ProjectProperties
 {
    /** an O/S specific char. as a file path divider */
    String fs = java.io.File.separator;


    /** an id of GitHub user who will host this project */
    String gitHubUser = "jnorthr";


   /** 
    * Variable full name of original author.
    */  
    String author = "Jim Northrop";

   /** 
    * Variable name of email for documentation purposes.
    */  
    String email = "men@work.com";


    /** copyright year of authorship */ 
    String year = "2019";
       

   /** 
    * Variable name of the actual folder for this project. Usually this is the projectDir folder name.
    */  
    String projectRoot = System.getProperty("user.dir");;


   /** 
    * Variable name of this generated project. Usually this is the projectDir folder name.
    */  
    String projectName = "/Toolkit";


   /** 
    * Variable name of the actual folder for this project. Usually this is the projectDir folder name.
    */  
    String projectLocation = System.getProperty("user.dir");;


   /** 
    * Hardware folder name hosting this project. Used to build folder hierarchy
    * within xxx/src/main/groovy etc.
    */  
    String packageFolder = "/com/jim/toolkit/tools";


   /** 
    * Variable value of package statement copied into jvm language source code.
    */  
    String packageName = "package com.jim.toolkit.tools;";


   /** 
    * Software folder name hosting this project. Used in import statements
    * mirrors packagefolder structure.
    */  
    String packagePrefix = "com.jim.toolkit.tools.";

   /** 
    * Variable name of the class being built in the chosen jvm language. Also
    * used to name the output script as Tools.java Tools.groovy. Can be changed
    * from gradle command line using option -PprimaryClassName=xxx 
    */  
    String primaryClassName = "Tools";


   /** 
    * Variable name of a series of primaryClassName's being built in the chosen jvm language. Also
    * used to name the output script as Tools.java Tools.groovy, etc. 
    *
    * Can be changed from gradle command line using option -Pclasses=xxx 
    * Works just like 'primaryClassName' but for several sets of source files to be generated
    *
    * List may be quote or apostrophe delimited but must have commas between each class name
    * so: Fred,'Hammer.java',  "Screws.scala" would generate 3 source files of 1)Fred.groovy 2)Hammer.java 3)Screws.scala
	* Trailing suffix of primaryClassName is optional & defaults to .groovy
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
        this.setProjectLocation();
        primaryClassName = fixPrimaryClassName();
        map = this.toMap();
    } // end of constructor

   /** 
    * Non-Default Constructor 
    * 
    * @param projectDir has folder name of current project - NOT the parent folder name !
    * @return ProjectProperties object
    */     
    public ProjectProperties(String projectDir)
    {
        println "running ProjectProperties non-dft constructor [${projectDir}]"
        this.load();
        projectRoot = projectDir;
        this.setProjectLocation();
        primaryClassName = fixPrimaryClassName();
        map = this.toMap();
    } // end of constructor



   /** 
    * Method to display internal variables.
    * 
    * @return formatted content of internal variables
    */     
    public String toString()
    {
        return """gitHubUser=${gitHubUser}
author=${author}
email=${email}
year=${year}
projectRoot=${projectRoot}
projectName=${projectName}
projectLocation=${projectLocation}
packageFolder=${packageFolder}
packageName=${packageName}
packagePrefix=${packagePrefix}
primaryClassName=${primaryClassName}
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
        m["gitHubUser"]=gitHubUser
        m["author"]=author
        m["email"]=email
		m["year"]=year

        m["projectRoot"]=projectRoot
		m["projectName"]=projectName
        m["projectLocation"]=projectLocation

        m["packageFolder"]=packageFolder    
		m["packageName"]=packageName
		m["packagePrefix"]=packagePrefix
		m["primaryClassName"]=primaryClassName
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
                    
                    def t1 = toks[0].trim(); // typically, the key
                    def t2 = (toks.size() > 1) ? toks[1].trim() : ""; // value
					println "... token 0 =[$t1] and token 1 = [${t2}]"
					
					switch (t1)
					{
						case "gitHubUser": gitHubUser = t2; 
							break;
                        case "author": author = t2; 
                            break;
                        case "email": email = t2; 
                            break;
						case "year": year = t2; 
							break;

                        case "projectRoot": projectRoot = t2;
                            break;                                  
						case "projectName": projectName = t2; 
							break;
                        case "projectLocation": projectLocation = t2;
                            break;                                  

                        case "packageFolder": packageFolder = t2; 
                            break;
						case "packageName": packageName = t2; 
							break;
						case "packagePrefix": packagePrefix = t2; 
							break;

						case "primaryClassName": primaryClassName = t2; 
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
    

    
   /** 
    * Method to return a naked class name with no source file suffix like .groovy
    * 
    * @return String the class name with no trailing suffix like .java, .groovy, etc.
	*/
    public String fixPrimaryClassName() 
    {
    	int j = primaryClassName.indexOf('.');
        print "\n... fixPrimaryClassName()=[${primaryClassName}] j=${j} "

    	def t = (j < 0) ? primaryClassName : primaryClassName.substring(0,j) ;
        println " now: t=[${t}]"
        return t.toString();
	} // end of method    

    

   /** 
    * Method to return a piece of the projectDir excluding the TemplateProject folder. It
    * then divides it into two var.s called: projectRoot + projectName
    * 
    * @return String the parent folder name above our own TemplateProject
    */     
    public String setProjectLocation() 
    {
    	int j = this.projectRoot.lastIndexOf(fs);
        println "\n... projectRoot=[${projectRoot}] j=${j}"

    	String t = (j < 0) ? projectRoot : projectRoot.substring(0,j) ;
        println "... t=[${t}]"

    	int k = t.lastIndexOf(fs);
        println "... k=[${k}]"

        if (k > -1)
        {
    	   projectName = projectRoot.substring(k+1,j); // this should be a single /foldername
           println "... projectName set to=[${projectName}]"           
    	   projectRoot = t.substring(0,k);
           println "... projectRoot set to=[${projectRoot}]"           
        } // end of if
  
        println "... setProjectLocation ended with projectRoot=${projectRoot} projectName=[${projectName}]"
  
        projectLocation = projectRoot + fs + projectName;
    	return projectLocation;
    } // end of setProjectDir


   /** 
    * Method to return a list of strings representing class names of sources to be built.
    * 
    * @return List true if write to new output file was successful
    */     
    public List getClassNames() 
    {
        def names = [];
        def goodnames = [];
        String token="";

        def cn = classes.trim();
        if (cn.size() > 0)
        {
	        names = cn.tokenize( ',' )
	        names.each{e-> 
	        	println "... name=[${e}]"
	        	token = e;

	        	def f = e.trim();
	        	println "... f=[${f}]"
	        	int i = f.indexOf(/"/)
	        	if ( i > -1 ) 
	        	{
	        		int j = f.lastIndexOf(/"/)
	        		println "... end quote at j="+j;
	        		if ( j > i )
	        		{
	        			token = f.substring(i+1,j).trim();
			        	println "... f=[${token}]"
	        		} // end of if
		        	else
		        	{
						token = f.substring(i+1).trim();
			    		println "... f=[${token}]"
		    		} // end of else
	        	} // end of if
	        	else
	        	{
	        		i = f.indexOf(/'/)
		        	if ( i > -1 ) 
		        	{
		        		int k = f.lastIndexOf(/'/)
		        		println "... end quote at k="+k;
		        		if ( k > i )
		        		{
		        			token = f.substring(i+1,k).trim();
			        		println "... f=[${token}]"
		        		} // end  of if
		        		else
		        		{
							token = f.substring(i+1).trim();
			        		println "... f=[${token}]"
		        		} // end of else
		        	} // end  of if
	        	}

				token.replaceAll('"',' ')
				token.replaceAll(/\'/,' ')
				token = token.trim();

				if (token.size()>0) 
				{ 
					int m = token.indexOf('.');
					if (m < 1) token+=".groovy";  
                    String na = token.toLowerCase();
                    if (na.endsWith(".groovy") || na.endsWith(".java")  || na.endsWith(".scala" ))
                    {
                        goodnames += token;
                    }  // end of if
				} // end of if
				
	        	println "... token=[${token}]\n"
	        } // end of each

        } // end of if

        return goodnames;        
    } // end of get


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
	    ProjectProperties obj;
	         
		if (args.size() > 0)
		{
            println "... using directory :"+args[1];
			obj = new ProjectProperties(args[1].toString());
		} // end of if
		else
		{
	        obj = new ProjectProperties();
    	} // end of else

        println "\nProjectProperties = [" + obj.toString() + "]"

        Map m = obj.toMap()
        m.each{k,v-> println "... map[${k}]=[${v}]"}

        def x = obj.getClassNames();
		x.each{y-> println "... create source file name="+y; }
		
        // write updated version of gradle.properties with this TemplateProject folder
        obj.dump();

        println "--- the end of ProjectProperties ---"
    } // end of main

} // end of class