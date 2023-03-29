package com.mercadona.laProveta.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Palet {

    @Id
    @Column(length = 18)
    private Long id;

    @OneToOne
    @JoinColumn(name = "idArticulo")
    private  Product product;

    @Column(columnDefinition = "VARCHAR(200)")
    private String name;

    @Column(columnDefinition = "VARCHAR(20)")
    private String nLote;

    @Column(length = 6)
    private Date dateMade;

    @Column(length = 7)
    private Long weight;
}
