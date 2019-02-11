package com.abelem.manytomany.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Feature {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @ManyToMany(mappedBy = "features")
    private List<Auto> autos;

    public Feature(String name, List<Auto> autos) {
        this.name = name;
        this.autos = autos;
    }

    public Feature() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Auto> getAutos() {
        return autos;
    }

    public void setAutos(List<Auto> autos) {
        this.autos = autos;
    }
}
