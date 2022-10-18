package com.example.firstproject.entity;

import com.example.firstproject.dto.commentbasicdto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter

public class Commentbasic {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "main_article")
    private Entitybasic main_article;

    @Column
    private String nickname;

    @Column
    private String body;


    public void patch(commentbasicdto dto) {
        if(dto.getId()!=id){throw new IllegalArgumentException("댓글의 아이디가 다릅니다.");}
        if(dto.getNickname()!=null)
        this.nickname = dto.getNickname();

        if(dto.getBody()!=null)
        this.body = dto.getBody();
    }
}
