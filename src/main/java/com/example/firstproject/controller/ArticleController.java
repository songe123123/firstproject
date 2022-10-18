package com.example.firstproject.controller;
import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.dto.CommentDto;
import com.example.firstproject.entity.Article;
import com.example.firstproject.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.firstproject.repository.ArticleRepository;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@Slf4j //로깅을 위한 골뱅이(어노테이션)
public class ArticleController {

    @Autowired // 스프링 부트가 미리 생성해놓은 객체를 가져다가 자동 연결시켜줌!
    private ArticleRepository articleRepository;
    @Autowired
    private CommentService commentService;



    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "articles/new";
    }


    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) {

        //1.dto를 변환 ! entity
        Article article = form.toEntity();

        //2.repository에게 entity를 db안에 저장하게 함.
        Article saved= articleRepository.save(article);

        return "redirect:/articles/" + saved.getId(); //게터라고함-저장된 Id를 가져온다
    }


    @GetMapping("/articles/{id}") //url에서 articles/{id}를 가져오죠? 따라서, id는 article의 PK가 됩니다.

    public String show(@PathVariable Long id,Model model){
            //위 pathvariable은 url경로에 변수를 지정해줄때 사용

            //1: id로 데이터를 가져옴
         Article entityfromDB= articleRepository.findById(id).orElse(null);
         List<CommentDto> commentDtos =commentService.comments(id);

            //2:가져온 데이터를 모델에 등록!
         model.addAttribute("article",entityfromDB);
         model.addAttribute("commentDtos",commentDtos);


            //3: 보여줄 페이지를 설정

            return "articles/show";
    }


    @GetMapping("/articles")
    public String index(Model model) {
        // 1: 모든 Article을 가져온다!
        List<Article> allEntityList = articleRepository.findAll();
        // 2: 가져온 Article 묶음을 뷰로 전달!
        model.addAttribute("articleList", allEntityList);
        // 3: 뷰 페이지를 설정!
        return "articles/index";
    }

    @GetMapping("/articles/{id}/edit")
    public String edit(@PathVariable Long id,Model model){
            //수정할 데이터를 가져오기
        Article articleEdit = articleRepository.findById(id).orElse(null);

            //모델에 데이터를 등록!
        model.addAttribute("article",articleEdit);

            //뷰페이지설정
            return "articles/edit";
    }

    @PostMapping("/aricles/update")
    public String update(ArticleForm form,Long id){

            //1.DTO를 엔티티로 변환한다
        Article articleEntity = form.toEntity();

            //2.엔티티를 DB로 저장한다!
        //2-1:DB에서 기존 데이터를 가져온다.
        Article target= articleRepository.findById(articleEntity.getId()).orElse(null);

        //2-2:기존 데이터가 있다면 값을 갱신한다.
        if(target != null){
             articleRepository.save(articleEntity);
                    }

             //3.수정 결과 페이지로 리다이렉트한다.
            return "redirect:/articles/"+articleEntity.getId();

    }

    @GetMapping("/articles/{id}/delet")
    public String delete(@PathVariable Long id, RedirectAttributes rttr){

            //1.삭제 대상을 가져온다!
            Article target = articleRepository.findById(id).orElse(null);

            //2.대상을 삭제한다.
            if(target!= null){
                articleRepository.delete(target);
            rttr.addFlashAttribute("msg","Delete Complete");
            };

            //3.결과 페이지로 리다이렉트한다.

            return "redirect:/articles";
    };


}