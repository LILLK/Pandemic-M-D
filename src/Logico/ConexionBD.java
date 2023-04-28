package Logico;
import java.sql.Array;
import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.Scanner;

//import ConexionBD.NuevaPersona;

//import ConexionBD.NuevaPersona;

public class ConexionBD {
	

	private static final String USER = "DAW_PNDC22_23_DAME";
	private static final String PWD = "DM123";
	// Si estáis desde casa, la url será oracle.ilerna.com y no 192.168.3.26
	private static final String URL = "jdbc:oracle:thin:@192.168.3.26:1521:xe";
	ArrayList<Ciudades> ciudades;
	ArrayList<Vacunas> vacunas;
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
	public static void cargarPartida(Connection con, int idU,int idP) {
		String sql="SELECT * FROM PARTIDAS P WHERE P.id_p = "+idP+"AND P.jugador = "+idU+";";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql); 	 	

			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					int dni = rs.getInt("id_U");
					int idJ = rs.getInt("jugador");
					Struct domicilio = (Struct) ((Array) rs.getObject(3)).getArray();
					ArrayList<Ciudades> ciudades = (ArrayList<Ciudades>) ((Array) ((ResultSet) rs).getObject(3)).getArray();
					
					String passw = rs.getString("passwd_J");
					

/*
					Struct domicilio = (Struct) rs.getObject("DOMICILIO");
					Object[] valoresDireccion = domicilio.getAttributes();
					String calle = (String) valoresDireccion[0];
					String ciudad = (String) valoresDireccion[1];
					String pais = (String) valoresDireccion[2];

/*
					Direccion direccion = new Direccion(calle,ciudad,pais);
					Persona persona = new Persona(dni, nombre, direccion);*/
					
					//NuevaPersona persona = new NuevaPersona(dni, nombre, calle, ciudad, pais);

					System.out.println("Partu ENCONTRADA");

				}
			} else {
				System.out.println("No he encontrado nada");
			}
			
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
	}
	public static void crearUsuario(Connection con,String nomUsu,String passUsu) {
		
		String sql=" BEGIN crearUsuario ('"+nomUsu+"', '"+passUsu+"'); END;";
		
		try {
			Statement st = con.createStatement();
			st.execute(sql);
			
			System.out.println("Persona registrada correctamente");
		} catch (SQLException e) {
			System.out.println(e);
			
		}
	}
	public static void existeUsuario(Connection con,String nomUsu, String passUsu) {
		String sql =" SELECT * FROM USUARIOS U WHERE u.nom_us LIKE '"+nomUsu+"' AND u.passwd_j LIKE '" +passUsu+"' ";

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql); 	 	

			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					int dni = rs.getInt("id_U");
					String nombre = rs.getString("nom_Us");
					String passw = rs.getString("passwd_J");
					

/*
					Struct domicilio = (Struct) rs.getObject("DOMICILIO");
					Object[] valoresDireccion = domicilio.getAttributes();
					String calle = (String) valoresDireccion[0];
					String ciudad = (String) valoresDireccion[1];
					String pais = (String) valoresDireccion[2];

/*
					Direccion direccion = new Direccion(calle,ciudad,pais);
					Persona persona = new Persona(dni, nombre, direccion);*/
					
					//NuevaPersona persona = new NuevaPersona(dni, nombre, calle, ciudad, pais);

					System.out.println("PERSONA ENCONTRADA");

				}
			} else {
				System.out.println("No he encontrado nada");
			}
			
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	
}
}


