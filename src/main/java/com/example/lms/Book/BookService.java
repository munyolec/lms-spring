//package com.example.lms.Book;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//import java.util.List;
//import java.util.Objects;
//import java.util.Optional;
//
//@Service
//public class BookService {
//
//    private final BookRepository bookRepository;
//
//    @Autowired //inject repository into service
//    public BookService(BookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    }
//
////    public List<Book> getBooks() {
////       return bookRepository.findAll();
////    }
//
//
//    public void addNewBook(Book book) {
//        Optional<Book> bookOptional =
//                bookRepository.findBookById(book.getId());
//        if(bookOptional.isPresent()) {
//            throw new IllegalStateException("id taken");
//        }
//
//        bookRepository.save(book);
//
//    }
//
//    public void deleteBook(Integer bookId) {
//       boolean exists = bookRepository.existsById(bookId);
//       if(!exists) {
//           throw new IllegalStateException("book with id " +
//                   bookId + " does not exist");
//       }
//       bookRepository.deleteById(bookId);
//    }
//
//    @Transactional //not using any queries, goes into a manage stage
//    public void updateBook(Integer bookId, String title) {
//      Book book = bookRepository.findById(bookId).
//                orElseThrow(() -> new IllegalStateException(
//                        "book with id " + bookId + " does not exist"
//                ));
//      if(title != null && title.length() > 0
//            && !Objects.equals(book.getTitle(), title)) {
//          book.setTitle(title);
//      }
//
//    }
//}