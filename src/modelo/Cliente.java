package modelo;

import libreria.Generica;

public class Cliente {

	//Clase Generica
	Generica<String,String> datos = new Generica<String,String>();

	/**
	 * Constructor sin parametros
	 */
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor con parametros
	 * 
	 * @param nombre
	 * @param cedula
	 * @param correo
	 */
	public Cliente(String nombre, String cedula, String correo) {
		super();
		this.datos = new Generica<String,String>(nombre, cedula, correo);
	}

	/**
	 * Retorna el nombre del cliente
	 * 
	 * @return nombre
	 */
	public String getNombre() {
		return datos.getAtributo1();
	}

	/**
	 * Retorna la cedula del cliente
	 * 
	 * @return cedula
	 */
	public String getCedula() {
		return datos.getAtributo2();
	}

	/**
	 * Retorna el correo del cliente
	 * 
	 * @return correo
	 */
	public String getCorreo() {
		return datos.getAtributo3();
	}

	/**
	 * Establece el nombre del cliente
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		datos.setAtributo1(nombre);
	}

	/**
	 * Establece la cedula del cliente
	 * 
	 * @param cedula
	 */
	public void setCedula(String cedula) {
		datos.setAtributo2(cedula);
	}

	/**
	 * Establece el correo del cliente
	 * 
	 * @param correo
	 */
	public void setCorreo(String correo) {
		datos.setAtributo3(correo);
	}
	
	/**
	 * Metodo que retorna los datos del cliente separados por punto y coma
	 * 
	 * @return
	 */
	public String toFile() {
		return String.format("%s;%s;%s", getNombre(), getCedula(), getCorreo());
	}
	
	/**
	 * Metodo que establece los datos del cliente a partir de una cadena separada por punto y coma
	 * 
	 * @param linea
	 * @return
	 */
	public boolean fromFile(String linea) {
		String[] datos = linea.split(";");
		
		if (datos.length != 3)
			return false;

		
		setNombre(datos[0]);
		setCedula(datos[1]);
		setCorreo(datos[2]);
		
		return true;
	}

	/**
	 * Metodo que retorna los datos del cliente en formato de cadena
	 */
	@Override
	public String toString() {
		return String.format("Cliente [getNombre()=%s, getCedula()=%s, getCorreo()=%s]", getNombre(),
				getCedula(), getCorreo());
	}
	
}
