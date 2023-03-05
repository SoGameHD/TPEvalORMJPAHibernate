package org.epsi.models;
import jakarta.persistence.*;
import java.util.Date;

@Entity(name = "animal")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Date birth;
    @Column
    private String couleur;

    @ManyToOne(optional = false)
    private PetStore petStore;

    public Animal(Date birth, String couleur, PetStore petStores) {
        this.birth = birth;
        this.couleur = couleur;
        this.petStore = petStores;
    }

    public PetStore getPetStore() {
        return petStore;
    }

    public void setPetStore(PetStore petStores) {
        this.petStore = petStores;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", birth=" + birth +
                ", couleur='" + couleur + '\'' +
                ", petStores=" + petStore +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public Date getBirth() {
        return birth;
    }

    public String getCouleur() {
        return couleur;
    }
}
