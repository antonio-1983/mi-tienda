package com.mi_tienda.springboot.service.impl;

import com.mi_tienda.springboot.entity.Carrito;
import java.util.List;


public interface ICarritoService {
    public List<Carrito> verCarritos();
    public void crearCarrito(Carrito carrito);
    public void editarCarrito(Long id,Carrito carrito);
    public void eliminarCarrito(Long id);
    public Carrito buscarCarrito(Long id);

}
