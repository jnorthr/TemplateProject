${packagename}

import groovy.transform.*;

/*
 * Copyright ${year} the original author or authors.
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
 * ${classname} class description
 *
 * This is code with all bits needed to do a project

 *
 */ 
 @Canonical 
 public class Hammer
 {
    /** an O/S specific char. as a file path divider */
    String fs = java.io.File.separator;

    /** an O/S specific location for the user's home folder name */ 
    String home = System.getProperty("user.home");
    
    
   /** 
    * Variable name of current class.
    */  
    String classname = "Hammer";


   /** 
    * Default Constructor 
    * 
    * @return Hammer object
    */     
    public Hammer()
    {
        classname = "running Hammer constructor written by \${author}"
    } // end of constructor


   /** 
    * Method to display internal variables.
    * 
    * @return formatted content of internal variables
    */     
    public String toString()
    {
        return """classname=Hammer
user.home=\${home}
java.io.File.separator=\${java.io.File.separator}
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
        println "--- starting ${classname} ---"

        Hammer obj = new Hammer();
        
        println "Hammer = [\${obj.toString()}]"
        println "--- the end of Hammer ---"
    } // end of main

} // end of class