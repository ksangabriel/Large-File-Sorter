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

package org.lfs.common.entity;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.lfs.config.file.ConfigurableFile;


public class FileSet extends AbstractEntity implements ConfigurableFile {
	
	private String DEFAULT_SOURCE_DIR = "files/src"; 
	private String DEFAULT_DEST_DIR   = "files/dest"; 

	
	private List<String> fileNames = new ArrayList<String>();
	private List<FileColumn> fileColumns = new ArrayList<FileColumn>(); 
	private List<FileValidation> fileValidation = new ArrayList<FileValidation>();
	private int lineLength;
    private String sourceDir;
    private String destDir;
    private String fileNameInRegExpr;
	
	public void addFileValidation(FileValidation fileValidation) {
		this.fileValidation.add(fileValidation);
	}
	
	public List<FileValidation> getFileValidation() {
		return fileValidation;
	}    
    
	public List<String> getFileNames() {
		return fileNames;
	}

	public void setFileNames(List<String> fileNames) {
		this.fileNames = fileNames;
	}

    
	public void addFileColumn(FileColumn fileColumn) {
		this.fileColumns.add(fileColumn);
	}

	public List<FileColumn> getFileColumns() {
		return fileColumns;
	}

	public void setFileColumns(List<FileColumn> fileColumns) {
		this.fileColumns = fileColumns;
	}

	public int getLineLength() {
		return lineLength;
	}

	public void setLineLength(int lineLength) {
		this.lineLength = lineLength;
	}

	public String getSourceDir() {
		return sourceDir;
	}

	public void setSourceDir(String sourceDir) {
		this.sourceDir = StringUtils.defaultIfEmpty(sourceDir, this.DEFAULT_SOURCE_DIR);
	}

	public String getDestDir() {
		return destDir;
	}

	public void setDestDir(String destDir) {
		this.destDir = StringUtils.defaultIfEmpty(destDir, this.DEFAULT_DEST_DIR);
	}

	public String getFileNameInRegExpr() {
		return fileNameInRegExpr;
	}

	public void setFileNameInRegExpr(String fileNameInRegExpr) {
		this.fileNameInRegExpr = fileNameInRegExpr;
	}

	@Override
	public List<FileSet> getFileSet() {
		// TODO Auto-generated method stub
		return null;
	}
}
