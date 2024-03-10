package Conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TranVietHoangConnection {
	public static Connection getMSSQLConnection() throws SQLException, ClassNotFoundException {
        String hostName = "localhost";
        String sqlInstanceName = "";
        String dbName = "BookStore";
        String userName = "sa";
        String password = "h1234567";
        
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionURL = "jdbc:sqlserver://" + hostName + ":1000;instance=" + sqlInstanceName + ";databaseName=" + dbName + ";encrypt=true;trustServerCertificate=true;";
        Connection conn = DriverManager.getConnection(connectionURL, userName, password);
        return conn;
    }
	

	public static void closeQuietly(Connection conn) {
		try {
			conn.close();
		}catch(Exception e){
			
		}
	}
	public static void rollbackQuietly(Connection conn) {
		try {
			conn.rollback();
		}catch(Exception e){
			
		}
	}
}
