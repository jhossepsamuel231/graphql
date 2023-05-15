package pe.upeu.edu.pe.graphQl.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre_producto")
    private String nombre;

    @Column(name = "precio_producto")
    private double precio;

    @Column(name = "cantidad_producto")
    private int cantidad;

    @ManyToOne
    private Categoria categoria;
}
