package dkGithup2022.multimodule.infra.repository_jpa.article.child.repository;

import dkGithup2022.multimodule.common.constant.articles.ArticleType;
import dkGithup2022.multimodule.infra.repository.article.child.DiscussionReplyRepository;
import dkGithup2022.multimodule.infra.repository_jpa.article.child.ChildArticleEntity;
import dkGithup2022.multimodule.infra.repository_jpa.article.child.ChildArticleEntityJpaRepository;
import dkGithup2022.multimodule.infra.repository_jpa.article.parent.ParentArticleEntity;
import dkGithup2022.multimodule.infra.repository_jpa.article.parent.ParentArticleEntityJpaRepository;
import dkGithup2022.multimodule.model.model.Timestamps;
import dkGithup2022.multimodule.model.model.article.ArticleIdentity;
import dkGithup2022.multimodule.model.model.article.Content;
import dkGithup2022.multimodule.model.model.article.Title;
import dkGithup2022.multimodule.model.model.article.structuredArticle.discussion.Discussion;
import dkGithup2022.multimodule.model.model.article.structuredArticle.discussion.DiscussionReply;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class DiscussionRepositoryImpl implements DiscussionReplyRepository {
    private final ChildArticleEntityJpaRepository childRepository;

    @Override
    public DiscussionReply save(DiscussionReply article) {
        var saved = childRepository.save(toEntity(article));
        return toReply(saved);
    }

    @Override
    public DiscussionReply findByIdentity(ArticleIdentity identity) {
        var found =  childRepository.findById(identity.id())
                .orElseThrow(()-> new IllegalArgumentException("Article entity with id " + identity.id() + " not found"));

        return toReply(found);
    }

    @Override
    public List<DiscussionReply> findByParentIdentity(ArticleIdentity parentIdentity) {
       var founds = childRepository.findByParentId(parentIdentity.id());
       return founds.stream().map(this::toReply).toList();
    }

    private ChildArticleEntity toEntity(DiscussionReply reply) {
        return ChildArticleEntity.of(
                reply.getIdentity().id(), reply.getParentIdentity().id(),
                ArticleType.DISCUSSION_REPLY,
                reply.getTitle().title(),
                reply.getContent().content()
        );
    }

    private DiscussionReply toReply(ChildArticleEntity entity) {
        return DiscussionReply.of(
                new ArticleIdentity(entity.getId()),
                new ArticleIdentity(entity.getParentId()),
                new Title(entity.getTitle()),
                new Content(entity.getContent()),
                new Timestamps(
                        entity.getCreatedAt(),
                        entity.getUpdatedAt()

                )
        );
    }
}
