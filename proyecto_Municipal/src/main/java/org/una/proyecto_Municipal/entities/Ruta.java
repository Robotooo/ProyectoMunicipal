package org.una.proyecto_Municipal.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "rutas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Ruta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_ruta", length = 45)
    private String nombreRuta;

    @Column(name = "inicio", length = 45)
    private String inicioRuta;

    @Column(name = "final_ruta", length = 45)
    private String finalRuta;

    @ManyToOne
    @JoinColumn(name="bienes_id")
    @JsonBackReference
    private Bien bienesId;

    @Column(name = "estado")
    private Boolean estado;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rutaId")
    private List<DiaSemana> dia = new ArrayList<>();

    @Column(name = "fecha_registro", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fechaRegistro;

    @Column(name = "fecha_modificacion")
    @Setter(AccessLevel.NONE)
    @Temporal(TemporalType.DATE)
    private Date fechaModificacion;

    private static final long serialVersionUID = 1L;

    @PrePersist
    public void prePersist() {
        estado = true;
        fechaRegistro = new Date();
        fechaModificacion = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        fechaModificacion = new Date();
    }

}
