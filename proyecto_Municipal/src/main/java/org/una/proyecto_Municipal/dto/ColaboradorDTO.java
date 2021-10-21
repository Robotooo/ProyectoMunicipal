package org.una.proyecto_Municipal.dto;

import lombok.*;
import org.una.proyecto_Municipal.entities.BienxColaborador;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ColaboradorDTO {
    private long id;
    private String nombre;
    private String cedula;
    private String telefono;
    private boolean estado;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private BienxColaboradorDTO bienxColaborador;
}
