package com.example.springPostgres.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name= "recapiti_telefonici")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
public class RecapitiTelefonici implements Serializable {
    @Id
    private Long idreca;

    @Column(name="idana", nullable = false)
    private Long idana;

    @Column(name="tipo_recapito", nullable = false)
    private String tipo_recapito;

    @Column(name="numero_recapito", nullable = false)
    private String numero_recapito;

    @ManyToOne()
    @JoinColumn(name = "idana", nullable = false, insertable = false, updatable = false)
    private Anagrafica anagrafica;
}
