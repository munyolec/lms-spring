package com.example.lms.Member;


import com.example.lms.Book.Book;
import com.example.lms.Book.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MemberConfig {

    @Bean
    CommandLineRunner commandLineRunnerMember(
            MemberRepository repository
    ){
        return args -> {
            Member one = new Member(
                    "Member One"
            );

            Member two = new Member(

                    "Member Two"
            );
            repository.saveAll(List.of(one, two));
        };
    }
}
