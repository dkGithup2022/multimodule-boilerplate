package dkGithup2022.multimodule.model.model.article.article;

import dkGithup2022.multimodule.model.model.Timestamps;
import dkGithup2022.multimodule.model.model.article.ArticleIdentity;
import dkGithup2022.multimodule.model.model.article.Content;
import dkGithup2022.multimodule.model.model.article.Title;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Announcement implements Article {
    private ArticleIdentity articleIdentity;

    private Content content;
    private Title title;

    private Timestamps timestamps;

    @Override
    public ArticleIdentity getIdentity() {
        return articleIdentity;
    }

    public static Announcement of(ArticleIdentity articleIdentity, Content content, Title title,Timestamps timestamps) {
        return new Announcement(articleIdentity, content, title, timestamps);
    }
}
