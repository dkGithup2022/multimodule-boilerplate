package dkGithup2022.multimodule.infra.repository_jpa.article.parent.repository;

import dkGithup2022.multimodule.common.constant.articles.ArticleType;
import dkGithup2022.multimodule.infra.repository.article.parent.DiscussionRepository;
import dkGithup2022.multimodule.infra.repository_jpa.article.article.ArticleEntity;
import dkGithup2022.multimodule.infra.repository_jpa.article.parent.ParentArticleEntity;
import dkGithup2022.multimodule.infra.repository_jpa.article.parent.ParentArticleEntityJpaRepository;
import dkGithup2022.multimodule.model.model.Timestamps;
import dkGithup2022.multimodule.model.model.article.ArticleIdentity;
import dkGithup2022.multimodule.model.model.article.Content;
import dkGithup2022.multimodule.model.model.article.Title;
import dkGithup2022.multimodule.model.model.article.article.Announcement;
import dkGithup2022.multimodule.model.model.article.structuredArticle.discussion.Discussion;
import dkGithup2022.multimodule.model.model.user.UserIdentity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DiscussionRepositoryImpl implements DiscussionRepository {
    private final ParentArticleEntityJpaRepository jpaRepository;
    @Override
    public Discussion save(Discussion article) {
        var saved = jpaRepository.save(toEntity(article));
        return toDomain(saved);
    }

    @Override
    public Discussion findByIdentity(ArticleIdentity identity) {
        var found = jpaRepository.findById(identity.id())
                .orElseThrow(()-> new IllegalArgumentException("Article entity with id " + identity.id() + " not found"));

        return toDomain(found);
    }

    private ParentArticleEntity toEntity(Discussion article) {
        return ParentArticleEntity.of(
                article.getArticleIdentity().id(),
                article.getAuthorIdentity().id(),
                ArticleType.DISCUSSION,
                article.getTitle().title(),
                article.getContent().content()
        );
    }

    private Discussion  toDomain(ParentArticleEntity entity) {
        return Discussion .of(
                new ArticleIdentity(entity.getId()),
                new UserIdentity(entity.getAuthorId()),
                new Title(entity.getTitle()),
                new Content(entity.getContent()),
                new Timestamps(
                        entity.getCreatedAt(),entity.getUpdatedAt()
                )
        );
    }
}
