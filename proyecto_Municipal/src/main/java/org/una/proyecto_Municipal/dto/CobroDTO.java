package org.una.proyecto_Municipal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.una.proyecto_Municipal.entities.BienxColaborador;
import org.una.proyecto_Municipal.entities.Factura;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CobroDTO {
    private Long id;
    private double monto;
    private boolean estado;
    private Integer periodo;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private BienxColaboradorDTO bienxColaboradorId;
    private FacturaDTO facturaId;
}
