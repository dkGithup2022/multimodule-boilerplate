package dkGithup2022.multimodule.infra.repository_jpa.article.parent;

import dkGithup2022.multimodule.common.constant.articles.ArticleType;
import dkGithup2022.multimodule.infra.repository_jpa.BaseEntity;
import dkGithup2022.multimodule.infra.repository_jpa.article.article.ArticleEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ParentArticleEntity  extends BaseEntity {


    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private ArticleType articleType;

    private String title;

    private String content;

    public static ParentArticleEntity of(Long id, ArticleType articleType, String title, String content) {
        return new ParentArticleEntity(id, articleType, title, content);
    }
}
