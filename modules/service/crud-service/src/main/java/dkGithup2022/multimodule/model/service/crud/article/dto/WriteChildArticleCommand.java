package dkGithup2022.multimodule.model.service.crud.article.dto;

import dkGithup2022.multimodule.common.constant.articles.ArticleType;
import dkGithup2022.multimodule.model.model.user.UserIdentity;

public record WriteChildArticleCommand(
        UserIdentity author,
        String title,
        String content,
        ArticleType articleType,
        Long parentId
) {
}
