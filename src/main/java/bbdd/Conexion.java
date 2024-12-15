package bbdd;

import java.io.File;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//Creamos la clase conexion que se encargara de conectarse al gestor de base de datos y creara la base de datos
//Lo hacemos estatico dado que estos valores van a ser asi para toda la aplicacion
public class Conexion {
	
 	//Nos dice la ruta absoluta del usuario que tiene la sesion iniciada
	private static final String RUTA_USER = System.getProperty("user.home");
   
	
	//Creamos las cosntantes donde tendremos las rutas del directorio y el archivo de configuracion
	private static final String RUTA_PRINCIPAL 	= RUTA_USER+"\\CentralBank";
	private static final String CONFIG 			= "jdbc.properties";
	
	
	//Creamos los parametros para nuestra conexion
	private static String driver		= "com.mysql.cj.jdbc.Driver";
	private static String url			= "";	
	private static String user 			= "";
	private static String password		= "";
	
	//Creamos las constantes de nuestros nombres de tablas y base de datos
	private static final String NBASE_DATOS	= "centralbank";
	private static final String BASE_DATOS	= NBASE_DATOS+"?useSSL=false&severTimezone=UTC";	
		
	
	
	
	//Creamos los getters y setters
	public static String getUrl() {
		return url;
	}
	public static void setUrl(String host) {
		Conexion.url = "jdbc:mysql://"+host+"/";
		
	}
	public static String getUser() {
		return user;
	}
	public static void setUser(String user) {
		Conexion.user = user;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		Conexion.password = password;
	}


	//Metodo que se encarga de comprobar si ya esta echa la instalacion o hay que hacerla
	public static void instalacion() {
		//Creamos los archivos para despues comprobar si existen
		File directorio 			= new File(RUTA_PRINCIPAL);
		File archivo_configuracion 	= new File(RUTA_PRINCIPAL+"\\"+CONFIG);
		
		
		boolean bandera_creacion = true;
		try{
			if(!directorio.isDirectory()){
				if(directorio.mkdir()){
					creaConfig();
				} else {
					bandera_creacion = false;
				}
			} else {
				if (!archivo_configuracion.exists()) {
					creaConfig();
				}
			}
	
		}catch (Exception e) {
			System.err.println("Error inesperado " + e.getMessage());
		}
		
		if(!bandera_creacion){
			return;
		} else {
			baseComprueba();
		}
	

	}
	
	/**Con este metodo podemos crear el archivo de configuracion para el acceso a la base de datos y 
	 * nos da una configuracion por defecto @return no devuelve nada @param no necesita parametros
	 * para ser invocado.
	 */
	private static void creaConfig(){
		//Creamos un objeto de PritnWriter para escribir la configuracion por defecto
		PrintWriter fSalida = null;
		try{
			fSalida = new PrintWriter(new PrintWriter(RUTA_PRINCIPAL+"\\"+CONFIG));
			fSalida.println("driver="+driver+"\nurl="+url+BASE_DATOS+"\nusername="+user+"\npwd="+password+"\nurl_gbd="+url);
			fSalida.close();
		}catch (Exception e) {
			System.err.println("Error Inesperado" + e.getMessage());
		}
	}
	
	
	/**Con este metodo comprobaremos si existe la base de datos y en caso de que no existe invocara a
	 * un metodo para que la cree @return no devuelve nada @param no necesita ningun parametro
	 */	
	private static void baseComprueba() {
		//Levantamos el driver
		try {
		    Class.forName(driver);
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		//Preparamos la conexion
		Connection con 			= null;
		PreparedStatement ps 	= null;
		ResultSet rs 			= null;
		
		/*Extraemos todos los nombres de las bases de datos y comprobamos si ya existe 
		el nombre de la nuestra y en caso de que no la creeamos e invocamos al metodo
		creaTablas que nos crearas las tablas necesarias y nos introducira unos datos
		por defecto*/
		try {
		    con = DriverManager.getConnection(url, user, password);
		    String sql = "SHOW DATABASES;";
		    ps = con.prepareStatement(sql);
		    rs = ps.executeQuery();

		    ArrayList<String> resultados = new ArrayList<String>();
		    while (rs.next()) {
		        resultados.add(rs.getString("Database"));
		    }

		    //Si nos devuelve -1 nos esta indicando que no existe esa base de datos
		    if (resultados.indexOf(NBASE_DATOS) == -1) {
		        sql = "CREATE DATABASE " + NBASE_DATOS;
		        Statement statement = con.createStatement();
		        statement.executeUpdate(sql);
		        creaTablas();
		    }
		    else
		    	return;
		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
		    try {
		        if (rs 	!= null)	rs.close();
		        if (ps 	!= null)	ps.close();
		        if (con != null)	con.close();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}
	}
	
	/**Con el siguiente metodo crearemos una base de datos con sus tablas @return no devueve nada @param no necesita parametros*/	
	private static void creaTablas(){
		//Levantamos el driver
		try{
			Class.forName(driver);
		}catch(Exception e){
			e.printStackTrace();
		}
			
		Connection con 	= null;
		PreparedStatement ps	= null;
		ResultSet rs 			= null;
		try {
			//Hacemos las conexiones para asi crear la estructura de la base de datos
		    con = DriverManager.getConnection((url+BASE_DATOS), user, password);
		
		    
		  //Creamos las tablas
		    String usuarios = "CREATE TABLE IF NOT EXISTS Usuarios ( id_usuario INT AUTO_INCREMENT PRIMARY KEY, nombre VARCHAR(100) NOT NULL, apellido VARCHAR(100) NOT NULL, correo_electronico VARCHAR(150) UNIQUE NOT NULL, contrasena VARCHAR(255) NOT NULL, fecha_registro DATE);";
		    ps = con.prepareStatement(usuarios);
		    ps.executeUpdate();
		    ps.close();
		    
		    String cuentas = "CREATE TABLE IF NOT EXISTS Cuentas ( id_cuenta INT AUTO_INCREMENT PRIMARY KEY, id_usuario INT NOT NULL, numero_cuenta VARCHAR(20) UNIQUE NOT NULL, tipo_cuenta ENUM('ahorros', 'corriente') NOT NULL, saldo DECIMAL(15, 2) DEFAULT 0.00, fecha_creacion DATE, FOREIGN KEY (id_usuario) REFERENCES Usuarios(id_usuario) ON DELETE CASCADE );";
		    ps = con.prepareStatement(cuentas);
		    ps.executeUpdate();
		    ps.close();

		    String tarjetas = "CREATE TABLE IF NOT EXISTS  Tarjetas ( id_tarjeta INT AUTO_INCREMENT PRIMARY KEY, id_cuenta INT NOT NULL, numero_tarjeta VARCHAR(16) UNIQUE NOT NULL, tipo_tarjeta ENUM('debito', 'credito') NOT NULL, fecha_expiracion DATE NOT NULL, codigo_seguridad VARCHAR(4) NOT NULL, limite_credito DECIMAL(15, 2) DEFAULT NULL, FOREIGN KEY (id_cuenta) REFERENCES Cuentas(id_cuenta) ON DELETE CASCADE );";
		    ps = con.prepareStatement(tarjetas);
		    ps.executeUpdate();
		    ps.close();

		    String transacciones = "CREATE TABLE IF NOT EXISTS  Transacciones ( id_transaccion INT AUTO_INCREMENT PRIMARY KEY, id_cuenta_origen INT NOT NULL, id_cuenta_destino INT, monto DECIMAL(15, 2) NOT NULL, tipo_transaccion ENUM('deposito', 'retiro', 'transferencia') NOT NULL, fecha_transaccion DATE, FOREIGN KEY (id_cuenta_origen) REFERENCES Cuentas(id_cuenta) ON DELETE CASCADE, FOREIGN KEY (id_cuenta_destino) REFERENCES Cuentas(id_cuenta) );";
		    ps = con.prepareStatement(transacciones);
		    ps.executeUpdate();
		    ps.close(); 

		    String prestamos = "CREATE TABLE IF NOT EXISTS  Prestamos ( id_prestamo INT AUTO_INCREMENT PRIMARY KEY, id_usuario INT NOT NULL, monto DECIMAL(15, 2) NOT NULL, interes DECIMAL(5, 2) NOT NULL, plazo_meses INT NOT NULL, fecha_inicio DATE, saldo_pendiente DECIMAL(15, 2) DEFAULT NULL, FOREIGN KEY (id_usuario) REFERENCES Usuarios(id_usuario) ON DELETE CASCADE );";
		    ps = con.prepareStatement(prestamos);
		    ps.executeUpdate();
		    ps.close(); 
		    
		    String pagos = "CREATE TABLE IF NOT EXISTS Pagos ( id_pago INT AUTO_INCREMENT PRIMARY KEY, id_prestamo INT NOT NULL, monto_pagado DECIMAL(15, 2) NOT NULL, fecha_pago DATE, FOREIGN KEY (id_prestamo) REFERENCES Prestamos(id_prestamo) ON DELETE CASCADE );";
		    ps = con.prepareStatement(pagos);
		    ps.executeUpdate();
		    ps.close(); 
		      
		    
		} catch (SQLException e) {
		    e.printStackTrace();
		} finally {
			try {
				if(rs	!=null)			rs.close();;;
				if(ps	!=null)			ps.close();
				if(con	!=null)			con.close();
			}catch(Exception e){
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}
}