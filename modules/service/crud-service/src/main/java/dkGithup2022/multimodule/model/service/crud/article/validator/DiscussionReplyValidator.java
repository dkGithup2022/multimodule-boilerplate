package dkGithup2022.multimodule.model.service.crud.article.validator;

import dkGithup2022.multimodule.infra.repository.article.child.DiscussionReplyRepository;
import dkGithup2022.multimodule.model.model.article.structuredArticle.discussion.DiscussionReply;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DiscussionReplyValidator implements ArticleValidatorBase<DiscussionReply> {
    private final DiscussionReplyRepository replyRepository;
    @Override
    public void validateRegister(DiscussionReply article) {
        /* validate article before upsert!  */
        return;
    }

    @Override
    public void validateUpdate(DiscussionReply article) {
        /* validate article before upsert!  */
        return;
    }
}
