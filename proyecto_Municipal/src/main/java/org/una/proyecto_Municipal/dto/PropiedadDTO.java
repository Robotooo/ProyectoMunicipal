package org.una.proyecto_Municipal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
    private String valor_terreno;
    private String valor_construccion;
    private String valorOtros;
    private boolean es_estado;
    private Integer zona;
    private boolean estado;
    private Date fecha_creacion;
    private Date fecha_modificacion;
}
