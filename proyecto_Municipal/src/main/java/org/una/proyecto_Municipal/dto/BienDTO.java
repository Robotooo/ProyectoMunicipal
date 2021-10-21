package org.una.proyecto_Municipal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.una.proyecto_Municipal.entities.BienxColaborador;
import org.una.proyecto_Municipal.entities.Licencia;
import org.una.proyecto_Municipal.entities.Propiedad;
import org.una.proyecto_Municipal.entities.Ruta;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BienDTO {
    private long id;
    private BienxColaboradorDTO bienxColaborador;
    private PropiedadDTO propiedad;
    private LicenciaDTO licencia;
    private RutaDTO ruta;
}
