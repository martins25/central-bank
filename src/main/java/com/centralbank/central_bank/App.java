package com.centralbank.central_bank;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bbdd.Conexion;

import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class App extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtf_usuario;
	private JTextField jtf_direccion;
	private JTextField jtf_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
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
	public App() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(""));
		setTitle("CentralBank");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 487, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel jl_titulo = new JLabel("CentralBank");
		jl_titulo.setHorizontalAlignment(SwingConstants.CENTER);
		jl_titulo.setFont(new Font("Tahoma", Font.PLAIN, 32));
		jl_titulo.setBounds(140, 11, 189, 39);
		contentPane.add(jl_titulo);
		
		jtf_direccion = new JTextField();
		jtf_direccion.setBounds(194, 91, 150, 20);
		contentPane.add(jtf_direccion);
		jtf_direccion.setColumns(10);
		
		jtf_usuario = new JTextField();
		jtf_usuario.setBounds(194, 132, 150, 20);
		contentPane.add(jtf_usuario);
		jtf_usuario.setColumns(10);
		
		jtf_password = new JTextField();
		jtf_password.setBounds(194, 174, 150, 20);
		contentPane.add(jtf_password);
		jtf_password.setColumns(10);
		
		JButton jb_continuar = new JButton("Continuar");
		jb_continuar.setFont(new Font("Tahoma", Font.BOLD, 11));
		jb_continuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				Conexion.setUrl(jtf_direccion.getText());
				Conexion.setUser(jtf_usuario.getText());
				Conexion.setPassword(jtf_password.getText());
				Conexion.instalacion();
		
			}
		});
		jb_continuar.setOpaque(true);
		jb_continuar.setBorderPainted(false);
		jb_continuar.setBackground(new Color(74, 187, 122));
		jb_continuar.setForeground(new Color(0, 0, 0));
		jb_continuar.setBounds(263, 239, 89, 23);
		contentPane.add(jb_continuar);
		
		JButton jb_salir = new JButton("Salir");
		jb_salir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		jb_salir.setOpaque(true);
		jb_salir.setBorderPainted(false);
		jb_salir.setBackground(new Color(232, 40, 30));
		jb_salir.setFont(new Font("Tahoma", Font.BOLD, 11));
		jb_salir.setBounds(116, 239, 89, 23);
		contentPane.add(jb_salir);
		
		JLabel jl_direccion = new JLabel("Dirección:");
		jl_direccion.setBounds(116, 94, 47, 14);
		contentPane.add(jl_direccion);
		
		JLabel jl_usuario = new JLabel("Usuario:");
		jl_usuario.setBounds(116, 135, 47, 14);
		contentPane.add(jl_usuario);
		
		JLabel jl_password = new JLabel("Constraseña:");
		jl_password.setBounds(116, 177, 68, 14);
		contentPane.add(jl_password);
	}
}
