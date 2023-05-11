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

import Pandemic.JF_PanelCargarPartida;
import Pandemic.JF_PanelPuntuaciones;


public class ConexionBD {
	

	private static final String USER = "DAW_PNDC22_23_DAME";
	private static final String PWD = "DM123";
	// Si estáis desde casa, la url será oracle.ilerna.com y no 192.168.3.26
	private static final String URL = "jdbc:oracle:thin:@oracle.ilerna.com:1521:xe";
	public static final Connection con = conectarBaseDatos();
	
	public ConexionBD() {
		
	}

	public static void guardarPartida(Connection con,boolean estado) {
		
		String estadop = estado?"A":"I";
		
		String sql ="UPDATE PARTIDAS SET estado = '"+estadop+"',vacunasp = vacunaspartida(";
		
		int i=0;
		for(Vacunas vacuna : Partida.vacunas) {
			if(i==0) {
				sql += " vacunas('"+vacuna.color+"',"+vacuna.desarollo+")";
			}else {
				sql += ", vacunas('"+vacuna.color+"',"+vacuna.desarollo+")";
			}
			i++;
		}
		sql+="), brotes ="+Partida.brotes+", ciudadesp = ciudadespartida(";
		i =0;
		for(Ciudades ciudad : Partida.ciudades) {
			String infeccion = ciudad.brote?"S":"N";
			if(i==0) {
				sql += " ciudades('"+ciudad.nombre+"',"+ciudad.idVirus+","+ciudad.nEnfermedades+",'"+infeccion+"')";
			}else {
				sql += ", ciudades('"+ciudad.nombre+"',"+ciudad.idVirus+","+ciudad.nEnfermedades+",'"+infeccion+"')";
			}
			i++;
		}
		sql+="),ronda ="+Partida.ronda+", puntuacion = "+Partida.Puntuacion+", dificultad="+Partida.dificultad+", acciones = "+Partida.accionesRonda+" WHERE id_p ="+Partida.idP+"";
		try {
			Statement st = con.createStatement();
			System.out.println(sql);
			st.execute(sql);
			
			System.out.println("Persona registrada correctamente");
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
		}
	}
	public static void idPartida(Connection con) {
		String sql= "SELECT p.id_p FROM PARTIDAS P WHERE rownum = 1 ORDER BY p.id_p DESC";

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql); 	 	

			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					Partida.idP = rs.getInt(1);
				}
		} else {
			System.out.println("No he encontrado nada");
		}	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//System.out.println(e);
		}

	}
	public static void iniciarPartida(Connection con) {

		String sql="INSERT INTO PARTIDAS VALUES(idP_sequ.nextval,"+Jugador.id+",'I', vacunaspartida(";
		
		int i=0;
		for(Vacunas vacuna : Partida.vacunas) {
			if(i==0) {
				sql += " vacunas('"+vacuna.color+"',"+vacuna.desarollo+")";
			}else {
				sql += ", vacunas('"+vacuna.color+"',"+vacuna.desarollo+")";
			}
			i++;
		}
		
		sql+="),"+Partida.brotes+", ciudadespartida(";
			i =0;
		for(Ciudades ciudad : Partida.ciudades) {
			String infeccion = ciudad.brote?"S":"N";
			if(i==0) {
				sql += " ciudades('"+ciudad.nombre+"',"+ciudad.idVirus+","+ciudad.nEnfermedades+",'"+infeccion+"')";
			}else {
				sql += ", ciudades('"+ciudad.nombre+"',"+ciudad.idVirus+","+ciudad.nEnfermedades+",'"+infeccion+"')";
			}
			i++;
		}
		
		sql +="),"+Partida.ronda+","+Partida.Puntuacion+","+Partida.dificultad+",0)";
	
		System.out.println(sql);
		try {
			Statement st = con.createStatement();
			st.execute(sql);
			
			System.out.println("Persona registrada correctamente");
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
		}
	}
	public static void cargarRanking(Connection con) {
		String sql ="select p.brotes, p.ronda, p.puntuacion,p.dificultad,u.nom_us FROM PARTIDAS P, USUARIOS U WHERE p.jugador = u.id_u AND p.estado LIKE 'A' ORDER BY p.puntuacion DESC";

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

					Rankings ranking = new Rankings(brotes,ronda,puntuacion,dificultad,nom_us);

					JF_PanelPuntuaciones.rankings.add(ranking);
					
					

					

				}

		} else {
			System.out.println("No he encontrado nada");
		}	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//System.out.println(e);
		}

		
		} 
	public static void cargarPartidas(Connection con,int id_J) {
		String sql ="select p.id_p, p.brotes, p.ronda, p.puntuacion,p.dificultad FROM PARTIDAS P, USUARIOS U WHERE p.jugador = u.id_u AND p.estado LIKE 'I' AND p.jugador ="+ id_J;

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql); 	 	

			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					
					int idP = rs.getInt("id_p");
					int brotes = rs.getInt("brotes");
					int ronda =rs.getInt("ronda");
					int puntuacion=rs.getInt("puntuacion");
					int dificultad = rs.getInt("dificultad");
			

					PartidasGuardadas partidaGuardada = new PartidasGuardadas(idP,brotes,ronda,puntuacion,dificultad);

					JF_PanelCargarPartida.partGuar.add(partidaGuardada);

					

				}
				

		} else {
			System.out.println("No he encontrado nada");
		}	
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//System.out.println(e);
		}
		
			} 
	
	public static void cargarPartida(Connection con, int idU,int idP) {
		String sql="SELECT * FROM PARTIDAS P WHERE P.id_p = "+idP+" AND P.jugador = "+idU+"";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql); 	 	
			System.out.println(sql);
			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					
					Partida.idP = rs.getInt("id_P");
					int idJ = rs.getInt("jugador");
					String estado = rs.getString("estado");
					//Array a = rs.getArray("vacunasp");
			
					//Object[] vacunas = (Object[]) a.getArray(); 
					//Struct s = vacunas;
					Object[] dataV = rs.getObject(4)!=null? (Object[]) ((Array) rs.getObject(4)).getArray() :null;
					// si nos devuelve datos, mostramos en consola
					if(dataV!=null){
					//System.out.println(«quantity resp: «+data.length);
						
					int i =0;
					Partida.vacunas.clear();
					for(Object tmpV : dataV) {
					Struct rowV = (Struct) tmpV;
					Object[] valuesV = rowV.getAttributes();
					
					Vacunas vacuna = new Vacunas(i,Integer.parseInt(valuesV[1].toString()), valuesV[0].toString() );
					
					Partida.vacunas.add(vacuna);
					
						i++;
					}
					//Vacunas[] vacunas1 = (Vacunas[]) vacunas;
				  
					Partida.brotes = rs.getInt("brotes");
					Object[] dataC = rs.getObject(6)!=null? (Object[]) ((Array) rs.getObject(6)).getArray() :null;
					// si nos devuelve datos, mostramos en consola
					if(dataC!=null){
					//System.out.println(«quantity resp: «+data.length);
						
					 i =0;
					Partida.ciudades.clear();
					boolean brote ;
					for(Object tmpC : dataC) {
					Struct rowC = (Struct) tmpC;
					Object[] valuesC = rowC.getAttributes();
					if(valuesC[3].toString().equals("S")) {
						brote=true;
					}else {
						brote=false;
					}
					
					Ciudades ciudad = new Ciudades(valuesC[0].toString(),Integer.parseInt(valuesC[2].toString()),Integer.parseInt(valuesC[1].toString()),brote);
					
					Partida.ciudades.add(ciudad);
					
						i++;
					}
					Partida.ronda = rs.getInt("ronda");
					Partida.Puntuacion = rs.getInt("puntuacion");
					Partida.dificultad = rs.getInt("dificultad");
					int ds = rs.getInt("acciones");
					
					
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
				}
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
		
		String sql="BEGIN crearUsuario ('"+nomUsu+"', '"+passUsu+"'); END;";
		boolean usuCorr = true;
		
		try {
			Statement st = con.createStatement();
			st.execute(sql);
			
			System.out.println("Persona registrada correctamente");
			usuCorr = true;
		} catch (SQLException e) {
			System.out.println(e);
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
					existe = true;
					Jugador.id = dni;
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
	public static Connection conectarBaseDatos() {
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


