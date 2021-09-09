package ejercicio1;

import java.io.IOException;

@SuppressWarnings("serial")
public class DniInvalido extends IOException{

	@Override
	public String getMessage() {
		return "Error: DNI invalido.";
	}
	
}
