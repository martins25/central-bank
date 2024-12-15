package com.centralbank.central_bank;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import java.awt.Panel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPasswordField;
import java.awt.BorderLayout;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("New menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("New menu");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mnNewMenu_1.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);
		
		JPanel jp_cuentas = new JPanel();
		tabbedPane.addTab("Cuentas", null, jp_cuentas, null);
		
		JPanel jp_pagos = new JPanel();
		tabbedPane.addTab("Pagos", null, jp_pagos, null);
		
		JPanel jp_prestamos = new JPanel();
		tabbedPane.addTab("Prestamos", null, jp_prestamos, null);
		
		JPanel jp_Tarjetas = new JPanel();
		tabbedPane.addTab("Tarjetas", null, jp_Tarjetas, null);
		
		JPanel jp_usuarios = new JPanel();
		tabbedPane.addTab("Usuarios", null, jp_usuarios, null);
		
		JPanel jp_transacciones = new JPanel();
		tabbedPane.addTab("Transacciones", null, jp_transacciones, null);
	}

}
