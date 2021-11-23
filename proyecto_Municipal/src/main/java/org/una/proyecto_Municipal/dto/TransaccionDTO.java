package org.una.proyecto_Municipal.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class TransaccionDTO {

    private Long id;
    private String accion;
    private String objeto;
    private String parametro;
    private Date fechaCreacion;
    private FuncionarioDTO funcionarioId;

}
