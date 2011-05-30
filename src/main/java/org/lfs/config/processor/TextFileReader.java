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

package org.lfs.config.processor;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.lfs.common.entity.FileColumn;
import org.lfs.config.file.ConfigurableFile;

public class TextFileReader extends GenericFileReader {
	
	private FileValidator fileValidator = new TextFileValidator();
	
	@Override
	protected boolean validateConfig(ConfigurableFile configurableFile) {
		if(isColumnOverlapping(configurableFile)) {
			return false;
		}
		return true;
	}
	
	private boolean isColumnOverlapping(ConfigurableFile configurableFile) {
    	// always check if column indexes overlap
    	List<FileColumn> fileCols = configurableFile.getFileColumns();
		for(int i = 0; i < fileCols.size(); i++) {
			for(int j = i + 1; j < fileCols.size(); j++ ) {
				int startIndex = fileCols.get(i).getStartIndex();
				int endIndex = fileCols.get(i).getEndIndex();
				
				if( (startIndex > fileCols.get(j).getStartIndex()
						&& startIndex < fileCols.get(j).getEndIndex()) 
						|| 
					(endIndex > fileCols.get(j).getStartIndex() 
						&& endIndex < fileCols.get(j).getEndIndex())) {
					// if startIndex is between other columns' startIndex and endIndex
					// or
					// if endIndex is between other columns' startIndex and endIndex
					return true; 
				}
			}	
		}
		return false;
	}
	
	
	@Override
	public void readAndProcess(ConfigurableFile configurableFile) throws Exception {
		boolean error = false;
		
		
		// need to check if FileColumn indexes are overlapping to each others'
		if(!validateConfig(configurableFile)) {
			return;
		}
		
		FileInputStream fstream = new FileInputStream(
				configurableFile.getSourceDir() + 
				configurableFile.getFileNameInRegExpr());
		
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String strLine;
		while ((strLine = br.readLine()) != null) {
			
			if(StringUtils.startsWith(strLine, "#~")) {
				break; 
			}
			
			if(userDebugMode != null) {
				userDebugMode.debugLine(configurableFile, strLine);
			}
			
			if(debugMode != null) {
				debugMode.debugLine(configurableFile, strLine);
			}
			
			if(!this.fileValidator.validateLine(
					configurableFile, strLine)) {
				error = true;
				break;
			}
		}
		//Close the input stream
		in.close();
	}
	

//	String i = SQLTool.generateSQLCommand("create_table", configurable);
//	int ii = 0;
//	ii = 9;
}
