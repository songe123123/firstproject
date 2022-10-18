package com.example.firstproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor//디폴드 생성자 빈깡통생성자 추가!
@AllArgsConstructor
@ToString
@Getter // public Long getId() {return id;}


@Entity //해줘야 db가 해당 객체를 인식가능하게함!
public class Article {


    @Id // 엔티티에는 대표값을 하나 넣어줘야함(주민등록번호)
    @GeneratedValue(strategy = GenerationType.IDENTITY)//1,2,3...자동 생성 어노테이션
    private Long id;


    @Column //db에서 관리하는 테이블이라는 단위에 연결되게함
    private String title;
    @Column
    private String content;


    public void patch(Article article) {
        if(article.title!=null){this.title=article.title;}
        if(article.content!=null){this.content=article.content;}

    }
}


