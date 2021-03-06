/*

   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

 */

package org.lfs;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.lfs.common.entity.AbstractEntity;
import org.lfs.common.entity.FileColumn;
import org.lfs.common.entity.FileConfig;
import org.lfs.common.entity.FileSet;
import org.lfs.config.AppContext;
import org.lfs.config.file.ConfigurableFile;
import org.lfs.config.processor.FileProcessor;
import org.lfs.config.processor.TextFileProcessor;
import org.lfs.config.processor.TextFileReader;
import org.lfs.config.processor.debug.TextFileDebug;
import org.lfs.config.processor.debug.TextFileUserDebug;

public class Main extends AbstractEntity {
	
	private Configuration config = null;
	
	private AppContext appContext = new AppContext();
	
	private void readConfigFile() throws ConfigurationException {
		this.config =  new PropertiesConfiguration("config.properties");
		
		if(config.containsKey("fileconfig")) {
			appContext.getApplicationConfig().setFileConfigPath(config.getString("fileconfig"));
		}
		
		if(config.containsKey("filethreads")) {
			appContext.getApplicationConfig().setMaxFileThreads(config.getInt("filethreads"));
		}
		return;
	}
	
	private void doIt() throws IOException {
	
		
		FileConfig fileConfig = appContext.getApplicationConfig().getFileConfig();
		
		
		Collection<FileSet> fileSetList = fileConfig.getFileSet();
		for(FileSet fs: fileSetList) {
			/* A fileset contains:
			 * 1. a set of general rules to validate the files
			 * 2. a set of column mappings 
			 * 3. a set of rules for each column mapping to 
			 *    validate the column's content
			 * 4. a set of actions for each column to perform
			 *    against the column's content
			 * 5. a source directory where to read the files
			 * 6. a destination directory where to save the processed files
			 * 7. an ordered list of actions. Example:
			 * 
			 * 		<content-process index="0">
			 * 			<action>validate</action>
			 * 		</content-process>
			 *   
			 *      <content-process index="1">
			 * 			<action>sort</action> <-- how is the sorting?
			 * 		</content-process>  
			 */
			//if(!areColumnsNonOvelapping(fs)) {
			//	return; // or throw exception
			//}
			
			try {
				
				TextFileReader txr = new TextFileReader();
				txr.setDebugMode(new TextFileDebug()); // pluggable
				txr.setDebugMode(new TextFileUserDebug()); // pluggable
				
				TextFileProcessor tp = new TextFileProcessor(fs, txr);
				Thread t = new Thread(tp);
				t.start();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	

	
	public void process() throws ConfigurationException, IOException {
		this.readConfigFile();
		this.doIt();
	}

}
