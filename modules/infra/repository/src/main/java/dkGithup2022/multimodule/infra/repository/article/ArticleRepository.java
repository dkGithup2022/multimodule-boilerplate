package dkGithup2022.multimodule.infra.repository.article;

import dkGithup2022.multimodule.model.model.article.ArticleIdentity;
import dkGithup2022.multimodule.model.model.article.article.Article;

public interface ArticleRepository<T extends Article> {
    T save(T article);
    T findByIdentity(ArticleIdentity identity);
}