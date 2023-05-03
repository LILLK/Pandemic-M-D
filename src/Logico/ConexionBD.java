package Logico;
import java.sql.Array;
import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.Scanner;

import Pandemic.JF_PanelPuntuaciones;

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
	public static void guardarPartida(Connection con, int idU) {
		
	}
	public static void cargarRanking(Connection con) {
		String sql ="select p.brotes, p.ronda, p.puntuacion,p.dificultad,u.nom_us FROM PARTIDAS P, USUARIOS U WHERE p.jugador = u.id_u AND p.estado LIKE 'A'";
		System.out.println("carg-1");
		try {
			Statement STranking = con.createStatement();
			ResultSet RSranking = STranking.executeQuery(sql); 	 	
			System.out.println("hola");
			if (RSranking.isBeforeFirst()) {
				while (RSranking.next()) {
					//System.out.println("tupadre");
					int brotes = RSranking.getInt("brotes");
					int ronda =RSranking.getInt("ronda");
					int puntuacion=RSranking.getInt("puntuacion");
					int dificultad = RSranking.getInt("dificultad");
					String nom_us = RSranking.getString("nom_us");
					//System.out.println(RSranking.getString("nom_us"));
					//JF_PanelPuntuaciones jf = new JF_PanelPuntuaciones();
					Rankings ranking = new Rankings(brotes,ronda,puntuacion,dificultad,nom_us);
					//System.out.println(ranking.brotes+""+ranking.nomb_us);
					JF_PanelPuntuaciones.rankings.add(ranking);
					System.out.println(ranking.nomb_us);
					
					
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

					//System.out.println("PERSONA ENCONTRADA");
				}
				
				for (Rankings ranking1 : JF_PanelPuntuaciones.rankings) {
					System.out.println(ranking1.brotes+" "+ranking1.dificultad+ranking1.nomb_us);
				}

		} else {
			System.out.println("No he encontrado nada");
		}	
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//System.out.println(e);
		}
		/*
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql); 	 	

			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					
					
					int brotes = rs.getInt("brotes");
					int ronda =rs.getInt("ronda");
					int puntuacion=rs.getInt("puntuacion");
					int dificultad = rs.getInt("dificultad");
					String nom_us = rs.getString("nom_us");
					//JF_PanelPuntuaciones jf = new JF_PanelPuntuaciones();
					Rankings ranking = new Rankings(brotes,ronda,puntuacion,dificultad,nom_us);
					System.out.println(brotes+ronda+puntuacion+dificultad+nom_us);
					JF_PanelPuntuaciones.rankings.add(ranking);

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
					//System.out.println();
					/*System.out.println("Partu ENCONTRADA-rank");*/
					} 
	
	public static void cargarPartida(Connection con, int idU,int idP) {
		String sql="SELECT * FROM PARTIDAS P WHERE P.id_p = "+idP+"AND P.jugador = "+idU+";";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql); 	 	

			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					Partida.idP = rs.getInt("id_P");
					int idJ = rs.getInt("jugador");
					String estado = rs.getString("estado");
					Struct domicilio = (Struct) ((Array) rs.getObject("VacunasPartida")).getArray();
					Partida.vacunas = (ArrayList<Vacunas>)((Array) ((ResultSet) rs).getObject(4)).getArray();
					Partida.brotes = rs.getInt("brotes");
					domicilio = (Struct) ((Array) rs.getObject("CiudadesPartida")).getArray();
					Partida.ciudades = (ArrayList<Ciudades>) ((Array) ((ResultSet) rs).getObject(49)).getArray();
					Partida.ronda = rs.getInt("ronda");
					Partida.Puntuacion = rs.getInt("puntuacion");
					Partida.dificultad = rs.getInt("dificultad");
					

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
					System.out.println();
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
	public static boolean crearUsuario(Connection con,String nomUsu,String passUsu) {
		
		String sql=" BEGIN crearUsuario ('"+nomUsu+"', '"+passUsu+"'); END;";
		boolean usuCorr = true;
		
		try {
			Statement st = con.createStatement();
			st.execute(sql);
			
			System.out.println("Persona registrada correctamente");
			usuCorr = true;
		} catch (SQLException e) {
			System.out.println(e.getErrorCode());
			usuCorr = false;
		}
		return usuCorr;
	}
	public static boolean existeUsuario(Connection con,String nomUsu, String passUsu) {
		String sql =" SELECT * FROM USUARIOS U WHERE u.nom_us LIKE '"+nomUsu+"' AND u.passwd_j LIKE '" +passUsu+"' ";
		boolean existe = true;
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
					existe = true;
				}
			} else {
				System.out.println("No he encontrado nada");
				existe = false;
			}
			
			

		} catch (SQLException e) {
			existe = false;
			// TODO Auto-generated catch block
			//System.out.println(e);
		}
		return existe;
	
}
}


