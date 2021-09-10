package ejercicio1;

import java.io.BufferedReader;
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
						this.listaPersonas.add(Util.extraerPersona(linea));
					}
					catch (DniInvalido e) {
						// Aca se puede escribir un mensaje cada vez que encuentre una persona con el dni mal cargado
					}
				}
				linea = bufferedReader.readLine();
			}
			bufferedReader.close();
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
