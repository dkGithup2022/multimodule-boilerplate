package dkGithup2022.multimodule.infra.repository_jpa.article.parent.repository;

import dkGithup2022.multimodule.common.constant.articles.ArticleType;
import dkGithup2022.multimodule.infra.repository.article.parent.QuestionRepository;
import dkGithup2022.multimodule.infra.repository_jpa.article.parent.ParentArticleEntity;
import dkGithup2022.multimodule.infra.repository_jpa.article.parent.ParentArticleEntityJpaRepository;
import dkGithup2022.multimodule.model.model.Timestamps;
import dkGithup2022.multimodule.model.model.article.ArticleIdentity;
import dkGithup2022.multimodule.model.model.article.Content;
import dkGithup2022.multimodule.model.model.article.Title;
import dkGithup2022.multimodule.model.model.article.structuredArticle.discussion.Discussion;
import dkGithup2022.multimodule.model.model.article.structuredArticle.qna.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class QuestionRepositoryImpl implements QuestionRepository {
    private final ParentArticleEntityJpaRepository jpaRepository;
    @Override
    public Question save(Question article) {
        var saved = jpaRepository.save(toEntity(article));
        return toDomain(saved);
    }

    @Override
    public Question findByIdentity(ArticleIdentity identity) {
        var found = jpaRepository.findById(identity.id())
                .orElseThrow(()-> new IllegalArgumentException("Article entity with id " + identity.id() + " not found"));

        return toDomain(found);
    }

    private ParentArticleEntity toEntity(Question article) {
        return ParentArticleEntity.of(
                article.getArticleIdentity().id(),
                ArticleType.QUESTION,
                article.getTitle().title(),
                article.getContent().content()
        );
    }

    private Question  toDomain(ParentArticleEntity entity) {
        return Question .of(
                new ArticleIdentity(entity.getId()),
                new Title(entity.getTitle()),
                new Content(entity.getContent()),
                new Timestamps(
                        entity.getCreatedAt(),entity.getUpdatedAt()
                )
        );
    }
}
