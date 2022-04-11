package com.example.lms.Member;
import com.example.lms.Book.Book;
import com.example.lms.Book.BookRepository;

import com.example.lms.Librarian.LibrarianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Objects;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final BookRepository bookRepository;
    private final LibrarianRepository librarianRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository, BookRepository bookRepository,
                         LibrarianRepository librarianRepository) {
        this.memberRepository = memberRepository;
        this.bookRepository = bookRepository;
        this.librarianRepository = librarianRepository;
    }

    public void updateMember(Integer memberId, String name) {
        Member member = memberRepository.findById(memberId).
                orElseThrow(() -> new IllegalStateException(
                        "member with id " + memberId + " does not exist"
                ));
        if (name != null && name.length() > 0
                && !Objects.equals(member.getName(), name)) {
            member.setName(name);
        }
    }
}

