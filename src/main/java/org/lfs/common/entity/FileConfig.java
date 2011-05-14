package org.lfs.common.entity;

import java.util.ArrayList;
import java.util.List;


public class FileConfig extends AbstractEntity {
	private List<FileSet> fileSet = new ArrayList<FileSet>();
	
	public void addFileSet(FileSet fileSet) {
		this.fileSet.add(fileSet);
	}
	
	public List<FileSet> getFileSet() {
		return this.fileSet;
	}
}
