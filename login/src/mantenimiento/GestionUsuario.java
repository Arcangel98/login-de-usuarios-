package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Usuario;
import conectorBD.MySQLConexion;

public class GestionUsuario {

	public Usuario obtenerUsuario(Usuario usu) {
		
		Usuario usuario = null;
		
	
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	try {
		
	con = MySQLConexion.getConexion();
	
	
	String sql = "select*from tb_usuario where usuario =? and clave =?";
		
		pst = con.prepareStatement(sql);
		
		pst.setString(1, usu.getUsuario());
		pst.setString(2, usu.getClave());
		
		
		rs = pst.executeQuery();
		
		while (rs.next()) {
			usuario = new Usuario(rs.getNString(1), rs.getNString(2), rs.getNString(3), rs.getNString(4), rs.getNString(5));
		
			
		}
			
	} catch (Exception e) {
		System.out.println("Error en obtener usuario");
		
	}
		
		return usuario;
		
	}
		
	
}
