package com.example.springPostgres.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name= "Indirizzo")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
public class Indirizzo implements Serializable {
    @Id
    private Long idaddress;

    @Column(name="idana", nullable = false)
    private Long idana;

    @Column(name="descrizione", nullable = false)
    private String descrizione;

    @Column(name = "date_create", nullable = false)
    private java.util.Date date_create;

    @Column(name = "date_agg", nullable = false)
    private java.util.Date date_agg;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idana", insertable = false, updatable = false)
    @Fetch(FetchMode.JOIN)
    private Anagrafica anagrafica;


}