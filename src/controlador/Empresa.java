package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;
import modelo.ClienteDAO;

public class Empresa implements Runnable{

	/**
	 * Lista de clientes
	 */
	private List<Cliente> clientes = new ArrayList<Cliente>();
	/**
	 * Data Access Object de cliente
	 */
	private ClienteDAO dao_cliente = new ClienteDAO();

	/**
	 * Constructor de la clase
	 */
	public Empresa() {
		super();
		// TODO Auto-generated constructor stub
		try {
			clientes = dao_cliente.leerClientes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Agrega un cliente a la lista
	 * 
	 * @param e
	 * @return true si se agrego
	 */
	public boolean addCliente(Cliente e) {
		if (!comprobarCliente(e))
			return false;
		return clientes.add(e);
	}

	/**
	 * Retorna un cliente de la lista
	 * 
	 * @param index de la lista
	 * @return cliente en el index de la lista
	 */
	public Cliente getCliente(int index) {
		return clientes.get(index);
	}

	/**
	 * Retorna la lista de clientes
	 * 
	 * @return lista de clientes
	 */
	public List<Cliente> getClientes() {
		return clientes;
	}

	/**
	 * Guarda la lista en un archivo
	 */
	public void guardarClientes() {
		try {
			dao_cliente.guardarClientes(clientes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Verifica si el cliente existe en la lista
	 * 
	 * @param cliente a comprobar
	 * @return false si existe en la lista
	 */
	private boolean comprobarCliente(Cliente e) {
		if (e == null)
			return false;

		boolean existe = false;

		for (Cliente c : clientes) {
			if (c == null)
				continue;

			if (c.getNombre().equals(e.getNombre())) {
				existe = true;
				break;
			}

			if (c.getCedula().equals(e.getCedula())) {
				existe = true;
				break;
			}

			if (c.getCorreo().equals(e.getCorreo())) {
				existe = true;
				break;
			}
		}

		return !existe;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		guardarClientes();
	}



}
