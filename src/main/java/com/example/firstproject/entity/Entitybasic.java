package com.example.firstproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@AllArgsConstructor
@Entity
@Getter

public class Entitybasic {


   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @Column
    private String title;
   @Column
    private String contents;


    public Entitybasic() {

    }

    public void patch(Entitybasic patch1) {
        if(patch1.title!=null){this.title=patch1.title;}
        if(patch1.contents!=null){this.contents=patch1.contents;}
    }
}
