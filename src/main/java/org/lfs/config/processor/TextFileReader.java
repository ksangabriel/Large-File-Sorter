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
import org.lfs.config.file.ConfigurableFile;

public class TextFileReader extends GenericFileReader {
	
	private FileValidator fileValidator = new TextFileValidator();
	
	@Override
	public void readAndProcess(ConfigurableFile configurable) throws Exception {

		if(!this.fileValidator.validateFile(configurable)) {
			return;
		}

		
		
	}
	
	
	// true - file is valid
	private boolean readFileValidate(ConfigurableFile configurable) throws IOException {
		
		
		
		
		return false;

	}
	

//	String i = SQLTool.generateSQLCommand("create_table", configurable);
//	int ii = 0;
//	ii = 9;
}
