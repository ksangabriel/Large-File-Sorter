package org.lfs.config;

import java.util.ArrayList;
import java.util.List;

import org.lfs.common.AbstractEntity;

public class FileSet extends AbstractEntity {
	
	private List<FileColumn> fileColumn = new ArrayList<FileColumn>(); 

	public void addFileColumn(FileColumn fileColumn) {
		this.fileColumn.add(fileColumn);
	}
}
