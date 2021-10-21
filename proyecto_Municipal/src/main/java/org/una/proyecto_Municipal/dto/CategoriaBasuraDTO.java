package org.una.proyecto_Municipal.dto;

import lombok.*;
import org.una.proyecto_Municipal.entities.CategoriaxPropiedad;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CategoriaBasuraDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private CategoriaxPropiedadDTO categoriaxPropiedad;
}
