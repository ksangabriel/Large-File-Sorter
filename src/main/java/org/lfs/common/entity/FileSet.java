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


public class FileSet extends AbstractEntity {
	
	private List<String> fileNames = new ArrayList<String>();
	private List<FileColumn> fileColumn = new ArrayList<FileColumn>(); 
    private int lineLength;
    private String sourceDir;
    private String destDir;
    private String fileNameInRegExpr;
	
	public List<String> getFileNames() {
		return fileNames;
	}

	public void setFileNames(List<String> fileNames) {
		this.fileNames = fileNames;
	}

    
	public void addFileColumn(FileColumn fileColumn) {
		this.fileColumn.add(fileColumn);
	}

	public List<FileColumn> getFileColumn() {
		return fileColumn;
	}

	public void setFileColumn(List<FileColumn> fileColumn) {
		this.fileColumn = fileColumn;
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
		this.sourceDir = sourceDir;
	}

	public String getDestDir() {
		return destDir;
	}

	public void setDestDir(String destDir) {
		this.destDir = destDir;
	}

	public String getFileNameInRegExpr() {
		return fileNameInRegExpr;
	}

	public void setFileNameInRegExpr(String fileNameInRegExpr) {
		this.fileNameInRegExpr = fileNameInRegExpr;
	}
}
