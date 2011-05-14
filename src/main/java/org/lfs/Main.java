package org.lfs;

import java.io.IOException;
import java.util.List;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.lfs.common.entity.AbstractEntity;
import org.lfs.common.entity.FileConfig;
import org.lfs.common.entity.FileSet;
import org.lfs.config.AppContext;

public class Main extends AbstractEntity {
	
	private Configuration config = null;
	
	private AppContext appContext = new AppContext();
	
	private void readConfigFile() throws ConfigurationException {
		this.config =  new PropertiesConfiguration("config.properties");
		
		if(config.containsKey("fileconfig")) {
			appContext.getApplicationConfig().setFileConfigPath(config.getString("fileconfig"));
		}
		
		if(config.containsKey("filethreads")) {
			appContext.getApplicationConfig().setMaxFileThreads(config.getInt("filethreads"));
		}
		return;
	}
	
	private void doIt() throws IOException {
		Reader lfsReader = new Reader();
		FileConfig fileConfig = appContext.getApplicationConfig().getFileConfig();
		List<FileSet> colFileSet = fileConfig.getFileSet();
		
		for(FileSet fileSet : colFileSet) {
			lfsReader.readFile(fileSet);
		}
		
		
	}
	
	public void process() throws ConfigurationException, IOException {
		this.readConfigFile();
		this.doIt();
	}

}
