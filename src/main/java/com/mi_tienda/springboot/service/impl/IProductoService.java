package com.mi_tienda.springboot.service.impl;

import com.mi_tienda.springboot.entity.Producto;
import java.util.List;

public interface IProductoService {
    
    public List<Producto> verProductos();
    public void crearProducto(Producto producto);
    public void editarProducto(Long id,Producto producto);
    public void eliminarProducto(Long id);
    public Producto buscarProducto(Long id);
    
}
