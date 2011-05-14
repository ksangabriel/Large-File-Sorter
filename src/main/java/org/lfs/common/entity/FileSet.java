package org.lfs.common.entity;

import java.util.ArrayList;
import java.util.List;


public class FileSet extends AbstractEntity {
	
	private List<FileColumn> fileColumn = new ArrayList<FileColumn>(); 
    private int lineLength;
    private String sourceDir;
    private String destDir;
    private String fileNameInRegExpr;
	
	public void addFileColumn(FileColumn fileColumn) {
		this.fileColumn.add(fileColumn);
	}

	public List<FileColumn> getFileColumn() {
		return fileColumn;
	}

	public void setFileColumn(List<FileColumn> fileColumn) {
		this.fileColumn = fileColumn;
	}

	public int getLineLength() {
		return lineLength;
	}

	public void setLineLength(int lineLength) {
		this.lineLength = lineLength;
	}

	public String getSourceDir() {
		return sourceDir;
	}

	public void setSourceDir(String sourceDir) {
		this.sourceDir = sourceDir;
	}

	public String getDestDir() {
		return destDir;
	}

	public void setDestDir(String destDir) {
		this.destDir = destDir;
	}

	public String getFileNameInRegExpr() {
		return fileNameInRegExpr;
	}

	public void setFileNameInRegExpr(String fileNameInRegExpr) {
		this.fileNameInRegExpr = fileNameInRegExpr;
	}
}
