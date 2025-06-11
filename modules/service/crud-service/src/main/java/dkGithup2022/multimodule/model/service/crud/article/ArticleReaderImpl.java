package dkGithup2022.multimodule.model.service.crud.article;

import dkGithup2022.multimodule.common.constant.articles.ArticleType;
import dkGithup2022.multimodule.model.model.article.ArticleBase;
import dkGithup2022.multimodule.model.model.article.ArticleIdentity;
import dkGithup2022.multimodule.model.service.crud.article.reader.*;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Map;

@Component
public class ArticleReaderImpl implements ArticleReader {
    private final Map<ArticleType, ArticleReaderBase<? extends ArticleBase>> readerMap;

    public ArticleReaderImpl(
            AnnouncementReader announcementReader,
            FreeBoardReader freeBoardReader,
            QuestionReader questionReader,
            AnswerReader answerReader,
            DiscussionReader discussionReader,
            DiscussionReplyReader discussionReplyReader
    ) {
        this.readerMap = new EnumMap<>(ArticleType.class);
        this.readerMap.put(ArticleType.ANNOUNCEMENT, announcementReader);
        this.readerMap.put(ArticleType.FREE_BOARD, freeBoardReader);
        this.readerMap.put(ArticleType.QUESTION, questionReader);
        this.readerMap.put(ArticleType.ANSWER, answerReader);
        this.readerMap.put(ArticleType.DISCUSSION, discussionReader);
        this.readerMap.put(ArticleType.DISCUSSION_REPLY, discussionReplyReader);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends ArticleBase> T read(ArticleType articleType, ArticleIdentity articleIdentity, Class<T> resultType) {
        ArticleReaderBase<?> reader = readerMap.get(articleType);
        if (reader == null) {
            throw new IllegalArgumentException("지원하지 않는 ArticleType입니다: " + articleType);
        }
        ArticleBase result = reader.read(articleIdentity);
        if (!resultType.isInstance(result)) {
            throw new IllegalArgumentException("리턴 타입 불일치: 기대한 타입 " + resultType + ", 실제 타입 " + result.getClass());
        }
        return (T) result;
    }
}
