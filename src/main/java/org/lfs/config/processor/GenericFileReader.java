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

import org.lfs.config.file.ConfigurableFile;
import org.lfs.config.processor.debug.FileDebug;

public abstract class GenericFileReader implements FileReader {
	
	protected FileDebug userDebugMode = null;
	protected FileDebug debugMode     = null;
	
	protected abstract boolean validateConfig(ConfigurableFile configurable);

	public FileDebug getUserDebugMode() {
		return userDebugMode;
	}

	public void setUserDebugMode(FileDebug userDebugMode) {
		this.userDebugMode = userDebugMode;
	}

	public FileDebug getDebugMode() {
		return debugMode;
	}

	public void setDebugMode(FileDebug debugMode) {
		this.debugMode = debugMode;
	} 
}
