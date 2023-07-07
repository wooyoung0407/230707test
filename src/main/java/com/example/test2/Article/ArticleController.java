    package com.example.test2.Article;

    import lombok.Getter;
    import lombok.RequiredArgsConstructor;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.*;

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
        @GetMapping("/detail/{id}")
        public String detail(Model model, @PathVariable("id") Integer id){
            Article article = this.articleService.getArticle(id);
            model.addAttribute("article", article);
            return "article_detail";
        }
        @GetMapping("/create")
        public String create(){
            return "article_create";
        }

        @PostMapping("/create")
            public String createArticle(@RequestParam String subject, @RequestParam String content){
            this.articleService.create(subject, content);
            return "redirect:/article/list";
        }

    }
