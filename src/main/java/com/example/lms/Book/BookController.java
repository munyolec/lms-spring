//package com.example.lms.Book;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.validation.Valid;
//import java.util.List;
//
//
//@RestController
//@RequestMapping(path = "api/library/books")
//public class BookController {
//
//    private final BookService bookService;
//
//    @Autowired //inject service into controller
//    public BookController(BookService bookService) {
//        this.bookService = bookService;
//    }
//
////    @GetMapping
////    public List<Book> getBooks() {
////        return bookService.getBooks();
////    }
//
//    @PostMapping
//    public void addNewBook(@RequestBody  Book book) {
//        bookService.addNewBook(book);
//    }
//
//    @DeleteMapping(path = "{bookId}")
//    public void deleteBook(@PathVariable("bookId") Integer bookId) {
//        bookService.deleteBook(bookId);
//    }
//
//    @PutMapping(path = "{bookId}")
//    public void updateBook(
//            @PathVariable("bookId") Integer bookId,
//            @RequestParam(required = false) String title){
//        bookService.updateBook(bookId, title);
//    }
//
//
//}
