package org.una.proyecto_Municipal.dto;

import lombok.*;
import org.una.proyecto_Municipal.entities.Bien;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ColaboradorDTO {
    private Long id;
    private String nombre;
    private String cedula;
    private String telefono;
    private boolean estado;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private BienxColaboradorDTO bienxColaborador;
//    private Bien bien;
}
