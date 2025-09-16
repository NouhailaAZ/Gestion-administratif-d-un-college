package gestionAdministratifCollege;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnexionSql {
	private static Connection conn ;
	static {
		try {Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost/gestion de college","root","");
		}
		catch(Exception e)
		{
			System.out.println("Erreur " + e);
		}
			}
		public static Connection getConnection()
		{
			return conn ;
		}
}
