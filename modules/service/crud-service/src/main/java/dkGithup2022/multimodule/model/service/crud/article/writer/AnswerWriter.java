package dkGithup2022.multimodule.model.service.crud.article.writer;

import dkGithup2022.multimodule.infra.repository.article.child.AnswerRepository;
import dkGithup2022.multimodule.model.model.article.structuredArticle.qna.Answer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AnswerWriter implements ArticleWriterBase<Answer> {
    private final AnswerRepository answerRepository;
    //private final ArticleEventWriter eventWriter;
    @Override
    public Answer write(Answer article) {
        return answerRepository.save(article);
    }
}
