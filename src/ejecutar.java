
public class ejecutar {

	public static void main(String[] args) {
		
		Partida.iniciarNuevaPartida();
		imprimir();
		while (!Partida.fin()) {
			Partida.ronda();
			Partida.updateEnfermedades();
			if (!Partida.fin()) {
				Partida.infectar();
			}
			imprimir();
			Partida.updateEnfermedades();

		}
	}
	
	
	public static void imprimir() {
		for (Ciudades ciudad : Partida.ciudades) {
			System.out.print(ciudad.nombre);
			System.out.print("| |");
			System.out.print(ciudad.nEnfermedades);
			System.out.print("| |");
			System.out.print(ciudad.brote);
			System.out.print("|---|");

		}
		System.out.println();
		System.out.println("----------------");

		for (Vacunas string : Partida.vacunas) {
			System.out.println(string.nombre);
			System.out.println(string.color);
			System.out.println(string.desarollo + "%");
			System.out.println("----------------");
		}
		
		System.out.println(Partida.brotes + " / "+ Parametros.brotesTotal);
		System.out.println(Partida.enfermedades + " / "+ Parametros.enfermedadesTotal);

		
	}

}