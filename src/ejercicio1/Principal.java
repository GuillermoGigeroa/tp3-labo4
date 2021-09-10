package ejercicio1;

import java.util.TreeSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Principal {
	
	public static void main(String[] args) throws DniInvalido {
		TreeSet<Persona> listaPersonas = new TreeSet<Persona>();
		
		Archivo archivo = new Archivo();
		archivo.leerLineas();
		listaPersonas = archivo.getListaPersonas();
		
		List listaNombres = Util.ordenarLista(listaPersonas);
		
		Iterator<String> iterator = listaNombres.iterator();
		
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
	}
}
