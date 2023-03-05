package org.epsi.models;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "petStore")
public class PetStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private String managerName;

    @ManyToMany
    @JoinTable(name = "petstore_product",
            joinColumns = @JoinColumn(name = "id_petstore"),
            inverseJoinColumns = @JoinColumn(name = "id_product"))
    private Set<Product> products = new HashSet<>();

    @OneToMany
    @JoinTable(name = "petstore_animal",
            joinColumns = @JoinColumn(name = "id_petstore"),
            inverseJoinColumns = @JoinColumn(name = "id_animal"))
    private Set<Animal> animals = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "id_address")
    private Address address;

    public Integer getId() {
        return id;
    }

    public PetStore(String name, String managerName, Set<Product> products, Address address) {
        this.name = name;
        this.managerName = managerName;
        this.products = products;
        this.address = address;
    }
}
