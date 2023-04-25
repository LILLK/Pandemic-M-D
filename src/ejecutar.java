
public class ejecutar {
	
	public static void main(String[] args) {
		Partida.nuevaPartida();
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

}