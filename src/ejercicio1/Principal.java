package ejercicio1;

import java.util.TreeSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Principal {
	// Es una funcion para detectar guiones en la linea de texto
	public static Boolean detectarGuion(char caracter) {
		if (caracter == '-') {
			return true;
		}
		return false;
	}
	
	// Esto va en otra clase
	public static Persona extraerPersona(String texto) throws DniInvalido {
		Persona persona = new Persona();
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
		persona.setNombre(nombre);
		persona.setApellido(apellido);
		persona.setDni(dni);
		return persona;
	}
	
	//No leer esto, es una prueba. Se puede hacer mejor. Disculpen
	public static List<String> ordenarLista(TreeSet<Persona> lista) {
		List apellidos = new LinkedList<>();
		Iterator<Persona> it = lista.iterator();
		while (it.hasNext()) {
			apellidos.add(it.next().getApellido());
		}
		Collections.sort(apellidos);
		return apellidos;
	}
	
	public static void main(String[] args) throws DniInvalido {
		TreeSet<Persona> listaPersonas = new TreeSet<Persona>();
		
		
		Archivo archivo = new Archivo();
		archivo.leerLineas();
		listaPersonas = archivo.getListaPersonas();
		
		List listaNombres = ordenarLista(listaPersonas);
		
		Iterator<String> iterator = listaNombres.iterator();
		
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
	}
}
