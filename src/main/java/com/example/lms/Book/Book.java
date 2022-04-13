package com.example.lms.Book;

import com.example.lms.Member.Member;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Entity
@Table
public class Book {
    @Id
    @SequenceGenerator(name = "book_sequence",
                        sequenceName = "book_sequence",
                        allocationSize =1)

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )
    public Integer id;

    @NotNull
    @Size(min=3)
    private String title;
    
    private boolean borrowedStatus;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "borrower_id", referencedColumnName = "id")
    private Member memberBorrower;
    private LocalDate borrowedDate;
    private LocalDate returnDate;
    private Boolean isOverDue;

    public Book(){

    }

    public Book(Integer id, String title) {
        this.id = id;
        this.title = title;
        this.borrowedStatus = false;
//        this.borrowerName = null;
        this.memberBorrower = null;
        this.borrowedDate = null;
        this.returnDate = null;
        this.isOverDue = false;
    }

    public Book(String title) {
        this.title = title;
        this.borrowedStatus = false;
//        this.borrowerName = null;
        this.borrowedDate = null;
        this.returnDate = null;
        this.isOverDue = false;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", borrowedStatus=" + borrowedStatus +
                ", borrowedDate=" + borrowedDate +
                ", returnDate=" + returnDate +
                ", isOverDue=" + isOverDue +
                '}';
    }
}
