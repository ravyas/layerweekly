package io.layer.weekly.dao;

import io.layer.weekly.domain.article.Article;
import io.layer.weekly.domain.article.DraftArticle;

import java.util.ArrayList;
import java.util.List;

public class ArticleRepository {

    private List<Article> articles = new ArrayList<>();
    private List<DraftArticle> draftArticles = new ArrayList<>();

    public void saveArticle(DraftArticle draftArticle) {
        draftArticles.add(draftArticle);
    }

    public DraftArticle draftArticleById(String id) {
        return draftArticles.stream().filter(d -> d.getId().equals(id)).findFirst().get();
    }

    public Article articleById(String id) {
        return articles.stream().filter(d -> d.getId().equals(id)).findFirst().get();
    }
}
