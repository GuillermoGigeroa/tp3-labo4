package ejercicio1;

import java.util.TreeSet;
import java.util.Iterator;

public class Principal {
	
	public static void main(String[] args) throws DniInvalido {
		TreeSet<Persona> listaPersonas = new TreeSet<Persona>();
		
		Archivo archivo = new Archivo();
		archivo.leerLineas();
		listaPersonas = archivo.getListaPersonas();
		
		Iterator<Persona> iterator = listaPersonas.iterator();
		
		while (iterator.hasNext()) {
			System.out.println(iterator.next().toString());
		}
		
	}
}
