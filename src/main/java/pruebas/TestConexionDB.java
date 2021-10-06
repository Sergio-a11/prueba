/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;


import conexiones.ConexionMysql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sergio Cruz
 */
public class TestConexionDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConexionMysql con = ConexionMysql.getInstance();
        PreparedStatement psnt = null;
        ResultSet rs = null;
        try {
            psnt = con.getCnn().prepareStatement("SELECT * FROM tb_producto");
            rs = psnt.executeQuery();
            
            while(rs.next())
            {
                System.out.println(rs.getString("nombre_producto"));
            }
        } catch (SQLException ex) {
            System.out.println("error query = " + ex.getMessage());
        }
        finally
        {
            try {
                if(psnt != null )
                {
                    psnt.close();
                }
                
                if(rs != null)
                {
                    rs.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error finally" + ex.getMessage());
            }
            con.cerrarConexion();
        }
    }
    
}
