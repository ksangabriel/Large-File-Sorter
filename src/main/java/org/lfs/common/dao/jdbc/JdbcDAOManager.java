/*

   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

 */

package org.lfs.common.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.lfs.common.dao.DAOManager;

public class JdbcDAOManager implements DAOManager {

    /* the default framework is embedded*/
    private String framework = "embedded";
    private String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    private String protocol = "jdbc:derby:";
    private String derbyHomeSystem = "derby.system.home";
    
    private static JdbcDAOManager jdbcManager = null;
    

    private JdbcDAOManager() {
    	System.setProperty(derbyHomeSystem, "/home/karl");
    	
    }
	
	public JdbcDAOManager getInstance() {
		if(jdbcManager == null) {
			jdbcManager = new JdbcDAOManager();

		}
		return jdbcManager;
	}
	
	 /**
	  * Loads the appropriate JDBC driver for this environment/framework. For
	  * example, if we are in an embedded environment, we load Derby's
	  * embedded Driver, <code>org.apache.derby.jdbc.EmbeddedDriver</code>.
	  */
	 private void loadDriver() {
	     /*
	      *  The JDBC driver is loaded by loading its class.
	      *  If you are using JDBC 4.0 (Java SE 6) or newer, JDBC drivers may
	      *  be automatically loaded, making this code optional.
	      *
	      *  In an embedded environment, this will also start up the Derby
	      *  engine (though not any databases), since it is not already
	      *  running. In a client environment, the Derby engine is being run
	      *  by the network server framework.
	      *
	      *  In an embedded environment, any static Derby system properties
	      *  must be set before loading the driver to take effect.
	      */
	     try {
	         Class.forName(driver).newInstance();
	         System.out.println("Loaded the appropriate driver");
	     } catch (ClassNotFoundException cnfe) {
	         System.err.println("\nUnable to load the JDBC driver " + driver);
	         System.err.println("Please check your CLASSPATH.");
	         cnfe.printStackTrace(System.err);
	     } catch (InstantiationException ie) {
	         System.err.println(
	                     "\nUnable to instantiate the JDBC driver " + driver);
	         ie.printStackTrace(System.err);
	     } catch (IllegalAccessException iae) {
	         System.err.println(
	                     "\nNot allowed to access the JDBC driver " + driver);
	         iae.printStackTrace(System.err);
	     }
	 }
	
	 private void shutdownDB() {
         /*
          * In embedded mode, an application should shut down the database.
          * If the application fails to shut down the database,
          * Derby will not perform a checkpoint when the JVM shuts down.
          * This means that it will take longer to boot (connect to) the
          * database the next time, because Derby needs to perform a recovery
          * operation.
          *
          * It is also possible to shut down the Derby system/engine, which
          * automatically shuts down all booted databases.
          *
          * Explicitly shutting down the database or the Derby engine with
          * the connection URL is preferred. This style of shutdown will
          * always throw an SQLException.
          *
          * Not shutting down when in a client environment, see method
          * Javadoc.
          */

         if (framework.equals("embedded"))
         {
             try
             {
                 // the shutdown=true attribute shuts down Derby
                 DriverManager.getConnection("jdbc:derby:;shutdown=true");

                 // To shut down a specific database only, but keep the
                 // engine running (for example for connecting to other
                 // databases), specify a database in the connection URL:
                 //DriverManager.getConnection("jdbc:derby:" + dbName + ";shutdown=true");
             }
             catch (SQLException se)
             {
                 if (( (se.getErrorCode() == 50000)
                         && ("XJ015".equals(se.getSQLState()) ))) {
                     // we got the expected exception
                     System.out.println("Derby shut down normally");
                     // Note that for single database shutdown, the expected
                     // SQL state is "08006", and the error code is 45000.
                 } else {
                     // if the error code or SQLState is different, we have
                     // an unexpected exception (shutdown failed)
                     System.err.println("Derby did not shut down normally");
                     printSQLException(se);
                 }
             }
         }
	 }

	 public static void printSQLException(SQLException e)
	 {
	     // Unwraps the entire exception chain to unveil the real cause of the
	     // Exception.
	     while (e != null)
	     {
	         System.err.println("\n----- SQLException -----");
	         System.err.println("  SQL State:  " + e.getSQLState());
	         System.err.println("  Error Code: " + e.getErrorCode());
	         System.err.println("  Message:    " + e.getMessage());
	         // for stack traces, refer to derby.log or uncomment this:
	         //e.printStackTrace(System.err);
	         e = e.getNextException();
	     }
	 }

	@Override
	public void startEmbeddedDataSource() {
		if(jdbcManager != null) {
			jdbcManager.loadDriver();
		}
		
	}

	@Override
	public void stopEmbeddedDataSource() {
		if(jdbcManager != null) {
			jdbcManager.shutdownDB();
		}		
	}
	
	@Override
	public Connection getConnection(String dbName, Properties props) {
		Connection conn = null;
        try {
        	conn = DriverManager.getConnection(protocol + dbName
			        + ";create=true", props);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return conn;
	}
}
