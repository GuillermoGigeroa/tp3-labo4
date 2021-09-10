package ejercicio1;

public class Persona implements Comparable<Persona>{
	private String nombre;
	private String apellido;
	private Dni dni;
	
	// Constructores
	public Persona() throws DniInvalido {
		this.nombre = "No cargado";
		this.apellido = "No cargado";
		this.dni = new Dni("0");
	}
	
	public Persona(String nombre, String apellido, String dni) throws DniInvalido {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = new Dni(dni);
	}
	
	// Metodos de la clase
	@Override
	public String toString() {
		return "Nombre: " + nombre
				+ ", Apellido: " + apellido
				+ ", DNI: " + dni;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Persona o) {
		//HACER UN METODO QUE PERMITA ORDENAR EN EL TREESET ALFABETICAMENTE POR APELLIDO
		
		return this.dni.hashCode() == o.dni.hashCode() ? 0 : this.dni.hashCode() > o.dni.hashCode() ? 1 : -1;
//		return this.hashCode() == o.hashCode() ? 0 : this.hashCode() > o.hashCode() ? 1 : -1;
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
		return dni.getNumero();
	}
	protected void setDni(String dni) throws DniInvalido {
		this.dni = new Dni(dni);
	}
	
}
