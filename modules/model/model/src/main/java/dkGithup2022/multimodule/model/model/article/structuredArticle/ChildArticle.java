package dkGithup2022.multimodule.model.model.article.structuredArticle;

import dkGithup2022.multimodule.model.model.article.ArticleBase;
import dkGithup2022.multimodule.model.model.article.ArticleIdentity;

public interface ChildArticle  extends ArticleBase {
    ArticleIdentity getParentIdentity();
}
