/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import conexiones.ConexionMysql;
import interfaces.contratoDAO;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.dto.UsuarioDTO;

/**
 *
 * @author Sergio Cruz
 */
public class UsuarioDAO implements contratoDAO<UsuarioDTO>{
    
    private final ConexionMysql CON = ConexionMysql.getInstance();
    private final String SQL_CREATE = "INSERT INTO tb_usuario (nombre1, nombre2, apellido1, apellido2, n_identificacion, correo, clave, sexo, fecha_nac, estado) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String SQL_READ_ALL = "SELECT * FROM tb_usuario";
    private final String SQL_READ = "SELECT * FROM tb_usuario WHERE id = ?";
    private final String SQL_UPDATE = "UPDATE tb_usuario SET nombre1 = ?, nombre2 = ?, apellido1 = ?, apellido2 = ?, n_identificacion = ?, correo = ?, clave = ?, sexo = ?, fecha_nac = ?, estado = ? WHERE id = ?";
    private final String SQL_DELETE = "DELETE FROM tb_usuario WHERE id = ?";
    
    @Override
    public boolean create(UsuarioDTO obj) {
        PreparedStatement ps = null;
        try {
            ps = CON.getCnn().prepareStatement(SQL_CREATE);
            ps.setString(1, obj.getNombre1());
            ps.setString(2, obj.getNombre2());
            ps.setString(3, obj.getApellido1());
            ps.setString(4, obj.getApellido2());
            ps.setString(5, obj.getN_identificacion());
            ps.setString(6, obj.getCorreo());
            ps.setString(7, obj.getClave());
            ps.setString(8, obj.getSexo());
            ps.setDate(9, obj.getFecha_nacimineto());
            ps.setInt(10, obj.getEstado());
            int rs = ps.executeUpdate();
            if(rs > 0)
            {
                return true;
            }
        } 
        catch (SQLException ex) {
            System.out.println("Error usuario create sql " + ex.getMessage());
        }
        finally
        {
            try {
                if(ps != null){
                    ps.close();
                }
            } catch (SQLException ex) {
                System.out.println("error usuario finally create = " + ex.getMessage());
            
            }
            CON.cerrarConexion();
        }
        return false;
    }

    @Override
    public List<UsuarioDTO> readAll() {
        List<UsuarioDTO> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {    
            ps = CON.getCnn().prepareStatement(SQL_READ_ALL);
            rs = ps.executeQuery();
            list = new ArrayList<>();
            while(rs.next())
            {
                UsuarioDTO obj = new UsuarioDTO(rs.getInt(1), 
                                                rs.getString(2), 
                                                rs.getString(3), 
                                                rs.getString(4), 
                                                rs.getString(5), 
                                                rs.getString(6), 
                                                rs.getString(7), 
                                                rs.getString(8), 
                                                rs.getString(9), 
                                                rs.getDate(10), 
                                                rs.getInt(11));
                list.add(obj);
            }
        }
        catch (SQLException ex) {
            System.out.println("Error usuario read_all sql " + ex.getMessage());
        }
        finally
        {
            try {
                if(ps != null )
                {
                    ps.close();
                }
                
                if(rs != null)
                {
                    rs.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error finally read_all usuario " + ex.getMessage());
            }
            CON.cerrarConexion();
        }
        return list;
    }

    @Override
    public UsuarioDTO read(UsuarioDTO filter) {
        UsuarioDTO obj = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {    
            ps = CON.getCnn().prepareStatement(SQL_READ);
            ps.setInt(1, filter.getId());
            rs = ps.executeQuery();
            while(rs.next())
            {
                obj = new UsuarioDTO(rs.getInt(1), 
                                    rs.getString(2), 
                                    rs.getString(3), 
                                    rs.getString(4), 
                                    rs.getString(5), 
                                    rs.getString(6), 
                                    rs.getString(7), 
                                    rs.getString(8), 
                                    rs.getString(9), 
                                    rs.getDate(10), 
                                    rs.getInt(11));
            }
        }
        catch (SQLException | NullPointerException ex) {
            System.out.println("Error usuario read sql " + ex.getMessage());
        }
        finally
        {
            try {
                if(ps != null )
                {
                    ps.close();
                }
                
                if(rs != null)
                {
                    rs.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error finally read usuario " + ex.getMessage());
            }
            CON.cerrarConexion();
        }
        return obj;

    }

    @Override
    public boolean update(UsuarioDTO obj) {
        PreparedStatement ps = null;
        try {
            ps = CON.getCnn().prepareStatement(SQL_UPDATE);
            ps.setString(1, obj.getNombre1());
            ps.setString(2, obj.getNombre2());
            ps.setString(3, obj.getApellido1());
            ps.setString(4, obj.getApellido2());
            ps.setString(5, obj.getN_identificacion());
            ps.setString(6, obj.getCorreo());
            ps.setString(7, obj.getClave());
            ps.setString(8, obj.getSexo());
            ps.setDate(9, obj.getFecha_nacimineto());
            ps.setInt(10, obj.getEstado());
            ps.setInt(11, obj.getId());
            int rs = ps.executeUpdate();
            if(rs > 0)
            {
                return true;
            }
        } 
        catch (SQLException ex) {
            System.out.println("Error usuario update sql " + ex.getMessage());
        }
        finally
        {
            try {
                if(ps != null){
                    ps.close();
                }
            } catch (SQLException ex) {
                System.out.println("error usuario finally update = " + ex.getMessage());
            
            }
            CON.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean delete(UsuarioDTO obj) {
        PreparedStatement ps = null;
        try {    
            ps = CON.getCnn().prepareStatement(SQL_DELETE);
            ps.setInt(1, obj.getId());
            int rs = ps.executeUpdate();
            if(rs > 0)
            {
                return true;
            }
        } catch (SQLException | NullPointerException ex) {
            System.out.println("Error usuario delete sql " + ex.getMessage());
        }
        finally
        {
            try {
                if(ps != null){
                    ps.close();
                }
            } catch (SQLException ex) {
                System.out.println("error usuario finally delete = " + ex.getMessage());
            
            }
            CON.cerrarConexion();
        }
        return false;
    }
    
}
