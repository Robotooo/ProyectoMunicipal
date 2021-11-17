package org.una.proyecto_Municipal.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.una.proyecto_Municipal.entities.Licencia;
import org.una.proyecto_Municipal.entities.Propiedad;
import org.una.proyecto_Municipal.entities.Ruta;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BienDTO {
    private Long id;
    //private List<BienxColaboradorDTO> bienesxColaborador;
//    private ColaboradorDTO colaborador;
    //@JsonIgnore
    private List<PropiedadDTO> propiedades=new ArrayList<>();
    private List<LicenciaDTO> licencia=new ArrayList<>();
    private List<RutaDTO> ruta = new ArrayList<>();
}
