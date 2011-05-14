package org.lfs.config;

import java.io.File;
import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.lfs.common.entity.AbstractEntity;
import org.lfs.common.entity.FileColumn;
import org.lfs.common.entity.FileConfig;
import org.lfs.common.entity.FileSet;
import org.xml.sax.SAXException;

public class ApplicationConfig extends AbstractEntity {
	
	private int maxFileThreads = 5;
	private String fileConfigPath = null;
	private FileConfig fileConfig = null;
	
	public FileConfig getFileConfig() {
		return fileConfig;
	}


	public String getFileConfigPath() {
		return fileConfigPath;
	}

	public void setFileConfigPath(String fileConfigPath) {
		
		if(fileConfigPath != null) {
			this.fileConfigPath = fileConfigPath;
			this.fileConfig = this.generateBeanFromXML();
		}
	}
	
	private FileConfig generateBeanFromXML() {
		Digester digester = new Digester();
        digester.setValidating( false );

        digester.addObjectCreate( "file-config", FileConfig.class );
        digester.addObjectCreate( "file-config/file-set", FileSet.class );
        digester.addBeanPropertySetter( "file-config/file-set/validate-file/line-char-length", "lineLength");
        digester.addBeanPropertySetter( "file-config/file-set/src-dir", "sourceDir");
        digester.addBeanPropertySetter( "file-config/file-set/dest-dir", "destDir");
        digester.addBeanPropertySetter( "file-config/file-set/file-name", "fileNameInRegExpr");
        digester.addObjectCreate( "file-config/file-set/column", FileColumn.class );
        digester.addBeanPropertySetter( "file-config/file-set/column/id", "id" );
        digester.addBeanPropertySetter( "file-config/file-set/column/start", "startIndex" );
        digester.addBeanPropertySetter( "file-config/file-set/column/end", "endIndex" );
        digester.addBeanPropertySetter( "file-config/file-set/column/type", "type" );
        digester.addBeanPropertySetter( "file-config/file-set/column/description", "description" );
        digester.addBeanPropertySetter( "file-config/file-set/column/sort", "sortOrder" );
        digester.addBeanPropertySetter( "file-config/file-set/column/trim", "trim" );
        digester.addBeanPropertySetter( "file-config/file-set/column/validate-format", "validateValueFormat" );
        digester.addBeanPropertySetter( "file-config/file-set/column/validate-value", "validateValue" );
        
        digester.addSetProperties( "file-config/file-set/column", "id", "id" );
        digester.addSetProperties( "file-config/file-set/column", "start", "startIndex" );
        digester.addSetProperties( "file-config/file-set/column", "end", "endIndex" );
        digester.addSetProperties( "file-config/file-set/column", "type", "type" );     
        digester.addSetProperties( "file-config/file-set/column", "description", "description" ); 
        digester.addSetProperties( "file-config/file-set/column", "sort", "sortOrder" ); 
        digester.addSetProperties( "file-config/file-set/column", "trim", "trim" ); 
        digester.addSetProperties( "file-config/file-set/column", "validate-format", "validateValueFormat" );
        digester.addSetProperties( "file-config/file-set/column", "validate-value", "validateValue" );
        digester.addSetNext( "file-config/file-set/column", "addFileColumn");
        digester.addSetNext( "file-config/file-set", "addFileSet" );
        File input = new File(this.fileConfigPath);
        FileConfig c = null;
		try {
			c = (FileConfig)digester.parse(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return c;
	}

	public int getMaxFileThreads() {
		return maxFileThreads;
	}

	public void setMaxFileThreads(int maxFileThreads) {
		this.maxFileThreads = maxFileThreads;
	}

}
