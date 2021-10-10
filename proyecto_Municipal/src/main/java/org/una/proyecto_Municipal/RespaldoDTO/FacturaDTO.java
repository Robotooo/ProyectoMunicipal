package org.una.proyecto_Municipal.dto;

import lombok.*;

import java.math.BigInteger;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class FacturaDTO {

    private Long id;
    private Date fecha_cancelacion;
    private String nombre;
    private Double monto_cancelar;
    private String tipo_pago;
    private FuncionarioDTO cajero_id;

}
