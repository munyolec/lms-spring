package com.example.lms.Librarian;

import com.example.lms.Book.Book;
import com.example.lms.Member.Member;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table
public class Librarian {

    @Id
    @SequenceGenerator(name = "librarian_sequence",
            sequenceName = "librarin_sequence",
            allocationSize =1)

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "librarian_sequence"
    )
    private int id;
    private String libName;

    @OneToMany(targetEntity = Member.class)
    private static List<Member> members;

    @OneToMany(targetEntity = Book.class)
    private static List<Book> books;

    public Librarian(){

    }

    public Librarian(int id, String libName) {
        this.id = id;
        this.libName = libName;
        this.members = new ArrayList<Member>();
        this.books = new ArrayList<Book>();
    }

    public Librarian(String libName) {
        this.libName = libName;
        this.members = new ArrayList<Member>();
        this.books = new ArrayList<Book>();
    }



    @Override
    public String toString() {
        return "Librarian{" +
                "id=" + id +
                ", libName='" + libName + '\'' +
                '}';
    }

}
