package com.example.lms.Librarian;


import com.example.lms.Book.Book;
import com.example.lms.Book.BookInfoDTO;
import com.example.lms.Book.BookRepository;
import com.example.lms.Member.Member;
import com.example.lms.Member.MemberBookInfoDTO;
import com.example.lms.Member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

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
    public List<BookInfoDTO> getBooks() {
        return bookRepository.findAll()
                .stream()
                .map(this::convertBookEntityToDto)
                .collect(Collectors.toList());
    }


    private BookInfoDTO convertBookEntityToDto(Book book){
        BookInfoDTO bookInfoDto = new BookInfoDTO();
        bookInfoDto.setBookId(book.getBookId());
        bookInfoDto.setBookName(book.getTitle());
        bookInfoDto.setQuantity(book.getQuantity());
        return bookInfoDto;
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
    public List<MemberBookInfoDTO> getMembers() {
        return memberRepository.findAll()
                .stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    private MemberBookInfoDTO convertEntityToDTO(Member member) {
        MemberBookInfoDTO memberBookInfoDTO = new MemberBookInfoDTO();
        memberBookInfoDTO.setMemberId(member.getMemberId());
        memberBookInfoDTO.setName(member.getName());
        memberBookInfoDTO.setBookName(String.valueOf(member.getTitles()));
        return memberBookInfoDTO;

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
            bookRepository.findBookById(book.getBookId());
    Optional<Member> memberOptional =
            memberRepository.findById(member.getMemberId());

    if(member.isHasOverDue() == false){
        if(bookOptional.isPresent() && bookOptional.get().getQuantity() > 0 && memberOptional.isPresent()) {
            if(book.isBorrowedStatus() == false){
                book = bookOptional.get();
                member= memberOptional.get();
                book.setBorrowedStatus(true);
                book.setMembersWithCopy(member);
                book.setBorrowedDate(LocalDate.now());
                book.setQuantity( book.getQuantity()-1 );
                book.setReturnDate((LocalDate.now().plusWeeks(1)));
                member.setBooksBorrowed(book);

            }
            else{
                throw new IllegalStateException("book already borrowed");
            }
        }else
        {
            throw new IllegalStateException("Book or Member not available");
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

    @Transactional
    public void updateBookCount(Integer bookId, Integer quantity) {
       Book book = bookRepository.findById(bookId).orElseThrow(
               ()->new IllegalStateException("book with id" +bookId + "does not exist")
       );

       if(quantity !=null && !Objects.equals(book.getQuantity(), quantity)){
           book.setQuantity(quantity);
       }

    }
}
