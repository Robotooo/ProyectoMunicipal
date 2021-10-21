package org.una.proyecto_Municipal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.una.proyecto_Municipal.entities.Licencia;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DeclaracionAnualDTO {
    private long id;
    private LicenciaDTO licenciaId;
    private double montoAnual;
    private float anio;
}
