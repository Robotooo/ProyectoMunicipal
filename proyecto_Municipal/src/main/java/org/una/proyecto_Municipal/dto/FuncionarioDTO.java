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
public class FuncionarioDTO {
    private Long id;
    private String usuario;
    private String telefono;
    private String cedula;
    private boolean estado;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private String passwordEncriptado;
    private RolDTO rol;
    @JsonIgnore
    private List<TransaccionDTO> transaccion= new ArrayList<>();
    @JsonIgnore
    private List<SolicitudDTO> solicitudesRecibidas = new ArrayList<>();
    @JsonIgnore
    private List<SolicitudDTO> solicitudesEnviadas = new ArrayList<>();
}
