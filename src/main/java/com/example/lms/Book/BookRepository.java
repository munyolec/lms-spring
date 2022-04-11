package com.example.lms.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;


@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query("SELECT b FROM Book b WHERE b.id = ?1")
    Optional<Book> findBookById(Integer id);

    @Query("SELECT b FROM Book b WHERE b.borrowedStatus = true")
    Collection<Book> findBorrowedBook();


}
