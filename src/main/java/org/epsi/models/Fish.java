package org.epsi.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.util.Date;

@Entity(name="fish")
public class Fish extends Animal{
    @Column
    private FishLivEnv livingEnv;

    public Fish(Date birth, String couleur, PetStore petStores, FishLivEnv livingEnv) {
        super(birth, couleur, petStores);
        this.livingEnv = livingEnv;
    }

    @Override
    public String toString() {
        return "Fish{" +
                "id=" + getId()+
                "birth=" + getBirth() +
                "petStore=" + getCouleur() +
                "livingEnv=" + livingEnv +
                '}';
    }

}
