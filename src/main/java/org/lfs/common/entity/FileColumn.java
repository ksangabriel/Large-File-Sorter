package org.lfs.common.entity;


public class FileColumn extends AbstractEntity {
	
	public static String STRING = "string";
	public static String INTEGER = "int";

	private int startIndex;
	private int endIndex;
	private String type;
	private String sortOrder;
	private String validateValueFormat;
	private String validateValue;
	
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getEndIndex() {
		return endIndex;
	}
	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}
	public String getValidateValueFormat() {
		return validateValueFormat;
	}
	public void setValidateValueFormat(String validateValueFormat) {
		this.validateValueFormat = validateValueFormat;
	}
	public String getValidateValue() {
		return validateValue;
	}
	public void setValidateValue(String validateValue) {
		this.validateValue = validateValue;
	}
	
}
