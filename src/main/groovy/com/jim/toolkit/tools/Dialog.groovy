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
    * Non-Default Constructor 
    * 
    * @param projectDir tells us actual folder our project is running from
    * @return Dialog object
    */     
    public Dialog(String projectDir)
    {
        classname = "running non-dft Dialog constructor"
        address = new ProjectProperties(projectDir);
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
    frame(title: 'Project Properties', size: [500, 550], minimumSize: [450, 500], show: true, locationRelativeTo: null, defaultCloseOperation: EXIT_ON_CLOSE) 
    { 
        borderLayout(vgap: 10)
        
        panel(constraints: BorderLayout.CENTER, minimumSize:[450, 500], border: compoundBorder([emptyBorder(10), titledBorder('Enter your values:') ]) ) 
        {
            tableLayout {
                tr {
                    td {
                        label 'Git User:'  // text property is default, so it is implicit.
                    }
                    td {
                        textField address.gitHubUser, id: 'gitHubUser', columns: 20
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
                        label 'Year:'
                    }
                    td {
                        textField id: 'year', columns: 5, text: address.year
                    }
                } // end of tr

                tr {
                    td {
                        label ' '
                    }
                    td {
                        label ' '
                    }
                } // end of tr

                tr {
                    td {
                        label 'Following Values '
                    }
                    td {
                        label 'Are Physical Folder Locations '
                    }
                } // end of tr

                tr {
                    td {
                        label 'Root Folder:'
                    }
                    td {
                        textField id: 'pr', columns: 30, address.projectRoot
                    }
                } // end of tr

                tr {
                    td {
                        label 'Project Folder:'
                    }
                    td {
                        textField id: 'projectName', columns: 20, address.projectName
                    }
                } // end of tr                                


                tr {
                    td {
                        label 'Project Location:'
                    }
                    td {
                        textField id: 'projectLocation', columns: 25, address.projectLocation
                    }
                } // end of tr                                

                tr {
                    td {
                        label ' '
                    }
                    td {
                        label ' '
                    }
                } // end of tr


                tr {
                    td {
                        label 'Following Values '
                    }
                    td {
                        label 'Inserted Into Generated Source '
                    }
                } // end of tr

                                                                
                tr {
                    td {
                        label 'Src Folder :'
                    }
                    td {
                        textField id: 'packageFolder', columns: 25, address.packageFolder
                    }
                } // end of tr
                
                tr {
                    td {
                        label 'Package :'
                    }
                    td {
                        textField id: 'packageName', columns: 25, address.packageName
                    }
                } // end of tr

                tr {
                    td {
                        label 'Src Pkg Prefix :'
                    }
                    td {
                        textField id: 'packagePrefix', columns: 25, address.packagePrefix
                    }
                } // end of tr
                


                tr {
                    td {
                        label ' '
                    }
                    td {
                        label ' '
                    }
                } // end of tr

                tr {
                    td {
                        label 'Following Values '
                    }
                    td {
                        label 'Generate Source Code Classes'
                    }
                } // end of tr
                
                tr {
                    td {
                        label 'First Class :'
                    }
                    td {
                        textField id: 'cn', columns: 25, address.className
                    }
                } // end of tr
                
                tr {
                    td {
                        label 'More Classes :'
                    }
                    td {
                        textField id: 'cs', columns: 25, address.classes
                    }
                } // end of tr
                
            } // end of tableLayout            
        } // end of panel

        panel(constraints: BorderLayout.SOUTH,maximumSize:[250, 50],background:Color.WHITE ) {
            hbox{
                button text: 'O k', actionPerformed: { System.exit(0); }
                button text: 'Save', actionPerformed: { address.dump(); exit.requestFocus();}
                button id: 'exit', text: 'Exit', actionPerformed: { System.exit(0); }
            } // end of hbox
        } // end of panel
        
        
        // Binding of textfield's to address object.
        bean address, 
            gitHubUser: bind { gitHubUser.text }, 
            author: bind { author.text },
            year: bind { year.text }, 
            projectName: bind { projectName.text },
            packageName: bind { packageName.text },
            packageFolder: bind { packageFolder.text },
            packagePrefix: bind { packagePrefix.text },
            className: bind { cn.text },
            email: bind { email.text },
            classes: bind { cs.text }
            projectRoot: bind { pr.text }
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

        Dialog obj;
		if (args.size() > 0)
		{
			obj = new Dialog(args[1].toString());
			println "... projectDir:"+args[1];
		} // end of if
		else
		{
	        obj = new Dialog();
    	} // end of else
    	    
		obj.build();        
        println "Dialog = [${obj.toString()}]"
        println "--- the end of Dialog ---"
    } // end of main

} // end of class