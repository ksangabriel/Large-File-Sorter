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

package org.lfs.common.dao.util;

import java.util.Collection;

import org.apache.commons.lang.StringUtils;
import org.lfs.common.entity.FileColumn;
import org.lfs.common.entity.FileConfig;
import org.lfs.common.entity.FileSet;
import org.lfs.config.file.ConfigurableFile;

public class SQLTool {
	
	private static String SQL_CREATE_TABLE = "create_table";
	private static String SQL_DROP_TABLE   = "drop_table";
	private static String SQL_TYPE_STRING  = "string";
	private static String SQL_TYPE_DATE    = "date"; // java.sql.Date
	
	public static String generateSQLCommand(String commandType, ConfigurableFile configurable) {
		
		StringBuilder sb = new StringBuilder();
		
		if(commandType.equals(SQL_CREATE_TABLE)) {
			sb.append(createSQLCreateTable(configurable));
		}
		
		if(commandType.equals(SQL_DROP_TABLE)) {
			sb.append(createSQLCreateTable(configurable));
		}
		return sb.toString();
	}
	
	private static String generateType(String type, int size) {
		StringBuilder sb = new StringBuilder();
		
		if(type.equalsIgnoreCase("string")) {
			sb.append("varchar(").append(size).append(")");
		}
		
		if(type.equalsIgnoreCase("date")) {
			sb.append("date");
		}
		
		if(type.equalsIgnoreCase("integer")) {
			sb.append("integer");
		}
		
		return sb.toString();
	}
	
	private static String createSQLCreateTable(ConfigurableFile configurable) {
		
		FileSet fs = (FileSet)configurable;
		
		StringBuilder sb = new StringBuilder();	    
	    
		    sb.append("create table ").append(
		    		StringUtils.replaceChars(
		    				fs.getFileNameInRegExpr(),
		    				".","_")); // table name should be unique for each FileSet object

		    sb.append("(");
	    	for(FileColumn col: fs.getFileColumns()) {
				sb.append(col.getId()).append(" ");
				sb.append(generateType(col.getType(), col.getDataLength())).append(",");
	    	}
	    	sb.delete(sb.length()-1, sb.length());
	    	sb.append(")");

		
	    
	    return sb.toString();
	}

}
