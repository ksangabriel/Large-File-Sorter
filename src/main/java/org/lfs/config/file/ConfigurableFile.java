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

package org.lfs.config.file;

import java.util.List;

import org.lfs.common.entity.FileColumn;
import org.lfs.common.entity.FileSet;
import org.lfs.common.entity.FileValidation;
import org.lfs.config.Configurable;
import org.lfs.config.processor.debug.FileDebug;

public interface ConfigurableFile extends Configurable {
	public boolean getUserDebugMode();
	public boolean getDebugMode();
	public List<FileValidation> getFileValidation();
	public List<FileSet> getFileSet();
	public String getSourceDir();
	public String getFileNameInRegExpr();
	public List<FileColumn> getFileColumns();
}
