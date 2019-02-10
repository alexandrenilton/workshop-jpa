package com.abelem.onetomany.entity;



import javax.persistence.*;
import java.util.List;

@Entity
public class Marque {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    @Column
    private String country;

    @OneToMany(mappedBy = "marque")
    private List<Modele> modeles;


    public List<Modele> getModeles() {
        return modeles;
    }

    public void setModeles(List<Modele> modeles) {
        this.modeles = modeles;
    }

    public Marque(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public Marque() {
    }

    @Override
    public String toString() {
        return "Marque{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country=" + country +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
