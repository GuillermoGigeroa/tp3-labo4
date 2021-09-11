package ejercicio1;

public abstract class Util {
	// Es una funcion para detectar guiones en la linea de texto
	public static Boolean detectarGuion(char caracter) {
		if (caracter == '-') {
			return true;
		}
		return false;
	}
	
	// Es una funcion para poder convertir a una instancia de Persona desde una linea de texto
	public static Persona convertirEnPersona(String texto) throws DniInvalido {
		Boolean detectoPrimerGuion = false;
		Boolean detectoSegundoGuion = false;
		String nombre = "";
		String apellido = "";
		String dni = "";
		for (int i = 0; i < texto.length(); i++) {
			char caracter = texto.charAt(i);
			if(detectarGuion(caracter)) {
				if (detectoPrimerGuion) {
					detectoSegundoGuion = true;
				}
				detectoPrimerGuion = true;
			}
			else
			{
				if(detectoPrimerGuion) {
					if (detectoSegundoGuion) {
						dni += caracter;
					}
					else {
						apellido += caracter;
					}
				}
				else {
					nombre += caracter;
				}				
			}
		}
		return new Persona(nombre,apellido,dni);
	}
}
