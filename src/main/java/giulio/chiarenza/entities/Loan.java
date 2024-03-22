package giulio.chiarenza.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "loans")
public class Loan {
    @Id
    @GeneratedValue
    private long loans_id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Book loanedBook;
    @ManyToOne
    private Magazine loanedMagazine;
    private String loanStartDate;
    private String expectedReturnDate;
    private String effectiveReturnDate;
    public Loan(){}

    public Loan(User user, Book loanedBook,Magazine loanedMagazine, String loanStartDate, String expectedReturnDate, String effectiveReturnDate) {
        this.user = user;
        this.loanedBook= loanedBook;
        this.loanedMagazine= loanedMagazine;
        this.loanStartDate = loanStartDate;
        this.expectedReturnDate = expectedReturnDate;
        this.effectiveReturnDate = effectiveReturnDate;
    }

    public long getLoans_id() {
        return loans_id;
    }

    public void setLoans_id(long loans_id) {
        this.loans_id = loans_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getLoanedBook() {
        return loanedBook;
    }

    public void setLoanedBook(Book loanedBook) {
        this.loanedBook = loanedBook;
    }

    public Magazine getLoanedMagazine() {
        return loanedMagazine;
    }

    public void setLoanedMagazine(Magazine loanedMagazine) {
        this.loanedMagazine = loanedMagazine;
    }

    public String getLoanStartDate() {
        return loanStartDate;
    }

    public void setLoanStartDate(String loanStartDate) {
        this.loanStartDate = loanStartDate;
    }

    public String getExpectedReturnDate() {
        return expectedReturnDate;
    }

    public void setExpectedReturnDate(String expectedReturnDate) {
        this.expectedReturnDate = expectedReturnDate;
    }

    public String getEffectiveReturnDate() {
        return effectiveReturnDate;
    }

    public void setEffectiveReturnDate(String effectiveReturnDate) {
        this.effectiveReturnDate = effectiveReturnDate;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "loans_id=" + loans_id +
                ", user=" + user +
                ", loanedBook=" + loanedBook +
                ", loanedMagazine=" + loanedMagazine +
                ", loanStartDate='" + loanStartDate + '\'' +
                ", expectedReturnDate='" + expectedReturnDate + '\'' +
                ", effectiveReturnDate='" + effectiveReturnDate + '\'' +
                '}';
    }
}
