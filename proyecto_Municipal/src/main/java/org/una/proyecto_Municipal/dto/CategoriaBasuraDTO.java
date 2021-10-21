package org.una.proyecto_Municipal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.una.proyecto_Municipal.entities.CategoriaxPropiedad;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategoriaBasuraDTO {
    private long id;
    private String nombre;
    private String descripcion;
    private CategoriaxPropiedadDTO categoriaxPropiedad;
}
