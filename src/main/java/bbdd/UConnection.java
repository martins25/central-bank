package bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class UConnection {
	private static Connection con = null;
	
	public static Connection getConnection() {
			
		try {
			if(con==null) {
				Runtime.getRuntime().addShutdownHook(new MiShutdownHook());
				
				String ruta_properities = System.getProperty("user.home")+"\\CentralBank";
				
				ResourceBundle rb 	= ResourceBundle.getBundle(ruta_properities+"jdbc");
				String driver 		= rb.getString("driver");
				String url 			= rb.getString("url");
				String pwd 			= rb.getString("pwd");
				String usr 			= rb.getString("usr");
				
				Class.forName(driver);
				con = DriverManager.getConnection(url, usr, pwd);
			}
			
			return con;
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error al crear la conexion ", e);
		}
	}
	
	
	static class MiShutdownHook extends Thread{
		public void run(){
			try{
				con = UConnection.getConnection();
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}
}
