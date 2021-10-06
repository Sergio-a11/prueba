/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Sergio Cruz
 */
public class ProductoDTO implements Serializable{
    private int id;
    private String nombre_producto;
    private String descripcion_producto;
    private int unidades;
    private int valor;

    public ProductoDTO(int id, String nombre_producto, String descripcion_producto, int unidades, int valor) {
        this.id = id;
        this.nombre_producto = nombre_producto;
        this.descripcion_producto = descripcion_producto;
        this.unidades = unidades;
        this.valor = valor;
    }

    public ProductoDTO() {
    }

    public ProductoDTO(String nombre_producto, String descripcion_producto, int unidades, int valor) {
        this.nombre_producto = nombre_producto;
        this.descripcion_producto = descripcion_producto;
        this.unidades = unidades;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getDescripcion_producto() {
        return descripcion_producto;
    }

    public void setDescripcion_producto(String descripcion_producto) {
        this.descripcion_producto = descripcion_producto;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.id;
        hash = 17 * hash + Objects.hashCode(this.nombre_producto);
        hash = 17 * hash + Objects.hashCode(this.descripcion_producto);
        hash = 17 * hash + this.unidades;
        hash = 17 * hash + this.valor;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProductoDTO other = (ProductoDTO) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.unidades != other.unidades) {
            return false;
        }
        if (this.valor != other.valor) {
            return false;
        }
        if (!Objects.equals(this.nombre_producto, other.nombre_producto)) {
            return false;
        }
        if (!Objects.equals(this.descripcion_producto, other.descripcion_producto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id: " + id + " nombre_producto: " + nombre_producto + " valor: $" + valor;
    }
    
    
    
}
