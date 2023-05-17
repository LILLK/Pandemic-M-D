//Mehdi Tahrat && David hola
package Logico;

import java.sql.Array;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Struct;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Pandemic.JF_PanelCargarPartida;
import Pandemic.JF_PanelPuntuaciones;

/**
 * Esta classe se ocupa de las conexiones con la base de datos. + static final 
 * @author DAME
 *
 */
public class ConexionBD {
	/**
	 * Usuario de Oracle.
	 */
	private static final String USER = "DAW_PNDC22_23_DAME";
	/**
	 * 
	 */
	private static final String PWD = "DM123";
	/**
	 * 	Enlace para la conexion en Oracle.
	 *  Si estáis desde casa, la url será oracle.ilerna.com y no 192.168.3.26
	 */
	private static final String URL = "jdbc:oracle:thin:@192.168.3.26:1521:xe";
	/**
	 * conexion con la base de datos
	 */
	public static final Connection con = conectarBaseDatos();

	/**
	 * Esta funcion guarda una partida empezada, en la BD. Si el parametro esta en
	 * verdadero la partida se guarda como finalizada.
	 * 
	 * @param boolean estado
	 */
	public static void guardarPartida(boolean estado) {

		// si el estado es cierto la partida pasa a acabada
		String estadop = estado ? "A" : "I";
		// la sentenccia que se escribira en la bd para guardar partida
		String sql = "UPDATE PARTIDAS SET estado = '" + estadop + "',vacunasp = vacunaspartida(";

		int i = 0;
		for (Vacunas vacuna : Partida.vacunas) {// por cada vacuna
			// leer su estado
			if (i == 0) {
				sql += " vacunas('" + vacuna.color + "'," + vacuna.desarollo + ")";
			} else {
				sql += ", vacunas('" + vacuna.color + "'," + vacuna.desarollo + ")";
			}
			i++;
		}
		// leer brotes
		sql += "), brotes =" + Partida.brotes + ", ciudadesp = ciudadespartida(";
		i = 0;
		for (Ciudades ciudad : Partida.ciudades) {// por cada ciudad
			// leer su estado de infecion
			String infeccion = ciudad.brote ? "S" : "N";
			// leer nombre, idvirus, nEnfermedade y infeccion
			if (i == 0) {
				sql += " ciudades('" + ciudad.nombre + "'," + ciudad.idVirus + "," + ciudad.nEnfermedades + ",'"
						+ infeccion + "')";
			} else {
				sql += ", ciudades('" + ciudad.nombre + "'," + ciudad.idVirus + "," + ciudad.nEnfermedades + ",'"
						+ infeccion + "')";
			}
			i++;
		}
		// leer los atributos de la partida
		sql += "),ronda =" + Partida.ronda + ", puntuacion = " + Partida.Puntuacion + ", dificultad="
				+ Partida.dificultad + ", acciones = " + Partida.accionesRonda + " WHERE id_p =" + Partida.idP + "";
		try {
			// con la conexion establecida se manda e ejecuta la secuencia sql
			Statement st = con.createStatement();
			System.out.println("Ranking");
			System.out.println(sql);
			st.execute(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
	}

	/**
	 * Esta funcion guardar en Pardida.idP la id de la ultima partida creada .
	 */
	public static void idPartida() {
		String sql = "SELECT p.id_p FROM PARTIDAS P WHERE rownum = 1 ORDER BY p.id_p DESC";

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
			// System.out.println(e);
		}

	}

	/**
	 * Esta funcion guarda una nueva partida en la BD con los datos generados de los
	 * archivos
	 */
	public static void iniciarPartida() {
		// la sentenccia que se escribira en la bd para guardar partida
		String sql = "INSERT INTO PARTIDAS VALUES(idP_sequ.nextval," + Partida.idJ + ",'I', vacunaspartida(";

		int i = 0;
		for (Vacunas vacuna : Partida.vacunas) {// por cada vacuna
			// se leen las vacunas
			if (i == 0) {
				sql += " vacunas('" + vacuna.color + "'," + vacuna.desarollo + ")";
			} else {
				sql += ", vacunas('" + vacuna.color + "'," + vacuna.desarollo + ")";
			}
			i++;
		}
		// se lee los brotes
		sql += ")," + Partida.brotes + ", ciudadespartida(";
		i = 0;
		for (Ciudades ciudad : Partida.ciudades) {// por cada ciudad
			// se leen los datos de la cidad
			String infeccion = ciudad.brote ? "S" : "N";
			if (i == 0) {
				sql += " ciudades('" + ciudad.nombre + "'," + ciudad.idVirus + "," + ciudad.nEnfermedades + ",'"
						+ infeccion + "')";
			} else {
				sql += ", ciudades('" + ciudad.nombre + "'," + ciudad.idVirus + "," + ciudad.nEnfermedades + ",'"
						+ infeccion + "')";
			}
			i++;
		}
		// se lee los datos de la partida
		sql += ")," + Partida.ronda + "," + Partida.Puntuacion + "," + Partida.dificultad + ",0)";

		System.out.println(sql);
		try {
			// se ejecuta la sentencia sql en la base de datos
			Statement st = con.createStatement();
			st.execute(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Esta funcion carga el listado de partidas para enseñarlas en el Ranking. 
	 * Las carga en funcion si estan acabadas y la puntuacion es mayor que 0. 
	 * Los datos de esta acaban guardadas en la lista JF_PanelPuntuaciones.rankings.
	 */
	public static void cargarRanking() {
		// la sequencia sql
		String sql = "select p.brotes, p.ronda, p.puntuacion,p.dificultad,u.nom_us FROM PARTIDAS P, USUARIOS U WHERE p.jugador = u.id_u AND p.estado LIKE 'A' AND p.puntuacion > 0 ORDER BY p.puntuacion DESC";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					//se rellenan los datos obtenidos de la sentencia sq
					int brotes = rs.getInt("brotes");
					int ronda = rs.getInt("ronda");
					int puntuacion = rs.getInt("puntuacion");
					int dificultad = rs.getInt("dificultad");
					String nom_us = rs.getString("nom_us");
					Rankings ranking = new Rankings(brotes, ronda, puntuacion, dificultad, nom_us);
					JF_PanelPuntuaciones.rankings.add(ranking);
				}
			} else {
				System.out.println("No he encontrado nada");
			}
		} catch (SQLException e) {
		}
	}
/**
 * Esta funcion carga el listado de partidas no acabadas echas por el jugador para cargarlas.
 * Los datos de esta acabaran en la lista JF_PanelCargarPartida.partGuar.
 * @param int id_J - ID jugador
 */
	public static void cargarPartidas() {
		// la sequencia sql
		System.out.println(Partida.idJ);
		String sql = "select p.id_p, p.brotes, p.ronda, p.puntuacion,p.dificultad, p.acciones FROM PARTIDAS P, USUARIOS U WHERE p.jugador = u.id_u AND p.estado LIKE 'I' AND p.jugador ="+ Partida.idJ + " ORDER BY p.id_p DESC";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					//se rellenan los datos obtenidos de la sentencia sq
					int idP = rs.getInt("id_p");
					int brotes = rs.getInt("brotes");
					int ronda = rs.getInt("ronda");
					int puntuacion = rs.getInt("puntuacion");
					int dificultad = rs.getInt("dificultad");
					int acciones = rs.getInt("acciones");
					PartidasGuardadas partidaGuardada = new PartidasGuardadas(idP, brotes, ronda, puntuacion,dificultad, acciones);
					JF_PanelCargarPartida.partGuar.add(partidaGuardada);
				}

			} else {
				System.out.println("No he encontrado nada");
			}
		} catch (SQLException e) {}
	}
/**
 * Esta funcion recoge los datos de la BD de la partida que queremos cargar.
 * @param int idU - id usuario 
 * @param int idP - id partida
 */
	public static void cargarPartida(int idP) {
		//sentecia sql 
		System.out.println(idP);
		String sql = "SELECT * FROM PARTIDAS P WHERE P.id_p = " + idP + " AND P.jugador = " + Partida.idJ + "";
		try {
			
			Statement st = con.createStatement();
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			if (rs.isBeforeFirst()) {//si hay un registro
				while (rs.next()) {
					//recoge los datos de la partida
					Partida.idP = rs.getInt("id_P");
					int idJ = rs.getInt("jugador");
					String estado = rs.getString("estado");
					//cogemos el registro vacunas (VARRAY AS OBJECT) y lo metemos en un array de objetos
					Object[] dataV = rs.getObject(4) != null ? (Object[]) ((Array) rs.getObject(4)).getArray() : null;
					// si nos devuelve datos
					if (dataV != null) {
						int i = 0;
						//limpiar lista vacunas
						Partida.vacunas.clear();
						for (Object tmpV : dataV) {//por cada objeto del registro anterior
							//Se crea una estructura donde se pasaran los datos dentro del objeto para cargar las vacunas
							Struct rowV = (Struct) tmpV;
							Object[] valuesV = rowV.getAttributes();
							Vacunas vacuna = new Vacunas(i, Integer.parseInt(valuesV[1].toString()),
									valuesV[0].toString());
							Partida.vacunas.add(vacuna);

							i++;
						}
						//lee los datos de brotes 
						Partida.brotes = rs.getInt("brotes");
						//lee los datos de cada ciudad
						Object[] dataC = rs.getObject(6) != null ? (Object[]) ((Array) rs.getObject(6)).getArray()
								: null;
						// si nos devuelve datos, mostramos en consola
						if (dataC != null) {
							i = 0;
							Partida.ciudades.clear();
							boolean brote;
							for (Object tmpC : dataC) {//por cada objecto recogido anteriomente
								//se crea una estructura para leer los datos
								Struct rowC = (Struct) tmpC;
								Object[] valuesC = rowC.getAttributes();
								if (valuesC[3].toString().equals("S")) {
									brote = true;
								} else {
									brote = false;
								}
								//se leen los datos de las ciudades
								Ciudades ciudad = new Ciudades(valuesC[0].toString(),
										Integer.parseInt(valuesC[2].toString()),
										Integer.parseInt(valuesC[1].toString()), brote);

								Partida.ciudades.add(ciudad);
								i++;
							}
							//se lee los datos de partida
							Partida.ronda = rs.getInt("ronda");
							Partida.Puntuacion = rs.getInt("puntuacion");
							Partida.dificultad = rs.getInt("dificultad");
							int ds = rs.getInt("acciones");
						}
					}
				}
			} else {
				System.out.println("No he encontrado nada");
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	/**
	 * Esta funcion crea un nuevo usuario en la BD
	 * @param String nomUsu
	 * @param String passUsu
	 * @return
	 */
	public static boolean crearUsuario(String nomUsu, String passUsu) {
		//sequiencia sql, que llama a una procedure para crear un nuevo usuario.
		String sql = "BEGIN crearUsuario ('" + nomUsu + "', '" + passUsu + "'); END;";
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
	/**
	 * Esta funcion busca guarda el id del jugador creado en Partida.idJ .
	 */
	public static void idJugador() {

		String sql = "SELECT u.id_u FROM Usuarios U WHERE rownum = 1 ORDER BY u.id_u DESC";

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					Partida.idJ = rs.getInt(1);
				}
			} else {
				System.out.println("No he encontrado nada");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// System.out.println(e);
		}

	}
/**
 * Esta funcion devuelve true si el usuario existete en la base de datos 
 * @param String nomUsu
 * @param String passUsu
 * @return boolean
 */
	public static boolean existeUsuario(String nomUsu, String passUsu) {
		//sequencia sql donde busca la existencia del usuario.
		String sql = " SELECT * FROM USUARIOS U WHERE u.nom_us LIKE '" + nomUsu + "' AND u.passwd_j LIKE '" + passUsu
				+ "' ";
		boolean existe = true;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.isBeforeFirst()) {//si hay un registro 
				while (rs.next()) {//por cada registro
					//se busca la id de usuario 
					Partida.idJ =  rs.getInt("id_U");
					String nombre = rs.getString("nom_Us");
					String passw = rs.getString("passwd_J");
					existe = true;
					
				}
			} else {//no se a encontrado
				existe = false;
			}
		} catch (SQLException e) {
			existe = false;
		}
		return existe;
	}
/**
 * Esta funcion se encarga de extablecer conexion con la base de datos.
 * @return {@link Connection}
 */
	public static Connection conectarBaseDatos() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(URL, USER, PWD);
		} catch (ClassNotFoundException e) {
			System.out.println("No se ha encontrado el driver " + e);
			JOptionPane.showMessageDialog(new JFrame(), " Error en la base de datos, pruebe mas tarde.");
		} catch (SQLException e) {
			System.out.println("Error en las credenciales o en la URL " + e);
			JOptionPane.showMessageDialog(new JFrame(), " Error en la base de datos, pruebe mas tarde.");
		}
		return con;
	}
}
