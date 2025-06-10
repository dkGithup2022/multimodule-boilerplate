package dkGithup2022.multimodule.model.model.article.structuredArticle.discussion;

import dkGithup2022.multimodule.model.model.article.ArticleIdentity;
import dkGithup2022.multimodule.model.model.article.Content;
import dkGithup2022.multimodule.model.model.article.Title;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Discussion {

    private ArticleIdentity articleIdentity;


    private Content content;
    private Title title;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ArticleIdentity getIdentity(){
        return articleIdentity;
    }

    public static Discussion of(ArticleIdentity articleIdentity, Content content, Title title, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new Discussion (articleIdentity, content, title, createdAt, updatedAt);
    }
}
