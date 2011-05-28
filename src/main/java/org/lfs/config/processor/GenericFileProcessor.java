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

import org.lfs.common.dao.AppDAO;
import org.lfs.config.file.ConfigurableFile;

public abstract class GenericFileProcessor implements FileProcessor {
	

	protected FileReader fileReader = null;
	protected ConfigurableFile configurable = null;
	private AppDAO appDAO = null;
	
//	@Override
//	public void process(Configurable configurable) throws Exception {
//		fileReader.readAndProcess(configurable);
//	}

	public void setFileReader(FileReader fileReader) {
		this.fileReader = fileReader;
	}

	public void setConfigurable(ConfigurableFile configurable) {
		this.configurable = configurable;
	}
	
	@Override
	public void run() {
		try {
			this.process();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void process() throws Exception {
		
		// what if configurable is null?
		fileReader.readAndProcess(configurable);
	}

}
