package org.una.proyecto_Municipal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.una.proyecto_Municipal.entities.Bien;
import org.una.proyecto_Municipal.entities.CategoriaxPropiedad;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PropiedadDTO {
    private Long id;
    private String provincia;
    private String canton;
    private String distrito;
    private String direccion;
    private String geolocalizacion;
    private float area;
    private String plano;
    private String metros;
    private String valorTerreno;
    private String valorConstruccion;
    private String valorOtros;
    private boolean esEstado;
    private Integer zona;
    private boolean estado;
    private Date fechaRegistro;
    private Date fechaModificacion;
    private BienDTO bienId;
    private CategoriaxPropiedadDTO categoriaxPropiedad;
}
