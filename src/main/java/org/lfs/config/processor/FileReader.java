package org.lfs.config.processor;

import org.lfs.config.Configurable;

public interface FileReader {
	
	public void readAndProcess(Configurable configurable) throws Exception;
}
