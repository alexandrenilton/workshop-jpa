package com.abelem.ontetoone.entity;

import javax.persistence.*;

@Entity
public class ManufacturerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String country;

    @Column(name="year_foundation")
    private int yearFoundation;

    @Column
    private String phone;

    @OneToOne (mappedBy = "details", cascade = CascadeType.ALL)
    private Manufacturer manufacturer;

    public ManufacturerDetails(String country, int yearFoundation, String phone) {
        this.country = country;
        this.yearFoundation = yearFoundation;
        this.phone = phone;
    }


    @Override
    public String toString() {
        return "ManufacturerDetails{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", yearFoundation=" + yearFoundation +
                ", phone='" + phone + '\'' +
                ", manufacturer=" + manufacturer +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getYearFoundation() {
        return yearFoundation;
    }

    public void setYearFoundation(int yearFoundation) {
        this.yearFoundation = yearFoundation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
