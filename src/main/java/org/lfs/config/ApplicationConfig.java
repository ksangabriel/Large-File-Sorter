package org.lfs.config;

import java.io.File;
import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.lfs.common.AbstractEntity;
import org.xml.sax.SAXException;

public class ApplicationConfig extends AbstractEntity {

	private static FileConfig fileConfig = null;

	public static FileConfig getFileConfig() {
		Digester digester = new Digester();
        digester.setValidating( false );

        digester.addObjectCreate( "file-config", FileConfig.class );
        digester.addObjectCreate( "file-config/file-set", FileSet.class );
        digester.addObjectCreate( "file-config/file-set/column", FileColumn.class );
        digester.addBeanPropertySetter( "file-config/file-set/column/id", "id" );
        digester.addBeanPropertySetter( "file-config/file-set/column/start", "startIndex" );
        digester.addBeanPropertySetter( "file-config/file-set/column/end", "endIndex" );
        digester.addBeanPropertySetter( "file-config/file-set/column/type", "type" );
        digester.addBeanPropertySetter( "file-config/file-set/column/description", "description" );
        digester.addBeanPropertySetter( "file-config/file-set/column/sort", "sortOrder" );
        digester.addBeanPropertySetter( "file-config/file-set/column/validate-format", "validateValueFormat" );
        digester.addBeanPropertySetter( "file-config/file-set/column/validate-value", "validateValue" );
        digester.addSetProperties( "file-config/file-set/column", "id", "id" );
        digester.addSetProperties( "file-config/file-set/column", "start", "startIndex" );
        digester.addSetProperties( "file-config/file-set/column", "end", "endIndex" );
        digester.addSetProperties( "file-config/file-set/column", "type", "type" );     
        digester.addSetProperties( "file-config/file-set/column", "description", "description" ); 
        digester.addSetProperties( "file-config/file-set/column", "sort", "sortOrder" ); 
        digester.addSetProperties( "file-config/file-set/column", "validate-format", "validateValueFormat" );
        digester.addSetProperties( "file-config/file-set/column", "validate-value", "validateValue" );
        digester.addSetNext( "file-config/file-set/column", "addFileColumn");
        digester.addSetNext( "file-config/file-set", "addFileSet" );

        File input = new File( "/home/karl/Large-File-Sorter/1.xml"  );
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

	public static void setFileConfig(FileConfig fileConfig) {
		ApplicationConfig.fileConfig = fileConfig;
	}


}
