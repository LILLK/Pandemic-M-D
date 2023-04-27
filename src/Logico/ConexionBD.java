package Logico;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Scanner;

public class ConexionBD {
	

	private static final String USER = "DAW_PNDC22_23_DAME";
	private static final String PWD = "DM123";
	// Si estáis desde casa, la url será oracle.ilerna.com y no 192.168.3.26
	private static final String URL = "jdbc:oracle:thin:@192.168.3.26:1521:xe";
	public ConexionBD() {
		
	}
	/*
	private static Connection conectarBaseDatos() {
		Connection con = null;

		System.out.println("Intentando conectarse a la base de datos");

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(URL, USER, PWD);
			System.out.println("Conectados a la base de datos");
		} catch (ClassNotFoundException e) {
			System.out.println("No se ha encontrado el driver " + e);
		} catch (SQLException e) {
			System.out.println("Error en las credenciales o en la URL " + e);
		}
		

		//System.out.println("Conectados a la base de datos");

		return con;
	}*/
	public static void crearUsuario(Connection con,String nomUsu,String passUsu) {
		
		String sql="INSERT INTO USUARIOS VALUES ( IDU_SEQU.NEXTVAL, '"+nomUsu+"', '"+passUsu+"')";
		
		try {
			Statement st = con.createStatement();
			st.execute(sql);
			
			System.out.println("Persona registrada correctamente");
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
