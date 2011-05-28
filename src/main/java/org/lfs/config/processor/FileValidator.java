package org.lfs.config.processor;

import org.lfs.config.file.ConfigurableFile;

public interface FileValidator {
	
	public boolean validateFile(ConfigurableFile configurable);
}
