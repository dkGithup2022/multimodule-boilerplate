package dkGithup2022.multimodule.model.service.crud.article.writer;

import dkGithup2022.multimodule.infra.repository.article.parent.DiscussionRepository;
import dkGithup2022.multimodule.model.model.article.structuredArticle.discussion.Discussion;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DiscussionWriter implements ArticleWriterBase<Discussion> {
    private final DiscussionRepository discussionRepository;
    //private final ArticleEventWriter eventWriter;
    @Override
    public Discussion write(Discussion article) {
        return discussionRepository.save(article);
    }
}
