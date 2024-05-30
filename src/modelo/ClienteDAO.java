package modelo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import libreria.Files;

public class ClienteDAO implements Config{

	/**
	 * Files de la clase generica
	 */
	private Files file;

	/**
	 * Constructor de la clase
	 */
	public ClienteDAO() {
		super();
		file = new Files(RUTA);
	}

	/**
	 * Guarda un solo cliente en el archivo
	 * 
	 * @param cliente a guardar
	 * @return true si se guardo en el archivo
	 */
	public boolean guardarCliente(Cliente e) throws IOException {
		if (e == null)
			return false;

		file.setFile(new File(RUTA,ARCHIVO));
		return file.writerFile(e.toFile(), false);
	}

	/**
	 * Guarda una lista de clientes en el archivo
	 * 
	 * @param lista de clientes
	 * @return true si se guardo en el archivo
	 */
	public boolean guardarClientes(List<? extends Cliente> e) throws IOException {
		boolean completado = true;
		file.setFile(new File(RUTA,ARCHIVO));
		file.writerFile("", completado);
		for(Cliente c : e) {
			if(!guardarCliente(c))
				completado = false;
		}
		return completado;
	}

	/**
	 * Extrae la lista de clientes guardados en el archivo
	 * 
	 * @return lista de clientes en el archivo
	 */
	public List<Cliente> leerClientes() throws IOException{
		file.setFile(new File(RUTA,ARCHIVO));
		file.create(1);
		List<Cliente> clientes = new ArrayList<Cliente>();
		String texto = file.readerFile();
		String[] lineas = texto.split("\n");
		for (String linea : lineas) {
			Cliente c = new Cliente();
			if (c.fromFile(linea))
				clientes.add(c);
		}
		return clientes;
	}
}
