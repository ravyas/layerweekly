package io.layer.weekly.service;

import io.layer.weekly.dao.ArticleRepository;
import io.layer.weekly.domain.InvalidUserException;
import io.layer.weekly.domain.article.Article;
import io.layer.weekly.domain.article.DraftArticle;
import io.layer.weekly.domain.edition.Topic;
import io.layer.weekly.domain.users.CopyWriter;
import io.layer.weekly.domain.users.Journalist;

import java.util.List;

public class ArticleService {

    private ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public void submitDraftArticle(DraftArticle draftArticle) {
        articleRepository.saveArticle(draftArticle);
    }

    public void updateDraftArticle(Journalist journalist, DraftArticle draftArticle, String title, String content, List<Topic> connectedTopics) throws InvalidUserException {
        draftArticle.updateDraftArticle(journalist, title, content, connectedTopics);
    }

    public boolean assignDraftArticleToCopyWriter(CopyWriter copyWriter, DraftArticle draftArticle) {
        return draftArticle.assignToCopyWriter(copyWriter);
    }

}
