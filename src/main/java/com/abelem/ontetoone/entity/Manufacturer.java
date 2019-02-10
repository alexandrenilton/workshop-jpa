package com.abelem.ontetoone.entity;

import javax.persistence.*;

@Entity
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    @Column
    private boolean active;

    public boolean isActive() {
        return active;
    }

    public Manufacturer(String name, boolean active, ManufacturerDetails details) {
        this.name = name;
        this.active = active;
        this.details = details;
    }

    @OneToOne(cascade = CascadeType.ALL)
    private ManufacturerDetails details;

    @Override
    public String toString() {
        return "Manufacturer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", active=" + active +
                ", details=" + details.toString() +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ManufacturerDetails getDetails() {
        return details;
    }

    public void setDetails(ManufacturerDetails details) {
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
