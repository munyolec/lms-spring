package com.example.lms.Librarian;


import com.example.lms.Book.Book;
import com.example.lms.Book.BookRepository;
import com.example.lms.Member.Member;
import com.example.lms.Member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class LibrarianService {
    private final LibrarianRepository librarianRepository;
    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;

    @Autowired
    public LibrarianService(LibrarianRepository librarianRepository,
                            BookRepository bookRepository , MemberRepository memberRepository) {
        this.librarianRepository = librarianRepository;
        this.bookRepository = bookRepository;
        this.memberRepository = memberRepository;
    }

    /**
     * Book Logic
     */
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteBook(Integer bookId) {
       boolean exists = bookRepository.existsById(bookId);
       if(!exists) {
           throw new IllegalStateException("book with id " +
                   bookId + " does not exist");
       }
       bookRepository.deleteById(bookId);
    }


    /**
     * Member Logic

     */
    public List<Member> getMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findMember(Integer memberId) {
       return memberRepository.findMemberById(memberId);
    }

    public void addMember(Member member) {

        memberRepository.save(member);
    }

    public void deleteMember(Integer memberId) {
        boolean exists = memberRepository.existsById(memberId);
        if(!exists) {
            throw new IllegalStateException("member with id " +
                    memberId + " does not exist");
        }
        memberRepository.deleteById(memberId);
    }

    @Transactional
    public void issueBook(Member member, Book book) {
    Optional<Book> bookOptional =
            bookRepository.findBookById(book.getId());
    Optional<Member> memberOptional =
            memberRepository.findById(member.getId());

    if(member.isHasOverDue() == false){
        if(bookOptional.isPresent() && memberOptional.isPresent()) {
            if(book.isBorrowedStatus() == false){
                book = bookOptional.get();
                member= memberOptional.get();
                book.setBorrowedStatus(true);
                book.setMemberBorrower(member);
                book.setBorrowedDate(LocalDate.now());
                book.setReturnDate((LocalDate.now().plusWeeks(1)));
                member.setBooksBorrowed(book);

            }
            else{
                throw new IllegalStateException("book already borrowed");
            }
        }else
        {
            throw new IllegalStateException();
        }
    } else{
        throw new IllegalStateException("You have a book that is overdue");
    }

    bookRepository.save(book);
    memberRepository.save(member);
}
    public Collection<Book> getTotalBooksOut(){
        return bookRepository.findBorrowedBook();
    }
}
