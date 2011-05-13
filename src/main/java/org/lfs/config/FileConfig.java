package org.lfs.config;

import java.util.ArrayList;
import java.util.List;

import org.lfs.common.AbstractEntity;

public class FileConfig extends AbstractEntity {
	private List<FileSet> fileSet = new ArrayList<FileSet>();
	
	public void addFileSet(FileSet fileSet) {
		this.fileSet.add(fileSet);
	}
}
