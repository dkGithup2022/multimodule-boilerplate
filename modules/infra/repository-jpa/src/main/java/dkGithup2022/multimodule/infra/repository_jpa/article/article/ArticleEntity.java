package dkGithup2022.multimodule.infra.repository_jpa.article.article;

import dkGithup2022.multimodule.common.constant.articles.ArticleType;
import dkGithup2022.multimodule.infra.repository_jpa.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ArticleEntity extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Long authorId;

    @Enumerated(EnumType.STRING)
    private ArticleType articleType;

    private String title;

    private String content;


    public static ArticleEntity of(Long id, Long authorId, ArticleType articleType, String title, String content) {
        return new ArticleEntity(id, authorId, articleType, title, content);
    }

}
