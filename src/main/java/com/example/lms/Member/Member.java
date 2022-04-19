package com.example.lms.Member;

import com.example.lms.Book.Book;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table
public class Member {
    @Id
    @SequenceGenerator(name = "member_sequence",
            sequenceName = "member_sequence",
            allocationSize =1)

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "member_sequence"
    )
    private Integer memberId;

    @NotNull
    @Size(min=3, max=20)
    private String name;


    @JsonIgnore
    @ManyToMany(mappedBy = "membersWithCopy")
    private List<Book> booksBorrowed;

    private boolean hasOverDue;

    public Member() {
    }

    public Member(Integer id, String name) {
        this.memberId = id;
        this.name = name;
        this.booksBorrowed = new ArrayList<Book>();
        this.hasOverDue = false;

    }

    public Member(String name) {
        this.name = name;
        this.booksBorrowed = new ArrayList<Book>();
        this.hasOverDue = false;

    }

    public void setBooksBorrowed(Book booksBorrowedTitle) {
        this.booksBorrowed.add(booksBorrowedTitle);
    }



    @Override
    public String toString() {
        return "Member{" +
                "id=" + memberId +
                ", name='" + name + '\'' +
                ", booksBorrowedTitle=" + booksBorrowed +
                ", hasOverDue=" + hasOverDue +
                '}';
    }


}
