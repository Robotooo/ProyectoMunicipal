package org.una.proyecto_Municipal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FacturaDTO {
    private Long id;
    private Date fecha_cancelacion;
    private String nombre;
    private Double monto_cancelar;
    private String tipo_pago;
}
