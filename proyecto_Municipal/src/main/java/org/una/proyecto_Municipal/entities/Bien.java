package org.una.proyecto_Municipal.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bienes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Bien implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bienId")
    private List<BienxColaborador> bienxColaborador = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Colaborador> colaboradores = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bienesId")
    private List<Propiedad> propiedad = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bienesId")
    private List<Licencia> licencia = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bienesId")
    private List<Ruta> ruta = new ArrayList<>();

    private static final long serialVersionUID = 1L;

}
