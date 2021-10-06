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
    
    private String url = "jdbc:posgresql://ec2-52-204-213-254.compute-1.amazonaws.com:5432/d8q9tqk63rgjhr";
    private String user = "fblzlastlodhtk";
    private String pss = "7c33455570c18ebf0684086383ba5774854f8b8b81b85844b3e06631dc143167";
    
    private ConexionMysql()
    {
        try {
            Class.forName("org.posgresql.Driver");
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
