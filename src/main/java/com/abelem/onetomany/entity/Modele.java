package com.abelem.onetomany.entity;

import javax.persistence.*;

@Entity
public class Modele {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    @Column
    private int nombre_portiere;

    @Column
    private double moteur;

    @Column
    private TransmissionEnum transmission;

    @Column
    private String numero_serie;

    @ManyToOne
    private Marque marque;

    public Modele(String name, int nombre_portiere, double moteur, TransmissionEnum transmission, String numero_serie, Marque marque) {
        this.name = name;
        this.nombre_portiere = nombre_portiere;
        this.moteur = moteur;
        this.transmission = transmission;
        this.numero_serie = numero_serie;
        this.marque = marque;
    }

    public Modele() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNombre_portiere() {
        return nombre_portiere;
    }

    public void setNombre_portiere(int nombre_portiere) {
        this.nombre_portiere = nombre_portiere;
    }

    public double getMoteur() {
        return moteur;
    }

    public void setMoteur(double moteur) {
        this.moteur = moteur;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public void setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
    }

    public String getNumero_serie() {
        return numero_serie;
    }

    public void setNumero_serie(String numero_serie) {
        this.numero_serie = numero_serie;
    }
}
