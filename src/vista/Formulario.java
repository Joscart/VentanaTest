package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Logic_Formulario;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Formulario extends JFrame {
	
	/**
	 * @author Jose Guallasamin
	 * @since 29/05/2024
	 */

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JLabel lbl_nombre;
	public JLabel lbl_cedula;
	public JLabel lbl_correo;
	public JLabel lbl_estatus;
	public JTextField txt_nombre;
	public JTextField txt_cedula;
	public JTextField txt_correo;
	public JButton btn_guardar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulario frame = new Formulario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Formulario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 446, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[52.00][231.00,grow][::100px,grow,center]", "[::100px,grow,center][::100px,grow,center][::100px,grow,center][::100px,grow,center]"));
		
		lbl_nombre = new JLabel("Nombre");
		contentPane.add(lbl_nombre, "cell 0 0,alignx trailing");
		
		txt_nombre = new JTextField();
		contentPane.add(txt_nombre, "cell 1 0 2 1,growx");
		txt_nombre.setColumns(10);
		
		lbl_cedula = new JLabel("Cedula");
		contentPane.add(lbl_cedula, "cell 0 1,alignx trailing");
		
		txt_cedula = new JTextField();
		contentPane.add(txt_cedula, "cell 1 1 2 1,growx");
		txt_cedula.setColumns(10);
		
		lbl_correo = new JLabel("Correo");
		contentPane.add(lbl_correo, "cell 0 2,alignx trailing");
		
		txt_correo = new JTextField();
		contentPane.add(txt_correo, "cell 1 2 2 1,growx");
		txt_correo.setColumns(10);
		
		lbl_estatus = new JLabel("");
		contentPane.add(lbl_estatus, "cell 1 3");
		
		btn_guardar = new JButton("Guardar");
		contentPane.add(btn_guardar, "cell 2 3");
		
		// Llamado a la logica de la vista
		Logic_Formulario logic = new Logic_Formulario(this);
	}

}
