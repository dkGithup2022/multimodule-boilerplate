package dkGithup2022.multimodule.model.model.article.structuredArticle;

import dkGithup2022.multimodule.model.model.article.ArticleIdentity;

public interface ChildArticle {
    ArticleIdentity getIdentity();
    ArticleIdentity getParentIdentity();
}
