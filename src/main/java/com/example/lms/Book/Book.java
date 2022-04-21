package com.example.lms.Book;

import com.example.lms.Member.Member;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    public Integer bookId;

    @NotNull
    @Size(min=3)
    private String title;

    private Integer quantity;
    private boolean borrowedStatus;
    @ManyToMany
    @JoinTable(
            name="Member_Book_Info",
            joinColumns = @JoinColumn(name="bookId"),
            inverseJoinColumns = @JoinColumn(name="member_id")
    )
    @JsonIgnore
    private List<Member> membersWithCopy;
    private LocalDate borrowedDate;
    private LocalDate returnDate;
    private Boolean isOverDue;

    public Book(){
    }

    public Book(String title) {
        this.title = title;
        this.quantity = 5;
        this.borrowedStatus = borrowedStatus;
        this.membersWithCopy = new ArrayList<Member>();
        this.borrowedDate = borrowedDate;
        this.returnDate = returnDate;
        this.isOverDue = isOverDue;
    }

    public boolean isBorrowedStatus() {
        return borrowedStatus;
    }

    public void setBorrowedStatus() {
        if(getQuantity() > 0){
            this.borrowedStatus = false;
        }
        else if (getQuantity() ==0){
            this.borrowedStatus = true;
        }
        else {
            this.borrowedStatus = true;
        }
    }

    public void setMembersWithCopy(Member member) {
        this.membersWithCopy.add(member);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + bookId +
                ", title='" + title + '\'' +
                ", quantity=" + quantity +
                ", borrowedStatus=" + borrowedStatus +
                ", borrowedDate=" + borrowedDate +
                ", returnDate=" + returnDate +
                ", isOverDue=" + isOverDue +
                '}';
    }
}
