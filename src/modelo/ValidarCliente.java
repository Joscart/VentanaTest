package modelo;

public class ValidarCliente implements Validacion{
	
	/**
	 * @author Jose Guallasamin
	 * @since 29/05/2024
	 */
	
	/**
	 * Valida el nombre de un Cliente
	 * 
	 * @return true si es valido
	 */
	public static boolean validarNombre(String nombre) {
		return nombre.matches(REGEX_NOMBRECOMPLETO);
	}
	
	/**
	 * Valida la cedula de un Cliente
	 * 
	 * @return true si es valido
	 */
	public static boolean validarCedula(String cedula) {
		return cedula.matches(REGEX_CEDULA);
	}
	
	/**
	 * Valida el correo de un Cliente
	 * 
	 * @return true si es valido
	 */
	public static boolean validarCorreo(String correo) {
		return correo.matches(REGEX_CORREO);
	}

}
