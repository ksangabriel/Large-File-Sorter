package org.lfs;

import java.io.File;
import java.util.Locale;

import org.apache.commons.digester.Digester;
import org.apache.commons.validator.routines.IntegerValidator;
import org.lfs.common.entity.FileColumn;
import org.lfs.common.entity.FileConfig;
import org.lfs.common.entity.FileSet;
import org.lfs.config.ApplicationConfig;

public class App {
    public static void main( String[] args ) throws Exception {

    	Main lfs = new Main();
    	lfs.process();

    }
    


}
