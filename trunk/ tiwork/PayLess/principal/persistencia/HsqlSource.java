package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HsqlSource {
private static HsqlSource hsql;
private Connection conn;

	private static HsqlSource getInstance() throws ClassNotFoundException, SQLException{
		if(hsql ==  null){
			hsql = new HsqlSource();
		}
		return hsql;
	}

	private HsqlSource() throws ClassNotFoundException, SQLException{
	Class.forName("");
	conn = DriverManager.getConnection("","","");
	
	}

	public Connection getConnection(){
		return conn;
	}
	
}
