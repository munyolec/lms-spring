package com.example.lms.Member;

import com.example.lms.Book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/library/members")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public List<Member> getMembers() {
        return memberService.getMembers();
    }

    @PostMapping
    public void addNewMember(@RequestBody Member member) {
        memberService.addMember(member);
    }

    @DeleteMapping(path = "{memberId}")
    public void deleteMember(@PathVariable("memberId") Integer memberId) {
        memberService.deleteMember(memberId);
    }

    @PutMapping(path = "{memberId}")
    public void updateMember(
            @PathVariable("memberId") Integer memberId,
            @RequestParam(required = false) String name){
        memberService.updateMember(memberId, name);
    }


}
