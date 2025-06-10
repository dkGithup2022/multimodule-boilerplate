package dkGithup2022.multimodule.model.service.crud.article;

import dkGithup2022.multimodule.common.constant.articles.ArticleType;
import dkGithup2022.multimodule.model.model.article.ArticleBase;
import dkGithup2022.multimodule.model.model.article.article.Article;
import dkGithup2022.multimodule.model.service.crud.article.dto.WriteArticleCommand;
import dkGithup2022.multimodule.model.service.crud.article.dto.WriteChildArticleCommand;

public interface ArticleWriter {

    ArticleBase write(ArticleType articleType, WriteArticleCommand command);

    ArticleBase writeChild(ArticleType articleType, WriteChildArticleCommand command);
}
