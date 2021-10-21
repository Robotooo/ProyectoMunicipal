package org.una.proyecto_Municipal.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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

public class Bien implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bienId")
    private List<BienxColaborador> bienxColaborador = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bienId")
    private List<Propiedad> propiedad = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bienId")
    private List<Licencia> licencia = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bienId")
    private List<Ruta> ruta = new ArrayList<>();

    private static final long serialVersionUID = 1L;

}
