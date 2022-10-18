package com.example.firstproject.repository;

import com.example.firstproject.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    //특정 게시글의 모든 댓글 조회
    @Query(value =
            "SELECT * " + "FROM Comment" + " WHERE article_id = :articleId",nativeQuery = true)
    List<Comment> findByArticleId(Long articleId);


    //특정 닉네임의 모든 댓글 조회
    List<Comment> findByNickname(String nickname);

    //i가 들어간 닉네임의 모든 댓글 조회
    @Query(value=
    "SELECT * FROM Comment WHERE nickname LIKE '%I%' =: nickname_id_i",nativeQuery = true)
    List<Comment> IinNickname (





            
    );
}
