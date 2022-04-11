package com.example.lms.Member;

import com.example.lms.Book.Book;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    private Integer id;
    private String name;

    @OneToMany(targetEntity = Book.class)
    private List<Book> booksBorrowed;


    private boolean hasOverDue;

    public Member() {
    }

    public Member(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.booksBorrowed = new ArrayList<Book>();
        this.hasOverDue = false;

    }

    public Member(String name) {
        this.name = name;
        this.booksBorrowed = new ArrayList<Book>();
        this.hasOverDue = false;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooksBorrowedTitle() {
        return booksBorrowed;
    }

    public void setBooksBorrowedTitle(Book booksBorrowedTitle) {
        this.booksBorrowed.add(booksBorrowedTitle);
    }

    public boolean isHasOverDue() {
        return hasOverDue;
    }

    public void setHasOverDue(boolean hasOverDue) {
        this.hasOverDue = hasOverDue;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", booksBorrowedTitle=" + booksBorrowed +
                ", hasOverDue=" + hasOverDue +
                '}';
    }


}
