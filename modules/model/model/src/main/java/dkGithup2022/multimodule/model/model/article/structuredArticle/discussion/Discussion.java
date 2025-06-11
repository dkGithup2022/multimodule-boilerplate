package dkGithup2022.multimodule.model.model.article.structuredArticle.discussion;

import dkGithup2022.multimodule.model.model.Timestamps;
import dkGithup2022.multimodule.model.model.article.ArticleIdentity;
import dkGithup2022.multimodule.model.model.article.Content;
import dkGithup2022.multimodule.model.model.article.Title;
import dkGithup2022.multimodule.model.model.article.structuredArticle.ParentArticle;
import dkGithup2022.multimodule.model.model.user.UserIdentity;
import lombok.AllArgsConstructor;
import lombok.Getter;



@Getter
@AllArgsConstructor
public class Discussion implements ParentArticle {

    private ArticleIdentity articleIdentity;
    private UserIdentity authorIdentity;
    private Title title;
    private Content content;


    private Timestamps timestamps;

    public ArticleIdentity getIdentity() {
        return articleIdentity;
    }

    public static Discussion of(ArticleIdentity articleIdentity, UserIdentity authorIdentity, Title title, Content content, Timestamps timestamps) {
        return new Discussion(articleIdentity, authorIdentity, title, content, timestamps);
    }
}
