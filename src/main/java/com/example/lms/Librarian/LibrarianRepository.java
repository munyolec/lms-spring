package com.example.lms.Librarian;

import com.example.lms.Book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibrarianRepository extends JpaRepository <Librarian, Integer> {
}
