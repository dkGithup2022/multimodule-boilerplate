package dkGithup2022.multimodule.infra.repository_jpa.article.article.repository;

import dkGithup2022.multimodule.common.constant.articles.ArticleType;
import dkGithup2022.multimodule.infra.repository.article.article.FreeBoardRepository;
import dkGithup2022.multimodule.infra.repository_jpa.article.article.ArticleEntity;
import dkGithup2022.multimodule.infra.repository_jpa.article.article.ArticleEntityJpaRepository;
import dkGithup2022.multimodule.model.model.Timestamps;
import dkGithup2022.multimodule.model.model.article.ArticleIdentity;
import dkGithup2022.multimodule.model.model.article.Content;
import dkGithup2022.multimodule.model.model.article.Title;
import dkGithup2022.multimodule.model.model.article.article.Article;
import dkGithup2022.multimodule.model.model.article.article.FreeBoard;
import dkGithup2022.multimodule.model.model.user.UserIdentity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class FreeBoardRepositoryImpl implements FreeBoardRepository {
    private final ArticleEntityJpaRepository jpaRepository;

    @Override
    public FreeBoard save(FreeBoard article) {
        var saved = jpaRepository.save(toEntity(article));
        return toDomain(saved);
    }

    @Override
    public FreeBoard findByIdentity(ArticleIdentity identity) {
        var found = jpaRepository.findById(identity.id())
                .orElseThrow(()-> new IllegalArgumentException("Article entity with id " + identity.id() + " not found"));

        return toDomain(found);
    }


    private ArticleEntity toEntity(FreeBoard freeBoard) {
        return ArticleEntity.of(
                freeBoard.getArticleIdentity().id(),
                freeBoard.getAuthorIdentity().id(),
                ArticleType.FREE_BOARD,
                freeBoard.getTitle().title(),
                freeBoard.getContent().content()
        );
    }

    private FreeBoard toDomain(ArticleEntity entity) {
        return FreeBoard.of(
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

