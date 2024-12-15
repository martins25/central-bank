package com.centralbank.central_bank;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bbdd.Config;
import bbdd.UConnection;

import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;

public class LoginFrame extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtf_usuario;
	private JTextField jtf_direccion;
	private JTextField jtf_password;
	
	
	//Componentes
	private JButton jb_continuar;
	private JButton jb_salir;
	private JCheckBox checkBox_recuerdame;
	

	/**
	 * Create the frame.
	 */
	public LoginFrame(){
		setResizable(false);
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
		jl_titulo.setBounds(155, 11, 189, 39);
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
		
		jb_continuar = new JButton("Continuar");
		jb_continuar.setFont(new Font("Tahoma", Font.BOLD, 11));
		jb_continuar.addActionListener(this);
		jb_continuar.setOpaque(true);
		jb_continuar.setBorderPainted(false);
		jb_continuar.setBackground(new Color(74, 187, 122));
		jb_continuar.setForeground(new Color(0, 0, 0));
		jb_continuar.setBounds(263, 239, 89, 23);
		contentPane.add(jb_continuar);
		
		jb_salir = new JButton("Salir");
		jb_salir.addActionListener(this);
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
		
		checkBox_recuerdame = new JCheckBox("Recuerdame");
		checkBox_recuerdame.setSelected(true);
		checkBox_recuerdame.setBounds(194, 209, 97, 23);
		contentPane.add(checkBox_recuerdame);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Object source = e.getSource();
		
		if(source instanceof JButton) {
			JButton boton = (JButton) source;
			
			if(boton == jb_continuar) {
				
				Config.setUrl(jtf_direccion.getText());
				Config.setUser(jtf_usuario.getText());
				Config.setPassword(jtf_password.getText());
				
				//Vemos si el usuario quiere guardar la sesion o no
				if(checkBox_recuerdame.isSelected()){
					Config.creaConfig();					
					
				}else {
					Config.borraConfig();
				}
				
				//BBDD
				Config.instalacion();
				
				//Cambiamos de Jframe
				this.setVisible(false);
				MainFrame siguiente = new MainFrame();
	            siguiente.setVisible(true);
	            
	            			
			}else if(boton == jb_salir) {
				System.exit(0);
			}
			
		}		
	}
}
