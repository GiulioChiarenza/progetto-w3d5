package giulio.chiarenza.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book extends Publications {
    private String author;
    private String type;

    public Book() {}

    public Book( String title, int publicationYear, int pageNumber, String author, String type) {
        super(title, publicationYear, pageNumber);
        this.author = author;
        this.type = type;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Book{" +
                "codeISBN=" + getCodeISBN() +
                ", title='" + getTitle() + '\'' +
                ", publicationYear=" + getPublicationYear() +
                ", pageNumber=" + getPageNumber() +
                ", author='" + author + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}