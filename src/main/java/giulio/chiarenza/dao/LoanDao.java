package giulio.chiarenza.dao;

import giulio.chiarenza.entities.Book;
import giulio.chiarenza.entities.Loan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class LoanDao {
    private final EntityManager em;
    public LoanDao(EntityManager em){this.em=em;}
    public void save(Loan loan){
        EntityTransaction transaction= em.getTransaction();
        transaction.begin();
        em.persist(loan);
        transaction.commit();
        System.out.println("loan " + loan.getLoans_id() + " salvato!");
    }
}
