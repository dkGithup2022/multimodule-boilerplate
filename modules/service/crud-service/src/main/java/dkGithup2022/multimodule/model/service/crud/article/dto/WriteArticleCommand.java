package dkGithup2022.multimodule.model.service.crud.article.dto;

import dkGithup2022.multimodule.common.constant.articles.ArticleType;

public record WriteArticleCommand(
        String title,
        String content,
        ArticleType articleType

) {
}
