package com.abelem.dao;

import com.abelem.bidirectional.onetoone.entity.Address;
import com.abelem.bidirectional.onetoone.entity.Person;
import com.abelem.elementcollection.entity.Vehicule;
import com.abelem.onetomany.entity.Marque;
import com.abelem.onetomany.entity.Modele;
import com.abelem.onetomany.entity.TransmissionEnum;
import com.abelem.simpletable.entity.Employee;
import com.abelem.ontetoone.entity.Manufacturer;
import com.abelem.ontetoone.entity.ManufacturerDetails;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Arrays;

public class Jpatest {

    public static EntityManager em;

    public static void main(String... args) {
        em = JpaUtil.getEntityManager();

        em.getTransaction().begin();

//        remplirEmployees();
//        remplirManufacturers();
//        remplirMarquesModeles();
//        remplirVehicule();

        testBidirectionalRelationship();

        em.getTransaction().commit();


        em.getTransaction().begin();

        Person pFound = findPersonById(1L);
        Address aFound = findAddressById(1L);

        em.getTransaction().commit();

        System.out.println("Person found.: " + pFound);
        System.out.println("Address found.: " + aFound);

        System.out.println("pFound.getAddress().: "+ pFound.getAddress());
        System.out.println("aFound.getPerson().: " + aFound.getPerson());


        /* vai deletar manufacturer e manufacturerDetails*/
        // deleteManufacturerDetails(1);
    }

    public static Person findPersonById(Long id){
        return em.find(Person.class, 1L);
    }

    public static Address findAddressById(Long id){
        return em.find(Address.class, 1L);
    }

    public static void testBidirectionalRelationship() {
        Address address = createAddress(1L, "Av. das Nações nr 192");
        createPerson(1L, "Alexandre", address );

    }

    public static void createPerson(Long id, String name, Address address){
        Person p = new Person();
        p.setId(id);
        p.setName(name);
        p.setAddress(address); // erro?? object references an unsaved transient instance - save the transient instance before
        em.persist(p);
    }

    public static Address createAddress(Long id, String street){
        Address a = new Address();
        a.setId(id);
        a.setStreet(street);
        em.persist(a);
        return a;
    }

    public static void remplirEmployees(){
        createEmployee("Ravi", "Raj", "Textile");
        createEmployee("Amit", "Raj", "IT");
        createEmployee("Nitish", "Kumar", "Marketing");
    }

    public static void remplirManufacturers() {
        createManufacturerWithDetails("Troller", "Brazil", 1995, "+55 1128381233");
        createManufacturerWithDetails("Honda", "Japan", 1965, "+76 82881221");
        createManufacturerWithDetails("Suzuki", "Japan", 1921, "+76 2332123");
        createManufacturerWithDetails("Mitsubish", "Japan", 1980, "+76 2112311");
        createManufacturerWithDetails("Kia Motors", "South Korea", 2001, "+98 293999123");
    }

    public static void remplirMarquesModeles() {
        Marque m1 = new Marque("Honda", "Japan");
        Modele m1m1 = new Modele("Fit", 4, 1.4, TransmissionEnum.AUTOMATIQUE, "2D4RN4DE9AR287726", m1);
        Modele m1m2 = new Modele("Civic", 4, 1.8, TransmissionEnum.AUTOMATIQUE, "1FGRREE9AR381724", m1);
        Modele m1m3 = new Modele("Accord", 4, 2.5, TransmissionEnum.AUTOMATIQUE, "5FHDJEUU9AR648294", m1);


        em.persist(m1);
        em.persist(m1m1);
        em.persist(m1m2);
        em.persist(m1m3);

        Marque m2 = new Marque("Dodge", "EUA");
        em.persist(m2);
        Modele m2m1 = new Modele("Ram", 5, 3.3, TransmissionEnum.MANUELE, "23FGTHEK121LD5", m2);
        em.persist(m2m1);

    }

    public static void remplirVehicule() {
        Vehicule v = new Vehicule("Fit", Arrays.asList("air", "airbag", "automatique", "essence", "mp3", "abs"));
        em.persist(v);
    }


    private static void createEmployee(String firstName,
                                       String lastName, String dept) {
        Employee emp = new Employee(firstName, lastName, dept);
        em.persist(emp);
    }



    private static void createManufacturerWithDetails(String name, String country, int yearFoundation, String phone){
        ManufacturerDetails details = new ManufacturerDetails(country, yearFoundation, phone);
        em.persist(details);
        Manufacturer m = new Manufacturer(name, true, details);
        em.persist(m);
    }

    private static void deleteManufacturerDetails(int id) {
        Manufacturer m = em.find(Manufacturer.class, 1);
        System.out.println("Manufacturer.: " +m.toString());
        em.remove(m);
    }

}
