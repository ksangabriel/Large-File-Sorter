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


public class FileColumn extends AbstractEntity {
	
	public static String STRING = "string";
	public static String INTEGER = "int";

	private int startIndex;
	private int endIndex;
	private int dataLength;
	private String type;
	private String sortOrder;
	private String validateValueFormat;
	private String validateValue;
	
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getEndIndex() {
		return endIndex;
	}
	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}
	public String getValidateValueFormat() {
		return validateValueFormat;
	}
	public void setValidateValueFormat(String validateValueFormat) {
		this.validateValueFormat = validateValueFormat;
	}
	public String getValidateValue() {
		return validateValue;
	}
	public void setValidateValue(String validateValue) {
		this.validateValue = validateValue;
	}
	public void setDataLength(int dataLength) {
		this.dataLength = dataLength;
	}
	public int getDataLength() {
		return dataLength;
	}	
	
}
