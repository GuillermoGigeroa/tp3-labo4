package ejercicio1;

import java.util.TreeSet;
import java.util.Iterator;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class Archivo {
	private TreeSet<Persona> listaPersonas;
	private String rutaOrigen;
	private String rutaDestino;

	// Constructores
	public Archivo() {
		this.listaPersonas = new TreeSet<Persona>();
		this.rutaOrigen = "Personas.txt";
		this.rutaDestino = "Resultado.txt";
	}
	
	public Archivo(String rutaOrigen, String rutaDestino) {
		this.listaPersonas = new TreeSet<Persona>();
		this.rutaOrigen = rutaOrigen;
		this.rutaDestino = rutaDestino;
	}
	
	// Metodos de la clase
	public Boolean verificar(String ruta) {
		Boolean existe = this.existe(ruta);
		if (!existe) {
			return this.crearAchivo(ruta);
		}
		return existe;
	}
	
	public Boolean existe(String ruta) {
		File archivo = new File(ruta);
		return archivo.exists();
	}
	
	public Boolean crearAchivo(String ruta) {
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(ruta,true);
			fileWriter.write("");
			fileWriter.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void leerLineas() {
		String ruta = this.rutaOrigen;
		if(verificar(ruta)) {
			try {
				FileReader fileReader = new FileReader(ruta);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				String linea = "";
				while (linea != null) {
					if (linea != "") {
						try {
							this.listaPersonas.add(Util.convertirEnPersona(linea));
						}
						catch (DniInvalido e) {
							// Aca se puede escribir un mensaje cada vez que encuentre una persona con el dni mal cargado
							//System.out.println("Se encontro un dni mal cargado.");
						}
					}
					linea = bufferedReader.readLine();
				}
				bufferedReader.close();
				fileReader.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("Archivo no pudo ser creado.");
		}
	}
	
	public void exportarPersona(Persona persona) {
		String ruta = this.rutaDestino;
		if(verificar(ruta)) {
			try {
				FileWriter fileWriter = new FileWriter(ruta,true);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
				bufferedWriter.write(persona.exportarString());
				bufferedWriter.close();
				fileWriter.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("Archivo no pudo ser creado.");
		}
	}
	
	public void exportarPersonas(TreeSet<Persona> lista) {
		Iterator<Persona> listaPersonas = lista.iterator();
		while (listaPersonas.hasNext()) {
			this.exportarPersona(listaPersonas.next());
		}
	}
	
	// Getters y Setters
	protected TreeSet<Persona> getListaPersonas() {
		return listaPersonas;
	}
	
	protected void setListaPersonas(TreeSet<Persona> listaPersonas) {
		this.listaPersonas = listaPersonas;
	}

	protected String getRutaOrigen() {
		return rutaOrigen;
	}

	protected void setRutaOrigen(String rutaOrigen) {
		this.rutaOrigen = rutaOrigen;
	}

	protected String getRutaDestino() {
		return rutaDestino;
	}

	protected void setRutaDestino(String rutaDestino) {
		this.rutaDestino = rutaDestino;
	}


}
