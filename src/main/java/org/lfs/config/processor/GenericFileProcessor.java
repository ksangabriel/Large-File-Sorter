package org.lfs.config.processor;

import org.lfs.config.Configurable;

public abstract class GenericFileProcessor implements FileProcessor {

	private FileReader fileReader = null;
	private Configurable configurable = null;
	
	@Override
	public void process(Configurable configurable) throws Exception {
		fileReader.readAndProcess(configurable);
	}
	
	public FileReader getFileReader() {
		return fileReader;
	}

	public void setFileReader(FileReader fileReader) {
		this.fileReader = fileReader;
	}

	public Configurable getConfigurable() {
		return configurable;
	}

	public void setConfigurable(Configurable configurable) {
		this.configurable = configurable;
	}
}
