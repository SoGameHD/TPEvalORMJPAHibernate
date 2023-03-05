package org.epsi.models;
import jakarta.persistence.*;
import java.util.Date;


@Entity(name="cat")
public class Cat extends Animal{
    @Column
    private String chipid;

    public Cat(Date birth, String couleur, PetStore petStores, String chipid) {
        super(birth, couleur, petStores);
        this.chipid = chipid;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + getId()+
                "birth=" + getBirth() +
                "petStore=" + getCouleur() +
                "chipid='" + chipid + '\'' +
                '}';
    }
}
