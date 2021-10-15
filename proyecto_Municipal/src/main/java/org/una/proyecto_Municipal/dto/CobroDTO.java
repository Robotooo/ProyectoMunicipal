package org.una.proyecto_Municipal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.una.proyecto_Municipal.entities.Bien;
import org.una.proyecto_Municipal.entities.Colaborador;
import org.una.proyecto_Municipal.entities.Factura;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CobroDTO {
    private Long id;
    private boolean estado;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Colaborador colaboradores;
    private Bien bienId;
    private Factura facturaId;
}
