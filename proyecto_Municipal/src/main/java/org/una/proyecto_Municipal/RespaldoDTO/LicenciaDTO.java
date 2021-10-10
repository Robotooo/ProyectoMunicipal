package org.una.proyecto_Municipal.dto;

import lombok.*;

import java.math.BigInteger;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class LicenciaDTO {

    private Long id;
    private String nombre;
    private String telefono;
    private String email;
    private String distrito;
    private Boolean estado;
    private Date fecha_registro;
    private Date fecha_modificacion;
    private Double ganancias;
    private Long bien_id;

}
