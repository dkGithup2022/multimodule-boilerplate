package dkGithup2022.multimodule.infra.repository.article;

import dkGithup2022.multimodule.model.model.article.ArticleIdentity;
import dkGithup2022.multimodule.model.model.article.structuredArticle.ChildArticle;
import dkGithup2022.multimodule.model.model.article.structuredArticle.ParentArticle;

import java.util.List;

public interface ChildArticleRepository <T extends ChildArticle>{
    T save(T article);
    T findByIdentity(ArticleIdentity identity);
    List<T> findByParentIdentity(ArticleIdentity parentIdentity);
}
