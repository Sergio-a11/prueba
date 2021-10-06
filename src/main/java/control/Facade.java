/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.List;
import modelo.dao.ProductoDAO;
import modelo.dto.ProductoDTO;

/**
 *
 * @author Sergio Cruz
 */
public class Facade {
    
    ProductoDAO objP = new ProductoDAO();
    
    public List<ProductoDTO> listarProductos()
    {
        return objP.readAll();
    }
    
}
