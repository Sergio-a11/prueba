/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.sql.Date;
import java.util.List;
import modelo.dao.UsuarioDAO;
import modelo.dto.UsuarioDTO;

/**
 *
 * @author Sergio Cruz
 */
public class TestUsuarioDAO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UsuarioDAO dao = new UsuarioDAO();
        //create
//        UsuarioDTO dto = new UsuarioDTO("Juan", "Camilo", "less", "lastname", "123478965", "correo@correo.com", "a234", "M", Date.valueOf("2015-03-12"),1);
//        boolean create = dao.create(dto);
//        System.out.println("create = " + create);

        //read all
        List<UsuarioDTO> readAll = dao.readAll();
        for (UsuarioDTO usuarioDTO : readAll) {
            System.out.println("usuarioDTO = " + usuarioDTO);
        }
        
        
        //read
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(8);
        dto = dao.read(dto);
        System.out.println("dto = " + dto);
        
        //update
////        dto.setNombre1("Camilo");
////        dto.setCorreo("nuevo@correo.com");
////        dto.setEstado(0);
////        dto.setFecha_nacimineto(Date.valueOf("2001-09-11"));
////        boolean update = dao.update(dto);
////        System.out.println("update = " + update);
////        
////        dto = dao.read(dto);
////        System.out.println("dto = " + dto);
        
        //delete
        boolean delete = dao.delete(dto);
        System.out.println("delete = " + delete);
        
        dto = dao.read(dto);
        System.out.println("dto = " + dto);
    }
    
}
