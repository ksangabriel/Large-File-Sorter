package org.lfs;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.lfs.common.entity.AbstractEntity;
import org.lfs.common.entity.FileConfig;
import org.lfs.common.entity.FileSet;
import org.lfs.config.AppContext;
import org.lfs.config.processor.FileProcessor;
import org.lfs.config.processor.TextFileProcessor;
import org.lfs.config.processor.TextFileReader;

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
		FileProcessor fileProc = new TextFileProcessor();
		
		FileConfig fileConfig = appContext.getApplicationConfig().getFileConfig();
		fileProc.setFileReader(new TextFileReader());
		
		Collection<FileSet> fileSetList = fileConfig.getFileSet();
		for(FileSet fs: fileSetList) {
		
		try {
			fileProc.process(fs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
	}
	
	public void process() throws ConfigurationException, IOException {
		this.readConfigFile();
		this.doIt();
	}

}
