package org.lfs.config.processor;

import org.lfs.config.Configurable;

public interface FileProcessor {

	public void process(Configurable configurable) throws Exception;
}
