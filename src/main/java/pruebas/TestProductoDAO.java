/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.util.List;
import modelo.dao.ProductoDAO;
import modelo.dto.ProductoDTO;

/**
 *
 * @author Sergio Cruz
 */
public class TestProductoDAO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //read all
        ProductoDAO objDAO = new ProductoDAO();
        List<ProductoDTO> lista = objDAO.readAll();
        for (ProductoDTO i : lista) {
            System.out.println(i);
        }
        
        //create
        ProductoDTO dto = new ProductoDTO("platano", "platano maduro re verde", 30, 1500);
        boolean create = objDAO.create(dto);
        System.out.println("create = " + create);
        
        //read / buscar
        ProductoDTO p = new ProductoDTO();
        p.setId(4);
        p = objDAO.read(p);
        if(p != null)
        {
            System.out.println("p = " + p);
        }
        else
        {
            System.out.println("No se encontro el registro");
        }

        //delete
//        ProductoDTO p = new ProductoDTO();
//        p.setId(6);
//        boolean rs = objDAO.delete(p);
//        System.out.println("rs = " + rs);

        //Actualizar
//        p.setValor(2550);
//        p.setUnidades(100);
//        if(objDAO.update(p))
//        {
//            System.out.println("Se actualizo con exito");
//            objDAO.read(p);
//            System.out.println("p = " + p);
//        }
//        else
//        {
//            System.out.println("No se encontro el registro");
//        }
    }
    
}
