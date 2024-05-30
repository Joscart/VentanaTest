package modelo;

public class ValidarCliente implements Validacion{
	
	public static boolean validarNombre(String nombre) {
		return nombre.matches(REGEX_NOMBRECOMPLETO);
	}
	
	public static boolean validarCedula(String cedula) {
		return cedula.matches(REGEX_CEDULA);
	}
	
	public static boolean validarCorreo(String correo) {
		return correo.matches(REGEX_CORREO);
	}

}
