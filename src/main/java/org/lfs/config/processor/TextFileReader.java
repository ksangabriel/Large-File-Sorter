package org.lfs.config.processor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collection;

import org.lfs.common.entity.FileSet;
import org.lfs.config.ApplicationConfig;
import org.lfs.config.Configurable;

public class TextFileReader extends GenericFileReader {

	@Override
	public void readAndProcess(Configurable configurable) throws Exception {
		
		if(configurable instanceof ApplicationConfig) {
			ApplicationConfig appConfig = (ApplicationConfig) configurable;
			
			Collection<FileSet> fileSet = appConfig.getFileConfig().getFileSet();
			
			for(FileSet fs: fileSet) {
				String srcDir = fs.getSourceDir();
				String destDir = fs.getDestDir();
				String fileName = fs.getFileNameInRegExpr();
				
				BufferedReader br = new BufferedReader(
						new FileReader(srcDir + fileName));
				
				String line = null;
				int count = 0;
				while((line = br.readLine()) != null) {
					count++;
					//for(FileColumn fileCol : fileSet.getFileColumn()) {
					//	System.out.println(fileCol.getId() + ":" + 
					//	StringUtils.substring(line, fileCol.getStartIndex(), 
					//			fileCol.getEndIndex()));
					//}
					System.out.println("count:" + count);
					
					
		    	}
			}
			

		}
	}
}
