package dkGithup2022.multimodule.model.model.article.structuredArticle.qna;

import dkGithup2022.multimodule.model.model.Timestamps;
import dkGithup2022.multimodule.model.model.article.ArticleIdentity;
import dkGithup2022.multimodule.model.model.article.Content;
import dkGithup2022.multimodule.model.model.article.Title;
import dkGithup2022.multimodule.model.model.article.structuredArticle.ChildArticle;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Answer implements ChildArticle {

    private ArticleIdentity articleIdentity;

    private ArticleIdentity parentArticleIdentity;
    private Title title;
    private Content content;


    private Timestamps timeStamps;

    public ArticleIdentity getIdentity() {
        return articleIdentity;
    }

    @Override
    public ArticleIdentity getParentIdentity() {
        return parentArticleIdentity;
    }

    public static Answer of(ArticleIdentity articleIdentity, ArticleIdentity parentArticleIdentity, Title title, Content content, Timestamps timeStamps) {
        return new Answer(articleIdentity, parentArticleIdentity, title, content, timeStamps);
    }
}
