package org.una.proyecto_Municipal.dto;

import lombok.*;
import org.una.proyecto_Municipal.entities.Cobro;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class FacturaDTO {
    private Long id;
    private Date fechaCancelacion;
    private String nombre;
    private Double montoCancelar;
    private String tipoPago;
    private FuncionarioDTO cajeroId;
    private CobroDTO cobros;
}
