package dkGithup2022.multimodule.model.service.crud.article;

import dkGithup2022.multimodule.common.constant.articles.ArticleType;
import dkGithup2022.multimodule.model.model.article.ArticleBase;
import dkGithup2022.multimodule.model.model.article.ArticleIdentity;

public interface ArticleReader {
    <T extends ArticleBase> T read(ArticleType articleType, ArticleIdentity articleIdentity, Class<T> resultType);
}
