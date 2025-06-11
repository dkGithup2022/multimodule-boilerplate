package dkGithup2022.multimodule.model.service.crud.article.validator;

import dkGithup2022.multimodule.infra.repository.article.parent.QuestionRepository;
import dkGithup2022.multimodule.model.model.article.structuredArticle.qna.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QuestionValidator implements ArticleValidatorBase<Question> {
    private final QuestionRepository questionRepository;

    @Override
    public void validateRegister(Question article) {
        /* validate article before upsert!  */
        return;
    }

    @Override
    public void validateUpdate(Question article) {
        /* validate article before upsert!  */
        return;
    }
}
