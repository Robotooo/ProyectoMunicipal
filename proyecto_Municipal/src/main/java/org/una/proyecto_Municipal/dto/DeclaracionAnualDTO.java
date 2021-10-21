package org.una.proyecto_Municipal.dto;

import lombok.*;
import org.una.proyecto_Municipal.entities.Licencia;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class DeclaracionAnualDTO {
    private Long id;
    private LicenciaDTO licenciaId;
    private double montoAnual;
    private float anio;
}
