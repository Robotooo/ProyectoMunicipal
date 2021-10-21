package org.una.proyecto_Municipal.dto;

import lombok.*;
import org.una.proyecto_Municipal.entities.Ruta;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class DiaSemanaDTO {
    private Long id;
    private Integer cantidadSalidas;
    private String nombreDia;
    private RutaDTO rutaId;
}
