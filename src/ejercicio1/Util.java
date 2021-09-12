package ejercicio1;

import java.util.TreeSet;
import java.util.Iterator;

public abstract class Util {
	// Convierte una linea leida, en una instancia de Persona
	public static Persona convertirEnPersona(String texto) throws DniInvalido {
		Boolean detectoPrimerGuion = false;
		Boolean detectoSegundoGuion = false;
		String nombre = "";
		String apellido = "";
		String dni = "";
		for (int i = 0; i < texto.length(); i++) {
			char caracter = texto.charAt(i);
			if (caracter == '-') {
				if (detectoPrimerGuion) {
					detectoSegundoGuion = true;
				}
				detectoPrimerGuion = true;
			} else {
				if (detectoPrimerGuion) {
					if (detectoSegundoGuion) {
						dni += caracter;
					} else {
						apellido += caracter;
					}
				} else {
					nombre += caracter;
				}
			}
		}
		return new Persona(nombre, apellido, dni);
	}

	// Muestra en consola la lista completa de Personas
	public static void mostrarEnConsola(TreeSet<Persona> lista) {
		Iterator<Persona> listaPersonas = lista.iterator();
		while (listaPersonas.hasNext()) {
			System.out.println(listaPersonas.next().toString());
		}
	}
}
