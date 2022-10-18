package com.example.firstproject.repository;

import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Comment;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest // JAP와 연동한 테스트!

    @Slf4j

class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Test
    @DisplayName("특정 게시글의 모든 댓글 조회")
    void findByArticleId() {



            /* Case 1: 4번 게시글의 모든 댓글 조회*/
            {
                //입력 데이터 준비
                Long articleId = 4L;

                //예상하기
                Article article = new Article(4L, "your favorite MOVIE?", "comment plz111");
                Comment a = new Comment(1L, article, "Park", "GOOD WILL HUNTING");
                Comment b = new Comment(2L, article, "Kim", "Iam SAM");
                Comment c = new Comment(3L, article, "Choi", "ShowsankESCAPE");

                List<Comment> expected = Arrays.asList(a, b, c);

                //실제 수행 과정
                List<Comment> comments = commentRepository.findByArticleId(articleId);

                //검증
                assertEquals(expected.toString(), comments.toString(), "4번 글의 모든 댓글을 출력!");
            }
        }

        /* Case 2: 1번 게시글의 모든 댓글 조회*/
        @Test
        void findByArticleId_1번() {

            {
                //입력 데이터 준비
                Long articleId = 1L;

                //예상하기
                Article article = new Article(1L, "1111", "AAAA");

                List<Comment> expected = Arrays.asList();

                //실제 수행 과정
                List<Comment> comments = commentRepository.findByArticleId(articleId);

                //검증
                assertEquals(expected, comments, "1번 글은 댓글이 없음!");
            }
        }

        /* Case 3: 9번 게시글의 모든 댓글 조회*/
        @Test
        void findByArticleId_9번() {

            {
                //입력 데이터 준비
                Long articleId = 9L;

                //예상하기
                Article article = new Article(9L, null, null);

                List<Comment> expected = Arrays.asList();

                //실제 수행 과정
                List<Comment> comments = commentRepository.findByArticleId(articleId);

                //검증
                assertEquals(expected, comments, "1번 글은 댓글이 없음!");
            }
        }



        /* Case 4: 9999번 게시글의 모든 댓글 조회*/
        @Test
        void findByArticleId_9999번() {

            {
                //입력 데이터 준비
                Long articleId = 9999L;

                //예상하기
                Article article = new Article(9999L, null, null);

                List<Comment> expected = Arrays.asList();

                //실제 수행 과정
                List<Comment> comments = commentRepository.findByArticleId(articleId);

                //검증
                assertEquals(expected, comments, "9999번 글은 댓글이 없음!");
            }
        }



        /* Case 4: -1번 게시글의 모든 댓글 조회*/
        @Test
        void findByArticleId_마이너스1번() {

            {
                //입력 데이터 준비
                Long articleId = -1L;

                //예상하기
                Article article = new Article(-1L, null, null);

                List<Comment> expected = Arrays.asList();

                //실제 수행 과정
                List<Comment> comments = commentRepository.findByArticleId(articleId);

                //검증
                assertEquals(expected, comments, "-1번 글은 댓글이 없음!");
            }
        }
    @Test
    @DisplayName("특정 닉네임의 모든 댓글 조회")

    void findByNickname() {
        /* Case 1: "Park"의 모든 댓글 조회*/
        {
            //예상
            String nickname = "Park";

            Comment a = new Comment(1L, new Article(4L, "your favorite MOVIE?", "comment plz111"), nickname, "GOOD WILL HUNTING");
            Comment b = new Comment(4L, new Article(5L, "your SOUL FOOD?", "comment plz2222"), nickname, "chicken");
            Comment c = new Comment(7L, new Article(6L, "your HOBBY?", "comment plz333333"), nickname, "Jogginh");


            List<Comment> expected = Arrays.asList(a, b, c);

            //실제
            List<Comment> d = commentRepository.findByNickname(nickname);

            //비교
            assertEquals(expected.toString(), d.toString());


        }
    }
        /* Case 2: "Kim"의 모든 댓글 조회*/
        @Test
        @DisplayName("특정 닉네임의 모든 댓글 조회")

        void findByNickname_1() {
            {
                //예상
                String nickname = "Kim";

                Comment a = new Comment(2L, new Article(4L, "your favorite MOVIE?", "comment plz111"), nickname, "Iam SAM");
                Comment b = new Comment(5L, new Article(5L, "your SOUL FOOD?", "comment plz2222"), nickname, "shabu-shabu");
                Comment c = new Comment(8L, new Article(6L, "your HOBBY?", "comment plz333333"), nickname, "Youtube");


                List<Comment> expected = Arrays.asList(a, b, c);

                //실제
                List<Comment> comments = commentRepository.findByNickname(nickname);

                //비교
                assertEquals(expected.toString(), comments.toString());


            }
        }
        /* Case 3: null 의 모든 댓글 조회*/
        @Test
        @DisplayName("특정 닉네임의 모든 댓글 조회")

        void findByNickname_2() {
            {
                //예상
                String nickname = null;
                List<Comment> expected = Arrays.asList();

                //실제
                List<Comment> comments = commentRepository.findByNickname(nickname);

                //비교
                assertEquals(expected, comments);


            }
        }
        /* Case 4: ""의 모든 댓글 조회*/
        @Test
        @DisplayName("특정 닉네임의 모든 댓글 조회")

        void findByNickname_3() {
            {
                //예상
                String nickname = "";

                List<Comment> expected = Arrays.asList();

                //실제
                List<Comment> comments = commentRepository.findByNickname(nickname);

                //비교
                assertEquals(expected.toString(), comments.toString());


            }
        }
        /* Case 5: "i"가 들어가있는 모든 댓글 조회*/
        @Test
        @DisplayName("특정 닉네임의 모든 댓글 조회")

        void findByNickname_4() {
            {
                //예상



                Comment a = new Comment(2L, new Article(4L, "your favorite MOVIE?", "comment plz111"), "Kim", "Iam SAM");
                Comment b = new Comment(3L, new Article(4L, "your favorite MOVIE?", "comment plz111"), "Choi", "ShowsankESCAPE");
                Comment c = new Comment(5L, new Article(5L, "your SOUL FOOD?", "comment plz2222"), "Kim", "shabu-shabu");
                Comment d = new Comment(6L, new Article(5L, "your SOUL FOOD?", "comment plz2222"), "Choi", "sushi");
                Comment e = new Comment(8L, new Article(6L, "your HOBBY?", "comment plz333333"), "Kim", "Youtube");
                Comment f = new Comment(9L, new Article(6L, "your HOBBY?", "comment plz333333"), "Choi", "Reading");

                List<Comment> expected = Arrays.asList(a,b,c,d,e,f);



                //실제


                List<Comment> comments = commentRepository.IinNickname();

                //비교
                assertEquals(expected.toString(), comments.toString());


            }
        }
    }
