//package com.example.lms.Book;
//
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.List;
//
//@Configuration
//public class BookConfig {
//
//    @Bean
//    CommandLineRunner commandLineRunnerBook(
//            BookRepository repository
//    ){
//        return args -> {
//                   Book one = new Book(
//                            "Book One"
//                    );
//
//                    Book two = new Book(
//                            "Book Two"
//                    );
//
//                    repository.saveAll(List.of(one, two));
//        };
//    }
//}
