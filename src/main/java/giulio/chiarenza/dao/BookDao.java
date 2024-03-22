package giulio.chiarenza.dao;

import giulio.chiarenza.entities.Book;
import giulio.chiarenza.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class BookDao {
    private final EntityManager em;
    public BookDao(EntityManager em){this.em=em;}

    public void save(Book book){
        EntityTransaction transaction= em.getTransaction();
        transaction.begin();
        em.persist(book);
        transaction.commit();
        System.out.println("libro " + book.getTitle() + " salvato!");
    }
    public Book findByISBN(long codeISBN){
        Query query = em.createQuery("SELECT b FROM Book b WHERE b.codeISBN = :codeISBN");
        query.setParameter("codeISBN", codeISBN);
        List<Book> books = query.getResultList();
        if (books.isEmpty()) {
            throw new NotFoundException(codeISBN);
        } else {
            System.out.println("Libro con codeISBN " + codeISBN + ":");
            for (Book book : books) {
                System.out.println(" - " + book.getTitle());
            }
        }
        return books.get(0);
    }
    public void findByISBNAndDelete(long codeISBN) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Query deleteLoanQuery = em.createQuery("DELETE FROM Loan l WHERE l.loanedItem.codeISBN = :codeISBN");
        deleteLoanQuery.setParameter("codeISBN", codeISBN);
        deleteLoanQuery.executeUpdate();
        Query deleteMagazineQuery = em.createQuery("DELETE FROM BOOK b WHERE b.codeISBN = :codeISBN");
        deleteMagazineQuery.setParameter("codeISBN", codeISBN);
        deleteMagazineQuery.executeUpdate();
        transaction.commit();
        System.out.println("Book con codeISBN " + codeISBN + " eliminato insieme ai suoi prestiti");
    }
    public Book findByYear(int publicationYear) {
        Query query = em.createQuery("SELECT b FROM Book b WHERE b.publicationYear = :publicationYear");
        query.setParameter("publicationYear", publicationYear);
        List<Book> books = query.getResultList();
        if (books.isEmpty()) {
            throw new NotFoundException(publicationYear);
        } else {
            System.out.println("Libri pubblicati nell'anno " + publicationYear + ":");
            for (Book book : books) {
                System.out.println(" - " + book.getTitle());
            }
        }
        return books.get(0);
        }
        public Book findByAuthor(String author) {
            Query query = em.createQuery("SELECT b FROM Book b WHERE b.author = :author");
            query.setParameter("author", author);
            List<Book> books = query.getResultList();
            if (books.isEmpty()) {
                System.out.println("Nessun libro trovato per l'autore: " + author);
            } else {
                System.out.println("Libri dell' autore " + author + ":");
                for (Book book : books) {
                    System.out.println(" - " + book.getTitle());
                }
            }
            return books.get(0);
        }
            public List<Book> findByTitleOrPart(String partialTitle){
                TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b WHERE LOWER(b.title) LIKE LOWER(:partialTitle)", Book.class);
                query.setParameter("partialTitle","%" + partialTitle + "%");
                List<Book> books = query.getResultList();
                if (books.isEmpty()) {
                    System.out.println("Nessun libro trovato con il titolo contenente: " + partialTitle);
                } else {
                    System.out.println("Libri con titolo contenente " + partialTitle + ":");
                    for (Book book : books) {
                        System.out.println(" - " + book.getTitle());
                    }
                }
                return books;
            }
    }

