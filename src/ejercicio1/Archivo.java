package ejercicio1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Archivo {
	public static void verificarDniInvalido(String dni_ingresado) throws DniInvalido {
		try {
			int dni = Integer.parseInt(dni_ingresado);
			System.out.println("DNI: "+dni);
		}
		catch (NumberFormatException e) {
			System.out.println("Error de DNI ...");
			throw new DniInvalido();
		}
	}
	
	public static void leerLineas() {
		try {
			FileReader fileReader = new FileReader("Personas.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String linea = "";
			while (linea != null) {
				if (linea != "") {System.out.println(linea);}
				linea = bufferedReader.readLine();
			}
			bufferedReader.close();
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
