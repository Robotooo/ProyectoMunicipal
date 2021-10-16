package org.una.proyecto_Municipal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.una.proyecto_Municipal.entities.Cobro;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FacturaDTO {
    private Long id;
    private Date fechaCancelacion;
    private String nombre;
    private Double montoCancelar;
    private String tipoPago;
    private FuncionarioDTO cajeroId;
    private Cobro cobros;
}
