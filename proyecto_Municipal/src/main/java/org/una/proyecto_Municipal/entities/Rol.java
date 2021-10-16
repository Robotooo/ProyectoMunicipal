package org.una.proyecto_Municipal.entities;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Rol implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 45)
    private String nombre;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rol")
    private List<Funcionario> funcionarios = new ArrayList<>();

    @Column(name = "fecha_creacion", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fecha_creacion;

    @PrePersist
    public void prePersist() {
        fecha_creacion = new Date();
    }

}
