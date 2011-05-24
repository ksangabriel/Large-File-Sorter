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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;

import org.apache.commons.lang.StringUtils;
import org.lfs.common.dao.util.SQLTool;
import org.lfs.common.entity.FileColumn;
import org.lfs.common.entity.FileConfig;
import org.lfs.common.entity.FileSet;
import org.lfs.common.entity.FileValidation;
import org.lfs.config.Configurable;

public class TextFileReader extends GenericFileReader {
	
	@Override
	public void readAndProcess(Configurable configurable) throws Exception {
			String i = SQLTool.generateSQLCommand("create_table", configurable);
			int ii = 0;
			ii = 9;

		
	}
	
	
	// true - file is valid
	private boolean readFileValidate(Configurable configurable) throws IOException {
		FileSet fs = (FileSet)configurable;
		
		boolean validateFile = false;
		int chars = -1;
		
    	for(FileValidation fv: fs.getFileValidation()) {
    		validateFile = fv.isValidate();
    		chars = fv.getCharacterCountPerLine();
    		break;
    	}

    	if(validateFile == true) {
    		BufferedReader br = new BufferedReader(
   				new FileReader(fs.getSourceDir() + fs.getFileNameInRegExpr()));
		
    		String line = null;			
    		while((line = br.readLine()) != null) {
    			if(line.length() != chars) {
	    			//error
	    		} else {	    				
	    			for(FileColumn fc: fs.getFileColumns()) {
	    				String tmp = line.substring(fc.getStartIndex(), fc.getEndIndex());
	    					// validate tmp
	    			}
	    				// validate each column
	    		}
			}
	    }	    	
    	return false;
	}
	

}
