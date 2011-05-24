package org.lfs;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.lfs.common.entity.AbstractEntity;
import org.lfs.common.entity.FileColumn;
import org.lfs.common.entity.FileConfig;
import org.lfs.common.entity.FileSet;
import org.lfs.config.AppContext;
import org.lfs.config.Configurable;
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
	
		
		FileConfig fileConfig = appContext.getApplicationConfig().getFileConfig();
		
		
		Collection<FileSet> fileSetList = fileConfig.getFileSet();
		for(FileSet fs: fileSetList) {
			/* A fileset contains:
			 * 1. a set of general rules to validate the files
			 * 2. a set of column mappings 
			 * 3. a set of rules for each column mapping to 
			 *    validate the column's content
			 * 4. a set of actions for each column to perform
			 *    against the column's content
			 * 5. a source directory where to read the files
			 * 6. a destination directory where to save the processed files
			 * 7. an ordered list of actions. Example:
			 * 
			 * 		<content-process index="0">
			 * 			<action>validate</action>
			 * 		</content-process>
			 *   
			 *      <content-process index="1">
			 * 			<action>sort</action> <-- how is the sorting?
			 * 		</content-process>  
			 */
			if(!areColumnsNonOvelapping(fs)) {
				return; // or throw exception
			}
			
			try {
				TextFileProcessor tp = new TextFileProcessor(fs, new TextFileReader());
				Thread t = new Thread(tp);
				t.start();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	/* Should not be in a "File" validator because we are only checking the some of the contents of the xml file */ 
	public boolean areColumnsNonOvelapping(Configurable configurable) {
		FileSet fs = (FileSet) configurable;
		
		List<FileColumn> fileCols = fs.getFileColumns();
		
		// What if the user wants to specify the start index and the no. of characters?
		for(int i = 0; i < fileCols.size(); i++) {
			for(int j = i + 1; j < fileCols.size(); j++) {
				if(fileCols.get(i).getStartIndex() >= fileCols.get(j).getStartIndex() 
						&& fileCols.get(j).getStartIndex() <= fileCols.get(i).getEndIndex()) {
					return false;
				}
				
				if(fileCols.get(i).getStartIndex() >= fileCols.get(j).getEndIndex()  
						&& fileCols.get(j).getEndIndex() <= fileCols.get(i).getEndIndex()) {
					return false;
				}
				
			}
		}
		
		return true;
	}
	
	public void process() throws ConfigurationException, IOException {
		this.readConfigFile();
		this.doIt();
	}

}
