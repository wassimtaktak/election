package election;

import java.sql.*;

public class connexion 
{
	private static	Connection connect;
	public static Connection getconnect()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connect=DriverManager.getConnection("jdbc:mysql://localhost/election","root","");
			System.out.println("Connection �tablie!");
		}
		catch(Exception e)
		{
			System.out.println("non connect�e!");
		}
		return connect;
	}
}
