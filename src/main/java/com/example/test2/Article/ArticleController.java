package com.example.test2.Article;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@RequestMapping("/article")
@RequiredArgsConstructor
@Controller
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/list")
    public String list(Model model){
        List<Article> articleList = this.articleService.getList();
        model.addAttribute("articleList",articleList);
        return "article_list";
    }
    @GetMapping("/detail")
    public String detail(Model model, @PathVariable("id") Integer id){
        return "article_detail";
    }

//    @PostMapping("/create")
//    public String createArticle(Model model, @PathVariable("id") Integer id, @PathVariable String content){
//        Article article = this.articleService.
//    }

}
