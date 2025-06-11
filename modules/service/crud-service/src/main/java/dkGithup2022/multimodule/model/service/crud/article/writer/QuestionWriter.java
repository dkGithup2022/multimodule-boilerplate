package dkGithup2022.multimodule.model.service.crud.article.writer;


import dkGithup2022.multimodule.infra.repository.article.parent.QuestionRepository;
import dkGithup2022.multimodule.model.model.article.structuredArticle.qna.Question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QuestionWriter implements ArticleWriterBase<Question> {
    private final QuestionRepository questionRepository;
    //private final ArticleEventWriter eventWriter;
    @Override
    public Question write(Question article) {
        return questionRepository.save(article);
    }
}
