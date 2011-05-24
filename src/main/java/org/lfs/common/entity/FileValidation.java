package org.lfs.common.entity;

public class FileValidation extends AbstractEntity {

	private boolean validate;
	private int characterCountPerLine;
	
	public boolean isValidate() {
		return validate;
	}
	public void setValidate(boolean validate) {
		this.validate = validate;
	}
	public int getCharacterCountPerLine() {
		return characterCountPerLine;
	}
	public void setCharacterCountPerLine(int characterCountPerLine) {
		this.characterCountPerLine = characterCountPerLine;
	}
}
