package org.una.proyecto_Municipal.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categorias_basura")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CategoriaBasura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoriaBasuraId")
    private List<CategoriaxPropiedad> categoriaxPropiedad = new ArrayList<>();

    private static final long serialVersionUID = 1L;

}
