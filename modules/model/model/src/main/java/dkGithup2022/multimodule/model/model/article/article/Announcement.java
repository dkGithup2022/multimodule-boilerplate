package dkGithup2022.multimodule.model.model.article.article;

import dkGithup2022.multimodule.model.model.Timestamps;
import dkGithup2022.multimodule.model.model.article.ArticleIdentity;
import dkGithup2022.multimodule.model.model.article.Content;
import dkGithup2022.multimodule.model.model.article.Title;
import dkGithup2022.multimodule.model.model.user.UserIdentity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Announcement implements Article {
    private ArticleIdentity articleIdentity;
    private UserIdentity authorIdentity;
    private Title title;
    private Content content;


    private Timestamps timestamps;

    @Override
    public ArticleIdentity getIdentity() {
        return articleIdentity;
    }

    public static Announcement of(ArticleIdentity articleIdentity, UserIdentity authorIdentity, Title title, Content content, Timestamps timestamps) {
        return new Announcement(articleIdentity, authorIdentity, title, content, timestamps);
    }
}
