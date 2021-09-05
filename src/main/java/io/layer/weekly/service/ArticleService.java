package io.layer.weekly.service;

import io.layer.weekly.dao.ArticleRepository;
import io.layer.weekly.domain.Article;
import io.layer.weekly.domain.DraftArticle;

public class ArticleService {

    private ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Article publishArticle(DraftArticle draftArticle) {
        return draftArticle.publishArticle();
    }

    public void submitDraftArticle() {
        articleRepository.saveArticle();
    }

}
