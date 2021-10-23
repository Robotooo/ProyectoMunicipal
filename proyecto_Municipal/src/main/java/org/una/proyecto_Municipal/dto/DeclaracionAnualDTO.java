package org.una.proyecto_Municipal.dto;

import lombok.*;

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
