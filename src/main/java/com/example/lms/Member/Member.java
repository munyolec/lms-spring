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
    private int id;
    private String name;

    @OneToMany(targetEntity = Book.class)
    private List<String> booksBorrowedTitle;

    @OneToMany(targetEntity = Book.class)
    private List<Book> booksBorrowed;

    private boolean hasOverDue;

    public Member() {
    }

    public Member(int id, String name) {
        this.id = id;
        this.name = name;
        this.booksBorrowedTitle = new ArrayList<String>();
        this.booksBorrowed = new ArrayList<Book>();
        this.hasOverDue = false;

    }

    public Member(String name) {
        this.name = name;
        this.booksBorrowedTitle = new ArrayList<String>();
        this.booksBorrowed = new ArrayList<Book>();
        this.hasOverDue = false;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getBooksBorrowedTitle() {
        return booksBorrowedTitle;
    }

    public void setBooksBorrowedTitle(List<String> booksBorrowedTitle) {
        this.booksBorrowedTitle = booksBorrowedTitle;
    }

    public List<Book> getBooksBorrowed() {
        return booksBorrowed;
    }

    public void setBooksBorrowed(List<Book> booksBorrowed) {
        this.booksBorrowed = booksBorrowed;
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
                ", booksBorrowedTitle=" + booksBorrowedTitle +
                ", booksBorrowed=" + booksBorrowed +
                ", hasOverDue=" + hasOverDue +
                '}';
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Member)) return false;
//        Member member = (Member) o;
//        return getId() == member.getId();
//    }

}
