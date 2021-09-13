package ejercicio1;

public class Dni implements Comparable<Dni> {
	private int numero;

	// Constructores
	public Dni() {
		this.numero = 0;
	}
	
	public Dni(String numero) throws DniInvalido {
		this.numero = verificarDniInvalido(numero);
	}

	// Metodos de la clase
	protected int getNumero() {
		return numero;
	}

	protected void setNumero(int numero) {
		this.numero = numero;
	}

	public static int verificarDniInvalido(String dni_ingresado) throws DniInvalido {
		try {
			return Integer.parseInt(dni_ingresado);
		} catch (NumberFormatException e) {
			throw new DniInvalido();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numero;
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
		Dni other = (Dni) obj;
		if (numero != other.numero)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.valueOf(this.numero);
	}

	@Override
	public int compareTo(Dni o) {
		return this.hashCode() == o.hashCode() ? 0 : this.hashCode() > o.hashCode() ? 1 : -1;
	}
}
