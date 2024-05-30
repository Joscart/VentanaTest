package modelo;

public interface Validacion {
	
	/**
	 * @author Jose Guallasamin
	 * @since 29/05/2024
	 */

	/**
	 * Expresion regular para validar el nombre completo
     */
	public final String REGEX_NOMBRECOMPLETO = "^([A-Z][a-zá-ú]+([ ]+)?){2,7}$";
	/**
	 * Expresion regular para validar la cedula
	 */
	public final String REGEX_CEDULA = "^[0-1][0-9]{8}[-][0-9]$";
	/**
	 * Expresion regular para validar el correo
	 */
	public final String REGEX_CORREO = "^[a-z][a-z0-9]+[@][a-z]{3,}([.][a-z]{2,5})+$";
}
