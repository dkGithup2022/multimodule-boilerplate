package dkGithup2022.multimodule.model.service.crud.article.writer;

import dkGithup2022.multimodule.infra.repository.article.child.DiscussionReplyRepository;
import dkGithup2022.multimodule.model.model.article.structuredArticle.discussion.DiscussionReply;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DiscussionReplyWriter implements ArticleWriterBase<DiscussionReply> {
    private final DiscussionReplyRepository replyRepository;
    //private final ArticleEventWriter eventWriter;
    @Override
    public DiscussionReply write(DiscussionReply article) {
        return replyRepository.save(article);
    }
}
