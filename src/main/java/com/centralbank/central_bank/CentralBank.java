package com.centralbank.central_bank;

import java.awt.EventQueue;

import bbdd.UConnection;

public class CentralBank {
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
	        try {
	            // Intentar obtener una conexión
	            UConnection.getConnection();
	            
	            // Si la conexión es exitosa, mostramos el siguiente JFrame
	            MainFrame siguiente = new MainFrame();
	            siguiente.setVisible(true);
	            
	        } catch (Exception e) {
	            // Si hay error en la conexión, mostrar JFrame de configuración
	            LoginFrame configuracion = new LoginFrame();
	            configuracion.setVisible(true);
	        }
	    });
    }
	
}
