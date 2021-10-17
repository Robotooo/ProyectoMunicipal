package org.una.proyecto_Municipal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.una.proyecto_Municipal.entities.CategoriaBasura;
import org.una.proyecto_Municipal.entities.Propiedad;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategoriaxPropiedadDTO {
    private Long id;
    private CategoriaBasura categoriaBasuraId;
    private Propiedad propiedad;
    private Integer cantidad;
}
