package dkGithup2022.multimodule.model.model.article.structuredArticle.qna;

import dkGithup2022.multimodule.model.model.Timestamps;
import dkGithup2022.multimodule.model.model.article.ArticleIdentity;
import dkGithup2022.multimodule.model.model.article.Content;
import dkGithup2022.multimodule.model.model.article.Title;
import dkGithup2022.multimodule.model.model.article.structuredArticle.ParentArticle;
import dkGithup2022.multimodule.model.model.user.UserIdentity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Question implements ParentArticle {

    private ArticleIdentity articleIdentity;
    private UserIdentity authorIdentity;

    private Title title;
    private Content content;


    private Timestamps timeStamps;

    public ArticleIdentity getIdentity() {
        return articleIdentity;
    }

    public static Question of(ArticleIdentity articleIdentity, UserIdentity authorIdentity, Title title, Content content, Timestamps timeStamps) {
        return new Question(articleIdentity, authorIdentity, title, content, timeStamps);
    }


}
