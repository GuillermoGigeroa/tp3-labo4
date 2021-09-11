package ejercicio1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

public class Archivo {
	private TreeSet<Persona> listaPersonas;

	// Constructores
	public Archivo() {
		this.listaPersonas = new TreeSet<Persona>();
	}
	
	public Archivo(TreeSet<Persona> listaPersonas) {
		this.listaPersonas = listaPersonas;
	}
	
	// Getters y Setters
	protected TreeSet<Persona> getListaPersonas() {
		return listaPersonas;
	}
	
	protected void setListaPersonas(TreeSet<Persona> listaPersonas) {
		this.listaPersonas = listaPersonas;
	}
	
	// Metodos de la clase
	public void leerLineas() {
		try {
			FileReader fileReader = new FileReader("Personas.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String linea = "";
			while (linea != null) {
				if (linea != "") {
					try {
						this.listaPersonas.add(Util.convertirEnPersona(linea));
					}
					catch (DniInvalido e) {
						// Aca se puede escribir un mensaje cada vez que encuentre una persona con el dni mal cargado
					}
				}
				linea = bufferedReader.readLine();
			}
			bufferedReader.close();
			fileReader.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado en sistema.");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
