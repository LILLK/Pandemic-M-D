package Logico;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

import Pandemic.JF_Marco;
import Pandemic.JF_PanelPuntuaciones;

public class ejecutar {
	private static final String USER = "DAW_PNDC22_23_DAME";
	private static final String PWD = "DM123";
	// Si estáis desde casa, la url será oracle.ilerna.com y no 192.168.3.26
	private static final String URL = "jdbc:oracle:thin:@oracle.ilerna.com:1521:xe";
	
	public static void main(String[] args) {
		Connection con = conectarBaseDatos();
		//Partida.nuevaPartida();
		JF_Marco marco = new JF_Marco();
		//onexionBD ds= new ConexionBD();

	
		//Connection con = conectarBaseDatos();
		//ds.crearUsuario(con, "sssssssss", "daaaGEGaaaho");
	}
	
	
	
	public static void imprimir() {
		System.out.println("----------------");

		for (Ciudades ciudad : Partida.ciudades) {
			System.out.println(ciudad.nombre +"-" + ciudad.nEnfermedades);
		}
		System.out.println("----------------");

		for (Vacunas string : Partida.vacunas) {
			System.out.println(string.nombre + " " + string.desarollo + "%" );
		}
		System.out.println("----------------");
		
		System.out.println(Partida.Puntuacion);
		System.out.println(Partida.brotes + " / "+ Parametros.brotesTotal);
		
	}
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
	}

}
