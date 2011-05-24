package org.lfs.config.processor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.lfs.common.entity.AbstractEntity;
import org.lfs.common.entity.FileColumn;
import org.lfs.common.entity.FileSet;

public class Reader extends AbstractEntity implements Runnable {

	
	
	public static void readFileValidate(FileSet fileSet) throws IOException {
		BufferedReader br = new BufferedReader(
				new FileReader(fileSet.getSourceDir() + fileSet.getFileNameInRegExpr()));
		
		String line = null;
		int count = 0;
		
		
		
		while((line = br.readLine()) != null) {
			count++;
			
			
    	}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
//	BufferedReader br = new BufferedReader(
//			new FileReader(fileSet.getSourceDir() + fileSet.getFileNameInRegExpr()));
//	
//	String line = null;
//	int count = 0;
//	while((line = br.readLine()) != null) {
//		count++;
//		//for(FileColumn fileCol : fileSet.getFileColumn()) {
//		//	System.out.println(fileCol.getId() + ":" + 
//		//	StringUtils.substring(line, fileCol.getStartIndex(), 
//		//			fileCol.getEndIndex()));
//		//}
//		System.out.println("count:" + count);
//		
//		

}
