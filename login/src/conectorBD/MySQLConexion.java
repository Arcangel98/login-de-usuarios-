package conectorBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConexion {
	
	public static Connection getConexion ( ) {
		
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc.mysql://localhost/SQLSERVERLOCAL";
			String usuario = "root";
			String contraseņa = "Arkimedez1998";
			
			con = DriverManager.getConnection(url,usuario,contraseņa);
			
		} catch (ClassNotFoundException e) {
	System.out.println("Error --> al cargar el Driver");
	
			e.printStackTrace();
		} catch (SQLException e) {
	System.out.println("Error --> con la base de datos");		
			e.printStackTrace();
		}
		
		return con;
	}
	
}
