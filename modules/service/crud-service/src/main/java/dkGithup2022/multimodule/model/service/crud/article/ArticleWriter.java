package dkGithup2022.multimodule.model.service.crud.article;

import dkGithup2022.multimodule.common.constant.articles.ArticleType;
import dkGithup2022.multimodule.model.model.article.ArticleBase;
import dkGithup2022.multimodule.model.service.crud.article.dto.WriteArticleCommand;
import dkGithup2022.multimodule.model.service.crud.article.dto.WriteChildArticleCommand;

public interface ArticleWriter {

    <T extends ArticleBase> T write(ArticleType articleType, WriteArticleCommand command, Class<T> resultType);

    <T extends ArticleBase> T writeChild(ArticleType articleType, WriteChildArticleCommand command, Class<T> resultType);
}
