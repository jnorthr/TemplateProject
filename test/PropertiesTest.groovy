${packagename}

// To support Spock Test Framework - uncomment @Grab lines if compiling directly with groovyc and not gradle build tool
//@Grab('org.spockframework:spock-core:1.1-groovy-2.4')
import spock.lang.*

// To support the feature to copy stdout and stderr module output as a redirect back to the spock framework
//@Grab('org.springframework.boot:spring-boot:1.2.1.RELEASE')
import org.springframework.boot.test.OutputCapture

/*
 * Copyright ${year} the original author ${author} or authors.
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

class PropertiesTest extends spock.lang.Specification {
    @Shared
	year ='2017'

    @Shared
	alias ="jnorthr"

    @Shared
	author ="Jim Northrop"

    @Shared
	projectname="Toolkit"

    @Shared
	packagename ="package com.jim.toolkit;"

    @Shared
	packagefolder="/com/jim/toolkit"

    @Shared
	packageid="com.jim.toolkit."

    @Shared
	classname="Tools"


	@org.junit.Rule
	OutputCapture capture = new OutputCapture()

	// run before the first feature method
	def setupSpec() 
	{
	} // end of setupSpec()     

	// run before every feature method
	def setup() 
	{
	}          

	// run after every feature method
	def cleanup() 
	{

	}        

	// run after the last feature method	
	def cleanupSpec() 
	{
		println "end of testing for PropertiesTest "
	}   
 
 
    // First Test
  	def "Build default PropertiesTest"() {
  		when:     'default PropertiesTest has been built'

		then:     
			year == "${year}"
			alias == "${alias}"
			author == "${author}"
			projectname == "${projectname}"
			classname == "${classname}"
			packagename == "${packagename}"
			packageid == "${packageid}"
			packagefolder == "${packagefolder}"

  	} // end of feature method

} // end of class