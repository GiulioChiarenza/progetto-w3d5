package giulio.chiarenza;

import giulio.chiarenza.dao.BookDao;
import giulio.chiarenza.dao.LoanDao;
import giulio.chiarenza.dao.MagazineDAO;
import giulio.chiarenza.dao.UserDAO;
import giulio.chiarenza.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("catalogobibliografico");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        BookDao bk = new BookDao(em);
        MagazineDAO mg = new MagazineDAO(em);
        LoanDao lo = new LoanDao(em);
        UserDAO us = new UserDAO(em);
        System.out.println("Hello World!");

        Book book1= new Book("One Piece Vol.1044", 1997, 17,"Eiichiro Oda","adventure, fantasy, comedy, action");
        //bk.save(book1);
        Book book2= new Book("Lo Hobbit", 1937, 330, "J.R.R Tolkien", "novel, epic, fantasy, adventure");
        //bk.save(book2);
        Magazine magazine1= new Magazine("Shonen Jump", 1959, 19, Periodicity.WEEKLY);
        //mg.save(magazine1);
        Magazine magazine2= new Magazine("Time", 1923, 32, Periodicity.WEEKLY);
        //mg.save(magazine2);
        User user1= new User("Giulio", "Chiarenza","14-11-1997");
        //us.save(user1);
        User user2= new User("Gesù", "Di Nazaret","25-12-0000");
        //us.save(user2);
        Loan loan1= new Loan(user1, book1, magazine1,"10-02","10-03","3-05");
        //lo.save(loan1);
        Loan loan2= new Loan(user2, book2, magazine2, "13-11", "13-12","10-12");
        //lo.save(loan2);


        System.out.println("Rimozione di un elemento tramite ISBN");
        //mg.findByISBNAndDelete(4);
        System.out.println("Ricerca di un elemento tramite ISBN");
        bk.findByISBN(1);
        System.out.println("Ricerca per anno di pubblicazione");
        bk.findByYear(1997);
        System.out.println("Ricerca per autore");
        bk.findByAuthor("J.R.R Tolkien");
        System.out.println("Ricerca per titolo o parte di essa");
        System.out.println("Ricerca degli elementi attualmente in prestito dato un numero di tessera utente");
        System.out.println("Ricerca di tutti i prestiti scaduti e non ancora restituiti");














    }
}
