package com.jim.toolkit.tools;

import groovy.swing.SwingBuilder  
import groovy.beans.Bindable  
import static javax.swing.JFrame.EXIT_ON_CLOSE  
import java.awt.*
import groovy.transform.*;
import com.jim.toolkit.tools.ProjectProperties;
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
 * Dialog class description
 *
 * This is code with all bits needed to do a project

 *
 */ 
 @Canonical 
 public class Dialog
 {
    /** an O/S specific char. as a file path divider */
    String fs = java.io.File.separator;


    /** an O/S non-specific object to host a GUI */ 
    SwingBuilder swingBuilder = new SwingBuilder()
    
   /** 
    * Variable name of current class.
    */  
    String classname = "Dialog";

    //@groovy.beans.Bindable
	ProjectProperties address = new ProjectProperties();

   /** 
    * Default Constructor 
    * 
    * @return Dialog object
    */     
    public Dialog()
    {
        classname = "running Dialog constructor"
    } // end of constructor


   /** 
    * Method to display internal variables.
    * 
    * @return formatted content of internal variables
    */     
    public String toString()
    {
        return """classname=${classname}
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
    * Method to build GUI.
    * 
    * @return void
    */     
    public void build()
    {

// edt method makes sure UI is build on Event Dispatch Thread.
swingBuilder.edt 
{   // Simple change in look and feel.
    lookAndFeel 'nimbus'  
    frame(title: 'Project Properties', size: [450, 380], minimumSize: [430, 348], show: true, locationRelativeTo: null, defaultCloseOperation: EXIT_ON_CLOSE) 
    { 
        borderLayout(vgap: 10)
        
        panel(constraints: BorderLayout.CENTER, minimumSize:[400, 280], border: compoundBorder([emptyBorder(10), titledBorder('Enter your values:') ]) ) 
        {
            tableLayout {
                tr {
                    td {
                        label 'Git User:'  // text property is default, so it is implicit.
                    }
                    td {
                        textField address.githubuser, id: 'githubuser', columns: 20
                    }
                }

                tr {
                    td {
                        label 'Author:'
                    }
                    td {
                        textField id: 'author', columns: 20, address.author
                    }
                }

                tr {
                    td {
                        label 'Email Addr :'
                    }
                    td {
                        textField id: 'email', columns: 20, address.email
                    }
                } // end of tr
                

                tr {
                    td {
                        label 'Project Name:'
                    }
                    td {
                        textField id: 'projectname', columns: 20, address.projectname
                    }
                } // end of tr
                
                tr {
                    td {
                        label 'Year:'
                    }
                    td {
                        textField id: 'year', columns: 5, text: address.year
                    }
                }

                tr {
                    td {
                        label 'Package :'
                    }
                    td {
                        textField id: 'packagename', columns: 25, address.packagename
                    }
                } // end of tr
                
                tr {
                    td {
                        label 'Folder :'
                    }
                    td {
                        textField id: 'packagefolder', columns: 25, address.packagefolder
                    }
                } // end of tr
                
                
                tr {
                    td {
                        label 'Package Id :'
                    }
                    td {
                        textField id: 'packageid', columns: 25, address.packageid
                    }
                } // end of tr
                
                tr {
                    td {
                        label 'Classname :'
                    }
                    td {
                        textField id: 'cn', columns: 25, address.classname
                    }
                } // end of tr
                
                
            } // end of tableLayout            
        } // end of panel
        
        panel(constraints: BorderLayout.SOUTH,maximumSize:[250, 50],background:Color.WHITE ) {
        	hbox{
	            button text: 'O k', actionPerformed: { println 'ok';  }
    	        button text: 'Save', actionPerformed: { println address; }
        	    button text: 'Exit', actionPerformed: { System.exit(0); }
            } // end of hbox
        } // end of panel
        
        // Binding of textfield's to address object.
        bean address, 
            githubuser: bind { githubuser.text }, 
            year: bind { year.text }, 
            author: bind { author.text },
            projectname: bind { projectname.text },
            packagename: bind { packagename.text },
            packagefolder: bind { packagefolder.text },
            packageid: bind { packageid.text },
            classname: bind { cn.text },
            email: bind { email.text }

        } // end of frame  
	  } // end of swingBuilder.edt

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
        println "--- starting Dialog ---"

        Dialog obj = new Dialog();
		obj.build();        
        println "Dialog = [${obj.toString()}]"
        println "--- the end of Dialog ---"
    } // end of main

} // end of class