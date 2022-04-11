//package com.example.lms.Member;
//
//import com.example.lms.Book.Book;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping(path="/api/")
//public class MemberController {
//
//    private final MemberService memberService;
//
//    @Autowired
//    public MemberController(MemberService memberService) {
//        this.memberService = memberService;
//    }
//
//    @PutMapping(path = "/member<borrow>/{memberId}/{bookId}")
//    public void borrowBook(
//            @PathVariable("memberId") Member member,
//            @PathVariable("bookId") Book book
//    ){
//        memberService.borrowBook(member, book);
//    }
//
//
//}
