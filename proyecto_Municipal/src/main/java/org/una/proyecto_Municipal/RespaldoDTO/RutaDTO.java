package org.una.proyecto_Municipal.dto;

import lombok.*;

import java.math.BigInteger;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class RutaDTO {

    private Long id;
    private String inicio_ruta;
    private String final_ruta;
    private int estado;
    private Date fecha_registro;
    private Date fecha_modificacion;

}
