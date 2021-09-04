package com.layer.service;

import com.layer.dao.ArticleRepository;
import com.layer.domain.Article;
import com.layer.domain.DraftArticle;

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
