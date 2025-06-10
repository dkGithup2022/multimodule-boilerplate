package dkGithup2022.multimodule.model.service.crud.article.dto;

import dkGithup2022.multimodule.common.constant.articles.ArticleType;

public record WriteChildArticleCommand(String title,
                                       String content,
                                       ArticleType articleType,
                                       Long parentId) {
}
