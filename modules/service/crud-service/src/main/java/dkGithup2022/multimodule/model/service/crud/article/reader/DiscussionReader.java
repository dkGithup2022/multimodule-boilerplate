package dkGithup2022.multimodule.model.service.crud.article.reader;

import dkGithup2022.multimodule.common.constant.articles.ArticleType;
import dkGithup2022.multimodule.infra.repository.article.parent.DiscussionRepository;
import dkGithup2022.multimodule.model.model.article.ArticleBase;
import dkGithup2022.multimodule.model.model.article.ArticleIdentity;
import dkGithup2022.multimodule.model.model.article.structuredArticle.discussion.Discussion;
import dkGithup2022.multimodule.model.service.crud.article.ArticleReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DiscussionReader implements ArticleReaderBase<Discussion> {
    private final DiscussionRepository discussionRepository;


    @Override
    public Discussion read(ArticleIdentity identity) {
        return discussionRepository.findByIdentity(identity);
    }
}
