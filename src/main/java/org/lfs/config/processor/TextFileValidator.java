package org.lfs.config.processor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.lfs.common.entity.FileColumn;
import org.lfs.common.entity.FileSet;
import org.lfs.common.entity.FileValidation;
import org.lfs.config.file.ConfigurableFile;

public class TextFileValidator extends GenericFileValidator {

	private boolean isColumnOverlapping(ConfigurableFile configurableFile) {
    	// always check if column indexes overlap
    	List<FileColumn> fileCols = configurableFile.getFileColumns();
		for(int i = 0; i < fileCols.size(); i++) {
			for(int j = i + 1; j < fileCols.size(); j++ ) {
				int startIndex = fileCols.get(i).getStartIndex();
				int endIndex = fileCols.get(i).getEndIndex();
				
				if( (startIndex > fileCols.get(j).getStartIndex()
						&& startIndex < fileCols.get(j).getEndIndex()) 
						|| 
					(endIndex > fileCols.get(j).getStartIndex() 
						&& endIndex < fileCols.get(j).getEndIndex())) {
					// if startIndex is between other columns' startIndex and endIndex
					// or
					// if endIndex is between other columns' startIndex and endIndex
					return true; 
				}
			}	
		}
		return false;
	}
	
	
	// ** need to change. just read files in one place. 
	@Override
	public boolean validateFile(ConfigurableFile configurableFile)  {
		boolean validateFile = false;
		int noOfCharsPerLine = -1;
		
    	for(FileValidation fv: configurableFile.getFileValidation()) {
    		validateFile = fv.isValidate();
    		noOfCharsPerLine = fv.getCharacterCountPerLine();
    		break; // we'll just get one
    	}

    	if(this.isColumnOverlapping(configurableFile)) return false;
    	
    	if(validateFile) {
    		BufferedReader br = null;
			br = new BufferedReader(
					new FileReader(
							configurableFile.getSourceDir() + configurableFile.getFileNameInRegExpr()));
    		
    		String line = null;			
			while((line = br.readLine()) != null) {
				if(line.length() == noOfCharsPerLine) {
					for(FileColumn fc: configurableFile.getFileColumns()) {
						String tmp = line.substring(fc.getStartIndex(), fc.getEndIndex());
							// validate tmp
					}
						// validate each column
				} else {
					// throw exception
				}
			}
	    }	    	
    	return false;
	}
}
