package giulio.chiarenza.dao;

import giulio.chiarenza.entities.Book;
import giulio.chiarenza.entities.Magazine;
import giulio.chiarenza.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.List;

public class MagazineDAO {
    private final EntityManager em;
    public MagazineDAO(EntityManager em){this.em=em;}
    public void save(Magazine magazine){
        EntityTransaction transaction= em.getTransaction();
        transaction.begin();
        em.persist(magazine);
        transaction.commit();
        System.out.println("Magazine " + magazine.getTitle() + " salvato!");
    }
    public Magazine findByISBN(long codeISBN){
        Query query = em.createQuery("SELECT m FROM Magazine m WHERE m.codeISBN = :codeISBN");
        query.setParameter("codeISBN", codeISBN);
        List<Magazine> magazines = query.getResultList();
        if (magazines.isEmpty()) throw new NotFoundException(codeISBN);
        return magazines.get(0);
    }
    public void findByISBNAndDelete(long codeISBN){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Query deleteLoanQuery = em.createQuery("DELETE FROM Loan l WHERE l.loanedBook.codeISBN = :codeISBN OR l.loanedMagazine.codeISBN = :codeISBN");
        deleteLoanQuery.setParameter("codeISBN", codeISBN);
        int deletedLoanCount = deleteLoanQuery.executeUpdate();
        Query deleteMagazineQuery = em.createQuery("DELETE FROM Magazine m WHERE m.codeISBN = :codeISBN");
        deleteMagazineQuery.setParameter("codeISBN", codeISBN);
        int deletedMagazineCount = deleteMagazineQuery.executeUpdate();
        transaction.commit();
        if (deletedLoanCount > 0 || deletedMagazineCount > 0) {
            System.out.println("Magazine con codeISBN " + codeISBN + " eliminato insieme ai suoi prestiti");
        } else {
            throw new NotFoundException(codeISBN);
        }
    }
}
