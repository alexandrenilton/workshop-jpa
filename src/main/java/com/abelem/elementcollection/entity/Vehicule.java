package com.abelem.elementcollection.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Vehicule {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    @ElementCollection @Column(length = 20)
    private List<String> tags;

    public Vehicule() {
    }

    public Vehicule(String name, List<String> tags) {
        this.name = name;
        this.tags = tags;
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

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
