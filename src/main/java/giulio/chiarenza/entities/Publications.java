package giulio.chiarenza.entities;

import jakarta.persistence.*;
@Entity
@Table(name = "publications")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Publications {
    @Id
    @GeneratedValue
    private long codeISBN;
    private String title;
    private int publicationYear;
    private int pageNumber;

    protected Publications() {}

    public Publications( String title, int publicationYear, int pageNumber) {

        this.title = title;
        this.publicationYear = publicationYear;
        this.pageNumber = pageNumber;
    }

    public long getCodeISBN() {
        return codeISBN;
    }

    public void setCodeISBN(long codeISBN) {
        this.codeISBN = codeISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    @Override
    public String toString() {
        return "Publications{" +
                "codeISBN=" + codeISBN +
                ", title='" + title + '\'' +
                ", publicationYear=" + publicationYear +
                ", pageNumber=" + pageNumber +
                '}';
    }
}