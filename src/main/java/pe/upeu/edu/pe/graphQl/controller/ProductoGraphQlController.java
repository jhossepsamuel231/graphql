package pe.upeu.edu.pe.graphQl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import pe.upeu.edu.pe.graphQl.dto.ProductoRequest;
import pe.upeu.edu.pe.graphQl.entity.Categoria;
import pe.upeu.edu.pe.graphQl.entity.Producto;
import pe.upeu.edu.pe.graphQl.repository.CategoriaRepository;
import pe.upeu.edu.pe.graphQl.repository.ProductoRepository;

import java.util.List;
import java.util.UUID;

@Controller
public class ProductoGraphQlController {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @QueryMapping
    public List<Producto> listarProductos(){
        return productoRepository.findAll();
    }

    @QueryMapping
    public Producto listarProductoPorId(@Argument int id) {
        return productoRepository.findById(id).orElse(null);
    }

    @QueryMapping
    public List<Categoria> listarCategorias(){
        return categoriaRepository.findAll();
    }

    @QueryMapping
    public Categoria listarCategoriaPorId(@Argument int id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    @MutationMapping
    public Producto guardarProducto(@Argument ProductoRequest productoRequest) {
        Categoria categoria = categoriaRepository.findById(productoRequest.categoriaId()).orElse(null);
        Producto productoBBDD = new Producto();
        productoBBDD.setNombre(productoRequest.nombre());
        productoBBDD.setPrecio(productoRequest.precio());
        productoBBDD.setCantidad(productoRequest.cantidad());
        productoBBDD.setCategoria(categoria);

        return productoRepository.save(productoBBDD);
    }

    @MutationMapping
    public Producto actualizarProducto(@Argument int id ,@Argument ProductoRequest productoRequest) {
        Categoria categoria = categoriaRepository.findById(productoRequest.categoriaId()).orElse(null);
        Producto productoBBDD = new Producto();
        productoBBDD.setId(id);
        productoBBDD.setNombre(productoRequest.nombre());
        productoBBDD.setPrecio(productoRequest.precio());
        productoBBDD.setCantidad(productoRequest.cantidad());
        productoBBDD.setCategoria(categoria);

        return productoRepository.save(productoBBDD);
    }

    @MutationMapping
    public void eliminarProducto(@Argument int id) {
        productoRepository.deleteById(id);
    }
}
