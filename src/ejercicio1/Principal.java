package ejercicio1;

public class Principal {
	public static void main(String[] args) throws DniInvalido {
		Archivo archivo = new Archivo();
		archivo.leerLineas();
		archivo.exportarPersonas(archivo.getListaPersonas());
		Util.mostrarEnConsola(archivo.getListaPersonas());
	}
}
