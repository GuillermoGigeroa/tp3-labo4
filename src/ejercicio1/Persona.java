package ejercicio1;

public class Persona {
	private String nombre;
	private String apellido;
	private int dni;
	
	// Constructores
	public Persona(String nombre, String apellido, int dni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}
	
	// Metodos de la clase
	@Override
	public String toString() {
		return "\nPersona - Nombre: " + nombre
				+ ", Apellido: " + apellido
				+ ", DNI: " + dni + "\n";
	}
	
	// Getters y Setters
	protected String getNombre() {
		return nombre;
	}
	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}
	protected String getApellido() {
		return apellido;
	}
	protected void setApellido(String apellido) {
		this.apellido = apellido;
	}
	protected int getDni() {
		return dni;
	}
	protected void setDni(int dni) {
		this.dni = dni;
	}
	
}
