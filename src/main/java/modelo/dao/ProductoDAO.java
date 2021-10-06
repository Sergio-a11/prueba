/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import conexiones.ConexionMysql;
import interfaces.contratoDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.dto.ProductoDTO;

/**
 *
 * @author Sergio Cruz
 */
public class ProductoDAO implements contratoDAO<ProductoDTO>{

    
    private static final String SQL_READ_ALL = "SELECT * FROM tb_producto";
    private static final String SQL_READ = "SELECT * FROM tb_producto WHERE id_producto = ?";
    private static final String SQL_CREATE = "INSERT INTO tb_producto(nombre_producto, descripcion_producto, unidades, valor) VALUES (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tb_producto SET nombre_producto = ?, descripcion_producto = ?, unidades = ?, valor = ? where id_producto = ?";
    private static final String SQL_DELETE = "DELETE FROM tb_producto WHERE id_producto = ?";
    private final ConexionMysql CON = ConexionMysql.getInstance();
    
    @Override
    public boolean create(ProductoDTO obj) {
        PreparedStatement psnt = null;
        try {
            psnt = CON.getCnn().prepareStatement(SQL_CREATE);
            psnt.setString(1, obj.getNombre_producto());
            psnt.setString(2, obj.getDescripcion_producto());
            psnt.setInt(3, obj.getUnidades());
            psnt.setInt(4, obj.getValor());
            int rs = psnt.executeUpdate();
            if(rs > 0)
            {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("error query create = " + ex.getMessage());
        }
        finally 
        {
            try {
                if(psnt != null){
                    psnt.close();
                }
            } catch (SQLException ex) {
                System.out.println("error finally create = " + ex.getMessage());
            
            }
            CON.cerrarConexion();
        }
        return false;
    }

    @Override
    public List<ProductoDTO> readAll() {
        List<ProductoDTO> list = null;
        
        PreparedStatement psnt = null;
        ResultSet rs = null;
        try {
            psnt = CON.getCnn().prepareStatement(ProductoDAO.SQL_READ_ALL);
            rs = psnt.executeQuery();
            
            list = new ArrayList<>();
            
            while(rs.next())
            {
                ProductoDTO obj = new ProductoDTO(
                        rs.getInt("id_producto"), 
                        rs.getString("nombre_producto"), 
                        rs.getString("descripcion_producto"), 
                        rs.getInt("unidades"), 
                        rs.getInt("valor"));
                list.add(obj);
            }
        } catch (SQLException ex) {
            System.out.println("error query producto : " + ex.getMessage());
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
            CON.cerrarConexion();
        }
        return list;
    }

    @Override
    public ProductoDTO read(ProductoDTO filter) {
        ProductoDTO obj = null;
        
        PreparedStatement psnt = null;
        ResultSet rs = null;
        try {
            psnt = CON.getCnn().prepareStatement(ProductoDAO.SQL_READ);
            psnt.setInt(1, filter.getId());
            rs = psnt.executeQuery();
            
            if(rs.next())
            {
                obj = new ProductoDTO(rs.getInt("id_producto"), 
                        rs.getString("nombre_producto"), 
                        rs.getString("descripcion_producto"), 
                        rs.getInt("unidades"), 
                        rs.getInt("valor"));
            }
        } catch (SQLException | NullPointerException ex) {
            System.out.println("error query read : " + ex.getMessage());
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
                System.out.println("Error finally read" + ex.getMessage());
            }
            CON.cerrarConexion();
        }
        return obj;
    }

    @Override
    public boolean update(ProductoDTO obj) {
        PreparedStatement psnt = null;
        try {
            psnt = CON.getCnn().prepareStatement(SQL_UPDATE);
            psnt.setString(1, obj.getNombre_producto());
            psnt.setString(2, obj.getDescripcion_producto());
            psnt.setInt(3, obj.getUnidades());
            psnt.setInt(4, obj.getValor());
            psnt.setInt(5, obj.getId());
            int rs = psnt.executeUpdate();
            if(rs > 0)
            {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("error query update = " + ex.getMessage());
        }
        finally 
        {
            try {
                if(psnt != null){
                    psnt.close();
                }
            } catch (SQLException ex) {
                System.out.println("error finally update = " + ex.getMessage());
            
            }
            CON.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean delete(ProductoDTO obj) {
        PreparedStatement psnt = null;
        try {
            psnt = CON.getCnn().prepareStatement(SQL_DELETE);
            psnt.setInt(1, obj.getId());
            int rs = psnt.executeUpdate();//codigo de error, 0 no lo elimino, > si lo mato
            System.out.println("rs = " + rs);
            
            if (rs > 0)
            {
                return true;
            }
        } catch (SQLException | NullPointerException ex) {
            System.out.println("error query delete : " + ex.getMessage());
        }
        finally
        {
            try {
                if(psnt != null )
                {
                    psnt.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error finally delete" + ex.getMessage());
            }
            CON.cerrarConexion();
        }
        return false;
    } 
}
