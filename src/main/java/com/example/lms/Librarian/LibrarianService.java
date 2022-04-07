package com.example.lms.Librarian;


import com.example.lms.Book.Book;
import com.example.lms.Book.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibrarianService {

    private final LibrarianRepository librarianRepository;
    private final BookRepository bookRepository;

    public LibrarianService(LibrarianRepository librarianRepository, BookRepository bookRepository) {
        this.librarianRepository = librarianRepository;
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }
}
