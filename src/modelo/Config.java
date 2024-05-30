package modelo;

import java.io.File;

public interface Config {

	/**
	 * Ruta absoluta de donde se escribe el archivo
	 */
	public final String RUTA = getRuta();
	/**
	 * Nombre del archivo con su extencion
	 */
	public final String ARCHIVO = "Clientes.txt";
	
	/**
	 * metodo que retorna la ruta absoluta del directorio donde se escribe el archivo
	 * 
	 * @return ruta absoluta
	 */
	private static String getRuta() {
		File aux = new File("Datos/");
		if (!aux.exists())
			aux.mkdirs();
		return aux.getAbsolutePath() + "/";
	}
}
