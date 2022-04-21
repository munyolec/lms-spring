package com.example.lms.Librarian;


import com.example.lms.Book.Book;
import com.example.lms.Book.BookInfoDTO;
import com.example.lms.Member.Member;
import com.example.lms.Member.MemberBookInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/librarian/")
public class LibrarianController {

    private final LibrarianService librarianService;

    @Autowired
    public LibrarianController(LibrarianService librarianService) {
        this.librarianService = librarianService;
    }

    @GetMapping("/books")
    public List<BookInfoDTO> getBooks() {
        return librarianService.getBooks();
    }

    @PostMapping("/books")
    public void addNewBook(@Valid @RequestBody  Book book) {
        librarianService.addBook(book);
    }

    @DeleteMapping(path = "/books/{bookId}")
    public void deleteBook(@PathVariable("bookId") Integer bookId) {
        librarianService.deleteBook(bookId);
    }

    @GetMapping("/members")
    public List<MemberBookInfoDTO> getMembers() {
        return librarianService.getMembers();
    }

    @PostMapping("/members/add")
    public void addMember(@Valid @RequestBody Member member) {
        librarianService.addMember(member);
    }

    @GetMapping(path = "/member/{memberId}")
    public Optional<Member> getMember(@PathVariable("memberId") Integer memberId) {
        return librarianService.findMember(memberId);
    }

    @DeleteMapping(path = "/member/{memberId}")
    public void deleteMember(@PathVariable("memberId") Integer memberId) {
        librarianService.deleteMember(memberId);
    }

    @PutMapping(path = "/member/{memberId}/borrow/{bookId}")
    public void issueBook(
            @PathVariable("memberId") Integer member,
            @PathVariable("bookId") Integer book
          ){
        Member mem = new Member();
        mem.setMemberId(member);
        Book bk = new Book();
        bk.setBookId(book);
        librarianService.issueBook(mem,bk);
    }
    @GetMapping(path="/books/borrowed")
    public Collection<Book> getTotalBooksOut() {
        return librarianService.getTotalBooksOut();
    }

    @PutMapping(path="/edit/{bookId}")
    public void updateBookCount(
            @PathVariable("bookId") Integer bookId,
            @RequestParam(required = false) Integer quantity
    ){
        librarianService.updateBookCount(bookId, quantity);
    }


}
