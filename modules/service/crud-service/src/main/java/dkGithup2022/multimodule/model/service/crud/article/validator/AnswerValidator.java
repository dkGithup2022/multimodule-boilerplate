package dkGithup2022.multimodule.model.service.crud.article.validator;

import dkGithup2022.multimodule.infra.repository.article.child.AnswerRepository;
import dkGithup2022.multimodule.model.model.article.structuredArticle.qna.Answer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AnswerValidator implements ArticleValidatorBase<Answer> {
    private final AnswerRepository answerRepository;
    @Override
    public void validateRegister(Answer article) {
        /* validate article before upsert!  */
        return;
    }

    @Override
    public void validateUpdate(Answer article) {
        /* validate article before upsert!  */
        return;
    }
}
