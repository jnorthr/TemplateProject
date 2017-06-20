@package@

import groovy.transform.*;

/*
 * Copyright @year@ the original author or authors.
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
 * @classname@ class description
 *
 * This is code with all bits needed to do a project

 *
 */ 
 @Canonical 
 public class @classname@
 {
    /** an O/S specific char. as a file path divider */
    String fs = java.io.File.separator;

    /** an O/S specific location for the user's home folder name */ 
    String home = System.getProperty("user.home");
    
    
   /** 
    * Variable name of current class.
    */  
    String classname = "@classname@";


   /** 
    * Default Constructor 
    * 
    * @return @classname@ object
    */     
    public @classname@()
    {
        classname = "running @classname@ constructor";
    } // end of constructor


   /** 
    * Method to display internal variables.
    * 
    * @return formatted content of internal variables
    */     
    public String toString()
    {
        String tx = "classname=@classname@ user.home="+home+" java.io.File.separator="+java.io.File.separator;
		return tx;
    }  // end of string

   /** 
    * Method to print audit log.
    * 
    * @param the text to be said
    * @return void
    */     
    public void say(String msg)
    {
        System.out.println(msg);
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
        System.out.println("--- starting @classname@ ---");

        @classname@ obj = new @classname@();
        
        System.out.println("@classname@ = [${obj.toString()}]");
        System.out.println("--- the end of @classname@ ---");
    } // end of main

} // end of class