package com.abelem.bidirectional.onetomany.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Dog {
    @Id
    private Long id;

    @Column(name = "pet_name")
    private String petName;
}
