package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Cliente;
import modelo.ValidarCliente;
import vista.Formulario;

public class Logic_Formulario implements ActionListener{
	
	/**
	 * Clase de la vista a la que se le asigna la logica
	 */
	private Formulario lb;
	/**
	 * Controlador de la empresa
	 */
	private Empresa tm_empresa = new Empresa();
	
	/**
	 * Constructor de la clase
	 * 
	 * @param vista a controlar
	 */
	public Logic_Formulario(Formulario lb) {
		this.lb = lb;
		listeners();
	}
	
	/**
	 * Asigna los listener que se utilizaran
	 */
	private void listeners() {
		lb.btn_guardar.addActionListener(this);
	}
	
	/**
	 * Valida los datos del cliente
	 * 
	 * @return true si los datos son validos
	 */
	private boolean validar() {
		boolean valido = true;
		
		if(!ValidarCliente.validarNombre(lb.txt_nombre.getText()))
			valido = false;
		
		if(!ValidarCliente.validarCedula(lb.txt_cedula.getText()))
			valido = false;
		
		if(!ValidarCliente.validarCorreo(lb.txt_correo.getText()))
			valido = false;
		
		return valido;
	}
	
	/**
	 * Retorna el cliente ingresado
	 * 
	 * @return cliente
	 */
	public Cliente getCliente() {
		if(validar()) {
			lb.lbl_estatus.setText("Cliente guardado");
			return new Cliente(lb.txt_nombre.getText(), lb.txt_cedula.getText(), lb.txt_correo.getText());
		} else {
			lb.lbl_estatus.setText("Ingrese nuevamente los datos");
			return null;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == lb.btn_guardar) {
			if(!tm_empresa.addCliente(getCliente()))
				lb.lbl_estatus.setText("Cliente ya existe");
			
			// Guardar en archivo
			Thread hilo = new Thread(tm_empresa);
			hilo.start();
		}
	}

}
