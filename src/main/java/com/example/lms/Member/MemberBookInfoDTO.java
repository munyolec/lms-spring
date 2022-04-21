package com.example.lms.Member;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MemberBookInfoDTO {

    private Integer memberId;
    private String name;
    private List<String> borrowedBooks;

    public MemberBookInfoDTO() {
        this.borrowedBooks = new ArrayList<>();
    }
    public void setBookName(String title) {
        this.borrowedBooks.add(title);
    }
}