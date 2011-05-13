package org.lfs;

import java.io.File;
import java.util.Locale;

import org.apache.commons.digester.Digester;
import org.apache.commons.validator.routines.IntegerValidator;
import org.lfs.config.ApplicationConfig;
import org.lfs.config.FileColumn;
import org.lfs.config.FileConfig;
import org.lfs.config.FileSet;

public class App {
    public static void main( String[] args ) throws Exception {

    	ApplicationConfig appConfig = new ApplicationConfig();
    	FileConfig fileConfig = appConfig.getFileConfig();
    	
    	int o = 0;
    	
        // Get the Integer validator
        IntegerValidator validator = IntegerValidator.getInstance();

        // Validate/Convert the number
        Integer fooInteger = validator.validate("33311221.00", "#,##0.00", Locale.GERMAN);
        if (fooInteger == null) {
            System.out.println(fooInteger);
            return;
        }

        System.out.println("DDD");
        
        boolean caseSensitive   = false;
        String regex            = "^([A-Z]*)(?:\\-)([A-Z]*)$";

        // validate - result should be a String of value "abcdef"
        String result = RegexValidator.validate("abc-def", regex, caseSensitive);



    }
    


}
