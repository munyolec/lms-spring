package com.example.lms.Librarian;


import com.example.lms.Book.Book;
import com.example.lms.Member.Member;
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
    public List<Book> getBooks() {
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
    public List<Member> getMembers() {
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
        mem.setId(member);
        Book bk = new Book();
        bk.setId(book);
        librarianService.issueBook(mem,bk);
    }

    @GetMapping(path="/books/borrowed")
    public Collection<Book> getTotalBooksOut() {
        return librarianService.getTotalBooksOut();
    }


}
