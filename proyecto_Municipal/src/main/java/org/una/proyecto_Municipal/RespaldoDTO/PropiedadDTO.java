package org.una.proyecto_Municipal.dto;

import lombok.*;

import java.math.BigInteger;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
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
