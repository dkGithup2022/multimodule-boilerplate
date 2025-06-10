package dkGithup2022.multimodule.infra.repository_jpa.article.child;

import dkGithup2022.multimodule.common.constant.articles.ArticleType;
import dkGithup2022.multimodule.infra.repository_jpa.BaseEntity;
import dkGithup2022.multimodule.infra.repository_jpa.article.parent.ParentArticleEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ChildArticleEntity extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Long parentId;

    @Enumerated(EnumType.STRING)
    private ArticleType articleType;

    private String title;

    private String content;

    public static ChildArticleEntity of(Long id, Long parentId, ArticleType articleType, String title, String content) {
        return new ChildArticleEntity(id, parentId, articleType, title, content);
    }
}
