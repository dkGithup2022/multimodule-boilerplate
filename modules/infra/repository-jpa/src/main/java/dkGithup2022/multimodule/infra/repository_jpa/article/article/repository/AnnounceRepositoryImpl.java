package dkGithup2022.multimodule.infra.repository_jpa.article.article.repository;

import dkGithup2022.multimodule.common.constant.articles.ArticleType;
import dkGithup2022.multimodule.infra.repository.article.article.AnnouncementRepository;
import dkGithup2022.multimodule.infra.repository_jpa.article.article.ArticleEntity;
import dkGithup2022.multimodule.infra.repository_jpa.article.article.ArticleEntityJpaRepository;
import dkGithup2022.multimodule.model.model.Timestamps;
import dkGithup2022.multimodule.model.model.article.ArticleIdentity;
import dkGithup2022.multimodule.model.model.article.Content;
import dkGithup2022.multimodule.model.model.article.Title;
import dkGithup2022.multimodule.model.model.article.article.Announcement;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AnnounceRepositoryImpl implements AnnouncementRepository {
    private final ArticleEntityJpaRepository jpaRepository;

    @Override
    public Announcement save(Announcement article) {
        var saved = jpaRepository.save(toEntity(article));
        return toDomain(saved);
    }

    @Override
    public Announcement findByIdentity(ArticleIdentity identity) {
        var found = jpaRepository.findById(identity.id())
                .orElseThrow(()-> new IllegalArgumentException("Article entity with id " + identity.id() + " not found"));

        return toDomain(found);
    }

    private ArticleEntity toEntity(Announcement article) {
        return ArticleEntity.of(
                article.getArticleIdentity().id(),
                ArticleType.ANNOUNCEMENT,
                article.getTitle().title(),
                article.getContent().content()
        );
    }

    private Announcement  toDomain(ArticleEntity entity) {
        return Announcement .of(
                new ArticleIdentity(entity.getId()),
                new Title(entity.getTitle()),
                new Content(entity.getContent()),
                new Timestamps(
                        entity.getCreatedAt(),entity.getUpdatedAt()
                )
        );
    }
}

