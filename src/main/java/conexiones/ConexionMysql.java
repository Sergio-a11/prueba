package conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sergio Cruz
 * Implemetación de patron Sigleton
 */
public class ConexionMysql {
    
    public static ConexionMysql instance;
    private Connection cnn;
    
    private String url = "jdbc:mysql://localhost:3306/bd_tallerjavaweb";
    private String user = "root";
    private String pss = "";
    
    private ConexionMysql()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnn = DriverManager.getConnection(url, user, pss);
        } catch (ClassNotFoundException ex) {
            System.out.println("error 1 " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("error 2 " + ex.getMessage());
        }
    }
    
    public static synchronized ConexionMysql getInstance()
    {
        if(instance == null)
        {
            instance = new ConexionMysql();
        }
        return instance;
    }

    public Connection getCnn() {
        return cnn;
    }
    
    public void cerrarConexion()
    {
        instance = null;
    }
}
