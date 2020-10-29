package formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.Usuario;
import mantenimiento.GestionUsuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmlogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtContraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmlogin frame = new frmlogin();
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
	public frmlogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuarios:");
		lblNewLabel.setBounds(21, 57, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_1.setBounds(21, 106, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(95, 54, 86, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtContraseña = new JPasswordField();
		txtContraseña.setBounds(95, 103, 86, 20);
		contentPane.add(txtContraseña);
		
		JButton btnNewButton = new JButton("SALIR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salir();
			}
		});
		btnNewButton.setBounds(95, 176, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("INGRESAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresar();
			}
		});
		btnNewButton_1.setBounds(230, 176, 89, 23);
		contentPane.add(btnNewButton_1);
	}

	protected void ingresar() {
		
		String usuario = txtUsuario.getText();
	String clave = String.valueOf(txtContraseña.getPassword());
	
	GestionUsuario gestionUsuario = new GestionUsuario();
	
	Usuario usuario2 = new Usuario();
	usuario2.setUsuario(usuario);
	usuario2.setClave(clave);
	
	
	Usuario usu = gestionUsuario.obtenerUsuario(usuario2);
	
	if(usu!=null){
	JOptionPane.showInternalMessageDialog(contentPane,"Bienvenido");
	
	this.dispose();
	
	frmBienvenidaUsuarios bienvenidaUsuarios = new frmBienvenidaUsuarios();
	bienvenidaUsuarios.setVisible(true);
	}else{
	JOptionPane.showInternalMessageDialog(contentPane, "Datos incorrectos","Error",JOptionPane.ERROR_MESSAGE);
	
	}
	}

	protected void salir() {
		System.exit(0);
		
	}
}
