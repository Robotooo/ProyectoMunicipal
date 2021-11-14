package org.una.proyecto_Municipal.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bienes_colaboradores")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BienxColaborador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @EmbeddedId
//    BienesxColaboradorKey bienesxColaboradorKey;

    //@MapsId("colaboradorId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ManyToOne
    @JoinColumn(name="colaboradores_id")
    private Colaborador colaboradorId;

    //@MapsId("bienId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ManyToOne
    @JoinColumn(name="bienes_id")
    private Bien bienId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bienxColaborador")
    private List<Cobro> cobros = new ArrayList<>();

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bien")
//    private List<Cobro> cobroBien = new ArrayList<>();

    @Column(name = "porcentaje")
    private float porcentaje;

//    private static final long serialVersionUID = 1L;

}
