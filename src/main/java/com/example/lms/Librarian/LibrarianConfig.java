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
            LibrarianRepository librarianRepository

    ){
        return args -> {
            Librarian one = new Librarian(
                    "Librarian"
            );

            librarianRepository.saveAll(List.of(one));
        };
    }
}
