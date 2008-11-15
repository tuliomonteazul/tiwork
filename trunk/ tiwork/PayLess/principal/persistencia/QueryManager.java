package persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class QueryManager {
 private static  QueryManager manager;
 private File file;
 private Properties prop;
 
 public PreparedStatement getPrepared(Connection con,String queryName) throws SQLException{
		String busca=prop.getProperty(queryName);
		return con.prepareStatement(""+busca);
		
	}
 
 
 public static QueryManager getInstance() throws FileNotFoundException, IOException{
	 if(manager == null){
		 manager = new QueryManager("C:\\Tulio\\eclipseJEE\\workspace\\PayLess\\conexoes.applications");
	 }
	 return manager;
 }
 
 private QueryManager(String arquivo) throws FileNotFoundException, IOException{
	 prop = new Properties();
	 file =  new File(arquivo);
	 
	 prop.load(new FileInputStream(file));
 }
 
}
