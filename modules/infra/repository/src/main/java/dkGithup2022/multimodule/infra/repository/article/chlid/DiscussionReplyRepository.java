package dkGithup2022.multimodule.infra.repository.article.chlid;

import dkGithup2022.multimodule.infra.repository.article.ChildArticleRepository;
import dkGithup2022.multimodule.model.model.article.structuredArticle.discussion.Discussion;
import dkGithup2022.multimodule.model.model.article.structuredArticle.discussion.DiscussionReply;

public interface DiscussionReplyRepository extends ChildArticleRepository< DiscussionReply ,Discussion> {
}
