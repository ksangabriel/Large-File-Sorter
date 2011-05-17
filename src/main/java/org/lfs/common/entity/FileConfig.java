package org.lfs.common.entity;

import java.util.ArrayList;
import java.util.List;

import org.lfs.config.Configurable;


public class FileConfig extends AbstractEntity implements Configurable {
	private List<FileSet> fileSet = new ArrayList<FileSet>();
	
	public void addFileSet(FileSet fileSet) {
		this.fileSet.add(fileSet);
	}
	
	public List<FileSet> getFileSet() {
		return this.fileSet;
	}
}
