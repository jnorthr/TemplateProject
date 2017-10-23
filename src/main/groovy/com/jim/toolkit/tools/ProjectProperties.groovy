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
    * Variable name of a series of classnames being built in the chosen jvm language. Also
    * used to name the output script as Tools.java Tools.groovy. Can be changed
    * from gradle command line using option -Pclassname=xxx 
    * Works just like 'classname' but for several sets of source files to be generated
    */  
    def classes = [];


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
classes=${classes}
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
        file3.withReader { reader ->
            while (line = reader.readLine()) {
                txs = line.trim();
                def i =  txs.indexOf("//");

                if ( i > -1 )
                {
                    txs = txs.substring(0,i);
                }

                println txs;
/*
                    // 1; "2013-03-02"; "B"; 121.44; 2; "Pension"; "true";
                    txs = line.split(';')
                    println "... txs.size()="+txs.size();
                    
                    def t1 = txs[0].trim(); // id

                    def t2 = txs[1].trim().substring(1); // date
                    int ct2 = t2.indexOf('"');
                    if (ct2>-1) { t2 = t2.substring(0,ct2); }
                    def dt = cvt(t2)
                    println "... and t2 date of '${t2}' gave date:"+dt.toString();
                    
                    // get type
                    def t3 = txs[2].trim().substring(1,2); // type
                    println "... t3 type=|${t3}|"

                    // get amount
                    println "... amt txs[3]=|${txs[3].trim()}|"  // amount
                    BigDecimal t4 = txs[3].trim() as BigDecimal;
                    println "... t4 amt=|${t4}|"
                    
                    // get number
                    println "... client txs[4]=|${txs[4].trim()}|"  // client number
                    BigDecimal t5 = txs[4].trim() as BigDecimal;
                    println "... client num=|${t5}|"

                    // get purpose
                    def t6 = txs[5].trim().substring(1);    // reason / purpose
                    def ct6 = t6.indexOf('"');
                    if (ct6>-1) { t6 = t6.substring(0,ct6); }
                    println "... purpose t6=|${t6}|"

                    
                    // get flag
                    def t7 = txs[6].trim().substring(1,2).toUpperCase();    // flag
                    boolean f = (t7=='T') ? true : false;                        
                    println "... flag=|${t7}| f=$f"

                    println "\n"

                    Cell c = new Cell([d:dt, type:t3, amount:t4, number:t5, purpose:t6, flag:f])
                    println c.toString();
                    count++;
                    cells += c;
*/
              } // end of while
              
        } // end of reader
        
        println "... loaded $count entries"
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
        def ct = obj.load();
        println ""
        println "ProjectProperties = [${obj.toString()}]"
        println "--- the end of ProjectProperties ---"
    } // end of main

} // end of class