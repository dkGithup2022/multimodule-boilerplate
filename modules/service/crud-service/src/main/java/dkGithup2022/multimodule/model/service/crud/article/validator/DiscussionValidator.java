package dkGithup2022.multimodule.model.service.crud.article.validator;

import dkGithup2022.multimodule.infra.repository.article.parent.DiscussionRepository;
import dkGithup2022.multimodule.model.model.article.structuredArticle.discussion.Discussion;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DiscussionValidator implements ArticleValidatorBase<Discussion>{
    private final DiscussionRepository discussionRepository;
    @Override
    public void validateRegister(Discussion article) {
        /* validate article before upsert!  */
        return;
    }

    @Override
    public void validateUpdate(Discussion article) {
        /* validate article before upsert!  */
        return;
    }
}
