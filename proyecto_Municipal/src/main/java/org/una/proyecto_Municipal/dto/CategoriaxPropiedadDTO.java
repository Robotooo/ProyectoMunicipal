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
    private long id;
    private CategoriaBasuraDTO categoriaBasuraId;
    private PropiedadDTO propiedad;
    private Integer cantidad;
}
