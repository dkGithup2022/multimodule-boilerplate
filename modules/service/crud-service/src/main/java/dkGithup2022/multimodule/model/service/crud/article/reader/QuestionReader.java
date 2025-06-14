package dkGithup2022.multimodule.model.service.crud.article.reader;

import dkGithup2022.multimodule.infra.repository.article.parent.QuestionRepository;
import dkGithup2022.multimodule.model.model.article.ArticleIdentity;
import dkGithup2022.multimodule.model.model.article.structuredArticle.qna.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QuestionReader implements ArticleReaderBase<Question> {
    private final QuestionRepository questionRepository;
    @Override
    public Question read(ArticleIdentity identity) {
        return questionRepository.findByIdentity(identity);
    }
}
