package org.una.proyecto_Municipal.dto;

import lombok.*;
import org.una.proyecto_Municipal.entities.Bien;

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
    private boolean estado;
    private Date fechaRegistro;
    private Date fechaModificacion;
    private double ganancias;
    private BienDTO bienId;
}
