package org.una.proyecto_Municipal.dto;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClienteDTO {

    private Long id;
    private String nombre;
    private String cedula;
    private Integer telefono;
    private boolean estado;
    private Date fecha_creacion;
    private Date fecha_modificacion;

}
