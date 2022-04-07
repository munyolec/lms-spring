package com.example.lms.Member;

import com.example.lms.Book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> getMembers() {
        return memberRepository.findAll();

    }

    public void addMember(Member member) {
        Optional<Member> memberOptional =
                memberRepository.findMemberById(member.getId());
        if(memberOptional.isPresent()) {
            throw new IllegalStateException("id taken");
        }
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

    public void updateMember(Integer memberId, String name) {
        Member member = memberRepository.findById(memberId).
                orElseThrow(() -> new IllegalStateException(
                        "member with id " + memberId + " does not exist"
                ));
        if(name != null && name.length() > 0
                && !Objects.equals(member.getName(), name)) {
            member.setName(name);
        }
    }
}
