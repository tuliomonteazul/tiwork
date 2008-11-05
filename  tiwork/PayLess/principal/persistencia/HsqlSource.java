package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HsqlSource {
private static HsqlSource hsql;
private Connection conn;

	public static HsqlSource getInstance() throws ClassNotFoundException, SQLException{
		if(hsql ==  null){
			hsql = new HsqlSource();
		}
		return hsql;
	}

	private HsqlSource() throws ClassNotFoundException, SQLException{
	Class.forName("org.hsqldb.jdbcDriver");
	conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/","sa","");
	
	}

	public Connection getConnection(){
		return conn;
	}
	
}
