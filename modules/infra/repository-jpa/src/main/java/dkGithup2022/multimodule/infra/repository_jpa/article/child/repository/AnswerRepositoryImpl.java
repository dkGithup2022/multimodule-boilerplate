package dkGithup2022.multimodule.infra.repository_jpa.article.child.repository;

import dkGithup2022.multimodule.common.constant.articles.ArticleType;
import dkGithup2022.multimodule.infra.repository.article.child.AnswerRepository;
import dkGithup2022.multimodule.infra.repository_jpa.article.child.ChildArticleEntity;
import dkGithup2022.multimodule.infra.repository_jpa.article.child.ChildArticleEntityJpaRepository;
import dkGithup2022.multimodule.model.model.Timestamps;
import dkGithup2022.multimodule.model.model.article.ArticleIdentity;
import dkGithup2022.multimodule.model.model.article.Content;
import dkGithup2022.multimodule.model.model.article.Title;
import dkGithup2022.multimodule.model.model.article.structuredArticle.qna.Answer;
import dkGithup2022.multimodule.model.model.user.UserIdentity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AnswerRepositoryImpl implements AnswerRepository {
    private final ChildArticleEntityJpaRepository childRepository;

    @Override
    public Answer save(Answer article) {
        var saved = childRepository.save(toEntity(article));
        return toReply(saved);
    }

    @Override
    public Answer findByIdentity(ArticleIdentity identity) {
        var found =  childRepository.findById(identity.id())
                .orElseThrow(()-> new IllegalArgumentException("Article entity with id " + identity.id() + " not found"));

        return toReply(found);
    }

    @Override
    public List<Answer> findByParentIdentity(ArticleIdentity parentIdentity) {
        var founds = childRepository.findByParentId(parentIdentity.id());
        return founds.stream().map(this::toReply).toList();
    }


    private ChildArticleEntity toEntity( Answer answer ) {
        return ChildArticleEntity.of(
                answer.getIdentity().id(), answer.getParentIdentity().id(),
                answer.getAuthorIdentity().id(),
                ArticleType.ANSWER,
                answer.getTitle().title(),
                answer.getContent().content()
        );
    }

    private  Answer toReply(ChildArticleEntity entity) {
        return Answer.of(
                new ArticleIdentity(entity.getId()),
                new ArticleIdentity(entity.getParentId()),
                new UserIdentity(entity.getAuthorId()),
                new Title(entity.getTitle()),
                new Content(entity.getContent()),
                new Timestamps(
                        entity.getCreatedAt(),
                        entity.getUpdatedAt()

                )
        );
    }
}
