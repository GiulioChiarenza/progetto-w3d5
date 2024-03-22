package giulio.chiarenza.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "magazines")
public class Magazine extends Publications {

    @Enumerated(EnumType.STRING)
    private Periodicity periodicity;

    public Magazine() {}

    public Magazine( String title, int publicationYear, int pageNumber, Periodicity periodicity) {
        super(title, publicationYear, pageNumber);
        this.periodicity = periodicity;
    }

    public Periodicity getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(Periodicity periodicity) {
        this.periodicity = periodicity;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "codeISBN=" + getCodeISBN() +
                ", title='" + getTitle() + '\'' +
                ", publicationYear=" + getPublicationYear() +
                ", pageNumber=" + getPageNumber() +
                ", periodicity=" + periodicity +
                '}';
    }
}