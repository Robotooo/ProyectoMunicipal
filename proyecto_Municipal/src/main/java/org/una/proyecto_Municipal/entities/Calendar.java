package org.una.proyecto_Municipal.entities;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "calendar")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Calendar  implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "monto")
    private double monto;

    @Column(name = "tipo")
    private int tipo;

    @Column(name = "porcentaje")
    private Integer porcentaje;

    @Column(name = "fecha_1", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date fecha1;

    @Column(name = "fecha_2", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date fecha2;

    @Column(name = "fecha_3", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date fecha3;

    @Column(name = "fecha_4", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date fecha4;

    @Column(name = "fecha_5", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date fecha5;

    @Column(name = "fecha_6", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date fecha6;

    @Column(name = "fecha_7", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date fecha7;

    @Column(name = "fecha_8", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date fecha8;

    @Column(name = "fecha_9", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date fecha9;

    @Column(name = "fecha_10", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date fecha10;

    @Column(name = "fecha_11", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date fecha11;

    @Column(name = "fecha_12", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date fecha12;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
