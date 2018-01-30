package pac;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.naming.NamingException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import pac.Funciones;

public class Ventana extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	static String ruta;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Funciones funciones = new Funciones();
					ruta = funciones.ruta;
					Ventana frame = new Ventana();
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
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(62, 118, 328, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setText(ruta);

		textField_1 = new JTextField();
		textField_1.setBounds(156, 180, 130, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(156, 254, 130, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(156, 316, 130, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblInserteNombre = new JLabel("Inserte nombre");
		lblInserteNombre.setBounds(170, 67, 100, 16);
		contentPane.add(lblInserteNombre);

		JLabel lblArchivo = new JLabel("Archivo 1");
		lblArchivo.setBounds(186, 156, 61, 16);
		contentPane.add(lblArchivo);

		JLabel lblArchivo_1 = new JLabel("Archivo 2");
		lblArchivo_1.setBounds(186, 226, 61, 16);
		contentPane.add(lblArchivo_1);

		JLabel lblArchivo_2 = new JLabel("Archivo 3");
		lblArchivo_2.setBounds(186, 288, 61, 16);
		contentPane.add(lblArchivo_2);
		
		JButton btnBotonMagico = new JButton("Boton magico");
		btnBotonMagico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Funciones.RutasFicheros(textField_1.getText(), textField_2.getText(), textField_3.getText());
				 String[] arrString = new String[3];
				arrString[0] = textField_1.getText();
				arrString[1] = textField_2.getText();
				arrString[2] = textField_3.getText();
				try {
					Funciones.main(arrString);
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnBotonMagico.setBounds(169, 363, 117, 29);
		contentPane.add(btnBotonMagico);
	}
}
