package dkGithup2022.multimodule.model.service.crud.article.reader;

import dkGithup2022.multimodule.infra.repository.article.child.DiscussionReplyRepository;
import dkGithup2022.multimodule.model.model.article.ArticleIdentity;
import dkGithup2022.multimodule.model.model.article.structuredArticle.discussion.DiscussionReply;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiscussionReplyReader implements ChildArticleReaderBase<DiscussionReply> {
    private final DiscussionReplyRepository discussionReplyRepository;

    @Override
    public List<DiscussionReply> readByParentId(ArticleIdentity parentIdentity) {
        return discussionReplyRepository.findByParentIdentity(parentIdentity);
    }

    @Override
    public DiscussionReply read(ArticleIdentity identity) {
        return discussionReplyRepository.findByIdentity(identity);
    }
}
