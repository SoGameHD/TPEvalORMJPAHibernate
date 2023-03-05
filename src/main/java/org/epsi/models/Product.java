package org.epsi.models;
import jakarta.persistence.*;
import java.util.Collection;

@Entity(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String code;
    @Column
    private String label;
    @Column
    private ProdType type;

    @Column
    private Double price;
    @ManyToMany(mappedBy = "products")
    private Collection<PetStore> petStores;

    public Collection<PetStore> getPetStores() {
        return petStores;
    }

    public void setPetStores(Collection<PetStore> petStores) {
        this.petStores = petStores;
    }

    public Product(String code, String label, ProdType type, Double price) {
        this.code = code;
        this.label = label;
        this.type = type;
        this.price = price;
    }
}
