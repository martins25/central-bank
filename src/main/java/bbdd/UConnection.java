package bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.io.FileInputStream;

public class UConnection {
    private static Connection con = null;

    public static Connection getConnection() {
        try {
            if (con == null) {
                Runtime.getRuntime().addShutdownHook(new MiShutdownHook());

                // Ruta completa al archivo de propiedades
                String rutaProperties = System.getProperty("user.home") + "\\CentralBank\\jdbc.properties";
                Properties props = new Properties();

                // Cargar el archivo de propiedades
                try (FileInputStream fis = new FileInputStream(rutaProperties)) {
                    props.load(fis); // Cargarmos las propiedades desde el archivo
                }

                // Ahora puedes acceder a las propiedades
                String driver = props.getProperty("driver");
                String url = props.getProperty("url");
                String pwd = props.getProperty("pwd");
                String usr = props.getProperty("username");
                                
                // Nos aseguramos de que el driver esté correctamente cargado
                Class.forName(driver);
                con = DriverManager.getConnection(url, usr, pwd);
            }

            return con;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al crear la conexión", e);
        }
    }

    static class MiShutdownHook extends Thread {
        public void run() {
            try {
                con = UConnection.getConnection();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }
}
