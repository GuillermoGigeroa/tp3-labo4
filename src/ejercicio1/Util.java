package ejercicio1;

import java.util.TreeSet;
import java.util.Iterator;

public abstract class Util {
	// Convierte una linea leida, en una instancia de Persona
	public static Persona convertirEnPersona(String texto) throws DniInvalido, LineaInvalida{
		try {
			String textoDividido[];
			textoDividido = texto.split("-");
			return new Persona(textoDividido[0],textoDividido[1],textoDividido[2]);
		}
		catch (ArrayIndexOutOfBoundsException e){
			throw new LineaInvalida();
		}
	}

	// Muestra en consola la lista completa de Personas
	public static void mostrarEnConsola(TreeSet<Persona> lista) {
		Iterator<Persona> listaPersonas = lista.iterator();
		while (listaPersonas.hasNext()) {
			System.out.println(listaPersonas.next().toString());
		}
	}
}
