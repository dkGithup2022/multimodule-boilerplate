package dkGithup2022.multimodule.model.service.crud.article;

import dkGithup2022.multimodule.common.constant.articles.ArticleType;
import dkGithup2022.multimodule.model.model.Timestamps;
import dkGithup2022.multimodule.model.model.article.ArticleBase;
import dkGithup2022.multimodule.model.model.article.ArticleIdentity;
import dkGithup2022.multimodule.model.model.article.Content;
import dkGithup2022.multimodule.model.model.article.Title;
import dkGithup2022.multimodule.model.model.article.article.Announcement;
import dkGithup2022.multimodule.model.model.article.article.FreeBoard;
import dkGithup2022.multimodule.model.model.article.structuredArticle.discussion.Discussion;
import dkGithup2022.multimodule.model.model.article.structuredArticle.discussion.DiscussionReply;
import dkGithup2022.multimodule.model.model.article.structuredArticle.qna.Answer;
import dkGithup2022.multimodule.model.model.article.structuredArticle.qna.Question;
import dkGithup2022.multimodule.model.model.user.UserIdentity;
import dkGithup2022.multimodule.model.service.crud.article.dto.WriteArticleCommand;
import dkGithup2022.multimodule.model.service.crud.article.dto.WriteChildArticleCommand;
import dkGithup2022.multimodule.model.service.crud.article.validator.*;
import dkGithup2022.multimodule.model.service.crud.article.writer.*;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Map;

@Component
public class ArticleWriterImpl implements ArticleWriter {
    private final Map<ArticleType, ArticleWriterBase<? extends ArticleBase>> writerMap;
    private final Map<ArticleType, ArticleValidatorBase> validatorMap;

    public ArticleWriterImpl(
            AnnouncementWriter announcementWriter,
            FreeBoardWriter freeBoardWriter,
            QuestionWriter questionWriter,
            AnswerWriter answerWriter,
            DiscussionWriter discussionWriter,
            DiscussionReplyWriter discussionReplyWriter,
            AnnouncementValidator announcementValidator,
            FreeBoardValidator freeBoardValidator,
            QuestionValidator questionValidator,
            AnswerValidator answerValidator,
            DiscussionValidator discussionValidator,
            DiscussionReplyValidator discussionReplyValidator
    ) {
        this.writerMap = new EnumMap<>(ArticleType.class);
        this.validatorMap = new EnumMap<>(ArticleType.class);

        // 일반 writer 등록
        this.writerMap.put(ArticleType.ANNOUNCEMENT, announcementWriter);
        this.writerMap.put(ArticleType.FREE_BOARD, freeBoardWriter);
        this.writerMap.put(ArticleType.QUESTION, questionWriter);
        this.writerMap.put(ArticleType.ANSWER, answerWriter);
        this.writerMap.put(ArticleType.DISCUSSION, discussionWriter);
        this.writerMap.put(ArticleType.DISCUSSION_REPLY, discussionReplyWriter);


        // child writer 등록 (답변과 댓글)
        this.writerMap.put(ArticleType.ANSWER, answerWriter);
        this.writerMap.put(ArticleType.DISCUSSION_REPLY, discussionReplyWriter);

        // validator 등록
        this.validatorMap.put(ArticleType.ANNOUNCEMENT, announcementValidator);
        this.validatorMap.put(ArticleType.FREE_BOARD, freeBoardValidator);
        this.validatorMap.put(ArticleType.QUESTION, questionValidator);
        this.validatorMap.put(ArticleType.ANSWER, answerValidator);
        this.validatorMap.put(ArticleType.DISCUSSION, discussionValidator);
        this.validatorMap.put(ArticleType.DISCUSSION_REPLY, discussionReplyValidator);

    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends ArticleBase> T write(ArticleType articleType, WriteArticleCommand command, Class<T> resultType) {
        var article = convertToEntity(articleType, command);

        ArticleValidatorBase<ArticleBase> validator = (ArticleValidatorBase<ArticleBase>) validatorMap.get(articleType);
        ArticleWriterBase<ArticleBase> writer = (ArticleWriterBase<ArticleBase>) writerMap.get(articleType);

        if (validator == null || writer == null) {
            throw new IllegalArgumentException("지원하지 않는 ArticleType입니다: " + articleType);
        }

        validator.validateRegister(article);
        var result = writer.write(article);

        if (!resultType.isInstance(result)) {
            throw new IllegalArgumentException("타입 불일치: 기대한 타입 " + resultType + ", 실제 타입 " + result.getClass());
        }

        return resultType.cast(result);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends ArticleBase> T writeChild(ArticleType articleType, WriteChildArticleCommand command, Class<T> resultType) {
        ArticleBase article = convertToEntity(articleType, command);

        ArticleValidatorBase<ArticleBase> validator = (ArticleValidatorBase<ArticleBase>) validatorMap.get(articleType);
        ArticleWriterBase<ArticleBase> writer = (ArticleWriterBase<ArticleBase>) writerMap.get(articleType);

        if (validator == null || writer == null) {
            throw new IllegalArgumentException("지원하지 않는 Child ArticleType입니다: " + articleType);
        }

        validator.validateRegister(article);
        Object result = writer.write(article);

        if (!resultType.isInstance(result)) {
            throw new IllegalStateException("타입 불일치: 기대한 타입 " + resultType + ", 실제 타입 " + result.getClass());
        }

        return resultType.cast(result);
    }


    private ArticleBase convertToEntity(ArticleType type, WriteArticleCommand command) {
        return switch (type) {
            case ANNOUNCEMENT -> Announcement.of(
                    new ArticleIdentity(null), command.author(),
                    new Title(command.title()),
                    new Content(command.content()),
                    Timestamps.empty()
            );
            case FREE_BOARD -> FreeBoard.of(
                    new ArticleIdentity(null), command.author(),
                    new Title(command.title()),
                    new Content(command.content()),
                    Timestamps.empty()
            );
            case QUESTION -> Question.of(
                    new ArticleIdentity(null), command.author(),
                    new Title(command.title()),
                    new Content(command.content()),
                    Timestamps.empty()
            );
            case DISCUSSION -> Discussion.of(
                    new ArticleIdentity(null), command.author(),
                    new Title(command.title()),
                    new Content(command.content()),
                    Timestamps.empty()
            );
            default -> throw new IllegalArgumentException("Child 타입은 writeChild()로 호출해야 합니다.");
        };
    }

    private ArticleBase convertToEntity(ArticleType type, WriteChildArticleCommand command) {
        return switch (type) {
            case ANSWER -> Answer.of(
                    new ArticleIdentity(null), new ArticleIdentity(command.parentId()),
                    command.author(),
                    new Title(command.title()),
                    new Content(command.content()),
                    Timestamps.empty()
            );
            case DISCUSSION_REPLY -> DiscussionReply.of(
                    new ArticleIdentity(null), new ArticleIdentity(command.parentId()),
                    command.author(),
                    new Title(command.title()),
                    new Content(command.content()),
                    Timestamps.empty()
            );
            default -> throw new IllegalArgumentException("Child 타입이 아닙니다: " + type);
        };
    }
}
