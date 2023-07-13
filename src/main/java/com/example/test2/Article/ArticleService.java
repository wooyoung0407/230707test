package com.example.test2.Article;


import com.example.test2.DataNotFoundException;
import com.example.test2.User.SiteUser;
import lombok.RequiredArgsConstructor;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public List<Article> getList(){
        return this.articleRepository.findAll();
    }

    public Article getArticle(Integer id){
        Optional<Article> article = this.articleRepository.findById(id);
        if (article.isPresent()) {
            return article.get();
        }else {
            throw new DataNotFoundException("article not found");
        }
    }

    public void create(String subject, String content, SiteUser author) {
        Article article = new Article();
        article.setSubject(subject);
        article.setContent(content);
        article.setAuthor(author);
        this.articleRepository.save(article);
    }
    public void modify(Article article, String subject, String content){
        article.setSubject(subject);
        article.setContent(content);
        this.articleRepository.save(article);
    }
    public void delete(Article article){
        this.articleRepository.delete(article);
    }

    private Specification<Article> search(String kw) {
        return new Specification<>() {
            private static final long serialVersionUID = 1L;
            @Override
            public Predicate toPredicate(Root<Article> a, CriteriaQuery<?> query, CriteriaBuilder cb) {
                query.distinct(true);  // 중복을 제거
                Join<Article, SiteUser> u1 = a.join("author", JoinType.LEFT);
                return cb.or(cb.like(a.get("subject"), "%" + kw + "%"), // 제목
                        cb.like(a.get("content"), "%" + kw + "%"),      // 내용
                        cb.like(u1.get("username"), "%" + kw + "%"));   // 질문 작성자
            }
        };
    }
}

