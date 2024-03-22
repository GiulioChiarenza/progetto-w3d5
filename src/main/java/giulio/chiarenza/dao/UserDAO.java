package giulio.chiarenza.dao;

import giulio.chiarenza.entities.Book;
import giulio.chiarenza.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class UserDAO {
    private final EntityManager em;
    public UserDAO(EntityManager em){this.em=em;}
    public void save(User user){
        EntityTransaction transaction= em.getTransaction();
        transaction.begin();
        em.persist(user);
        transaction.commit();
        System.out.println("User " + user.getName() + " salvato!");
    }
}
