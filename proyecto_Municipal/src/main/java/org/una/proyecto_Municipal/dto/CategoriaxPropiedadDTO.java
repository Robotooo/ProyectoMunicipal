package org.una.proyecto_Municipal.dto;

import lombok.*;
import org.una.proyecto_Municipal.entities.CategoriaBasura;
import org.una.proyecto_Municipal.entities.Propiedad;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CategoriaxPropiedadDTO {
    private Long id;
    private CategoriaBasuraDTO categoriaBasuraId;
    private PropiedadDTO propiedad;
    private Integer cantidad;
}
