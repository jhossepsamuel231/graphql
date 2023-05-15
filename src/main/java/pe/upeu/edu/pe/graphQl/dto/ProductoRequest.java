package pe.upeu.edu.pe.graphQl.dto;

public record ProductoRequest(
        Integer id,
        String nombre,
        double precio,
        int cantidad,
        int categoriaId
) {
}
