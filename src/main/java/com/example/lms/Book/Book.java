package com.example.lms.Book;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import javax.validation.Valid;
import java.time.LocalDate;

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
    private int id;
    private String title;
    private boolean borrowedStatus;
    private String borrowerName;
    private LocalDate borrowedDate;
    private LocalDate returnDate;
    private Boolean isOverDue;

    public Book(){

    }

    public Book(int id, String title) {
        this.id = id;
        this.title = title;
        this.borrowedStatus = false;
        this.borrowerName = null;
        this.borrowedDate = null;
        this.returnDate = null;
        this.isOverDue = false;
    }

    public Book(String title) {
        this.title = title;
        this.borrowedStatus = false;
        this.borrowerName = null;
        this.borrowedDate = null;
        this.returnDate = null;
        this.isOverDue = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isBorrowedStatus() {
        return borrowedStatus;
    }

    public void setBorrowedStatus(boolean borrowedStatus) {
        this.borrowedStatus = borrowedStatus;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public LocalDate getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(LocalDate borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Boolean getOverDue() {
        return isOverDue;
    }

    public void setOverDue(Boolean overDue) {
        isOverDue = overDue;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", borrowedStatus=" + borrowedStatus +
                ", borrowerName='" + borrowerName + '\'' +
                ", borrowedDate=" + borrowedDate +
                ", returnDate=" + returnDate +
                ", isOverDue=" + isOverDue +
                '}';
    }
}
