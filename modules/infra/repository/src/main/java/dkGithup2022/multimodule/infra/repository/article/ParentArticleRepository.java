package dkGithup2022.multimodule.infra.repository.article;

import dkGithup2022.multimodule.model.model.article.ArticleIdentity;
import dkGithup2022.multimodule.model.model.article.structuredArticle.ParentArticle;

public interface ParentArticleRepository<T extends ParentArticle> {
    T save(T article);

    T findByIdentity(ArticleIdentity identity);
}
