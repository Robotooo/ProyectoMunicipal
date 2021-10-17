package org.una.proyecto_Municipal.dto;

import lombok.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ColaboradorDTO {
    private Long id;
    private String nombre;
    private String cedula;
    private Integer telefono;
    private Boolean estado;
    private Date fechaCreacion;
    private Date fechaModificacion;
}
