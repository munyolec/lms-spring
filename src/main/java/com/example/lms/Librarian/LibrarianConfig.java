package com.example.lms.Librarian;


import com.example.lms.Book.Book;
import com.example.lms.Book.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class LibrarianConfig {
    @Bean
    CommandLineRunner commandLineRunnerLibrarian(
            LibrarianRepository librarianRepository,
            BookRepository repository
    ){
        return args -> {
            Book one = new Book(
                    "Book One"
            );

            Book two = new Book(
                    "Book Two"
            );

            repository.saveAll(List.of(one, two));
        };
    }
}
