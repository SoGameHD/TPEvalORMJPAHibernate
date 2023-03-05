package org.epsi;
import jakarta.persistence.*;
import org.epsi.models.*;
import java.sql.Statement;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("---------------------- Start -------------------");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("petStore");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Address address = new Address("6", "Rue Rose Dieng-Kuntz", "44300", "Nantes");
        em.persist(address);
        Address address2 = new Address("3", "Avenue de Pragues", "44000", "Nantes");
        em.persist(address2);
        Address address3 = new Address("24", "Impasse du bonheur", "44119", "Trellières");
        em.persist(address3);

        Product product1 = new Product("EAERT21", "Croquettes Royal Canin", ProdType.CLEANING, 12.2);
        em.persist(product1);
        Product product2 = new Product("FDSFS32", "Couchette Domus gris S", ProdType.FOOD, 32.1);
        em.persist(product2);
        Product product3 = new Product("HJHKJ56", "Balles avec corde", ProdType.ACCESSORY, 20.5);
        em.persist(product3);

        Set<Product> productSet = new HashSet<>();
        productSet.add(product1);
        productSet.add(product2);
        productSet.add(product3);

        PetStore petStore = new PetStore("Pet Shop", "Mahurin Ratié", productSet, address);
        em.persist(petStore);
        PetStore petStore2 = new PetStore("Shop and Pet", "Inès Boucard", productSet, address2);
        em.persist(petStore2);
        PetStore petStore3 = new PetStore("All for your pet", "Mael Loussouarn", productSet, address3);
        em.persist(petStore3);

        Fish fish1 = new Fish(new Date(2023, 10, 12), "bleu", petStore, FishLivEnv.FRESH_WATER);
        em.persist(fish1);
        Fish fish2 = new Fish(new Date(2022, 11, 12), "vert",petStore2,  FishLivEnv.SEA_WATER);
        em.persist(fish2);
        Fish fish3 = new Fish(new Date(2023, 3, 2), "rouge",petStore3, FishLivEnv.FRESH_WATER);
        em.persist(fish3);


        Cat cat1 = new Cat(new Date(2023, 3, 2), "blanc", petStore, "GGHYTB21");
        em.persist(cat1);
        Cat cat2 = new Cat(new Date(2022, 6, 20), "roux", petStore2, "DGRSGD23");
        em.persist(cat2);
        Cat cat3 = new Cat(new Date(2021, 9, 3), "tricolor", petStore3, "FGFSSGH67");
        em.persist(cat3);

        em.getTransaction().commit();

        Query findAllQUery = em.createQuery("select a from animal a where a.petStore.id=2 ");
        System.out.println(findAllQUery.getResultList());

        em.close();
        emf.close();
    }
}