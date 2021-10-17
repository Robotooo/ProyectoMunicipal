package org.una.proyecto_Municipal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.una.proyecto_Municipal.entities.Bien;

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
    private Float area;
    private String plano;
    private String metros;
    private String valorTerreno;
    private String valorConstruccion;
    private String valorOtros;
    private Boolean esEstado;
    private Integer zona;
    private Boolean estado;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Bien bienId;
}
