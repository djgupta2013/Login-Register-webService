package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public final class ConnectionProvider {
	
	static Connection connection=null;
	private ConnectionProvider()
	{
		
	}
	
  	public static Connection getConn()
	{
  		if(connection==null)
  	  	{
  	  		
  			try
  			{
  				Class.forName("com.mysql.jdbc.Driver");
  				connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/dhananjay","root","root");
  				return connection;
  				
  			}
  			
  			catch (Exception e) {
				e.printStackTrace();
			}
  	  	}
  		else 
  		{
  			
		}
		return connection;
	}
  	
  	
	
}