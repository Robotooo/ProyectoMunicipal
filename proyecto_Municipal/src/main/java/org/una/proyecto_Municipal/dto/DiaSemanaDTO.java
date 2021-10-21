package org.una.proyecto_Municipal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.una.proyecto_Municipal.entities.Ruta;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DiaSemanaDTO {
    private Long id;
    private Integer cantidadSalidas;
    private String nombreDia;
    private RutaDTO rutaId;
}
