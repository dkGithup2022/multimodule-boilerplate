package dkGithup2022.multimodule.model.service.crud.article.reader;

import dkGithup2022.multimodule.infra.repository.article.child.AnswerRepository;
import dkGithup2022.multimodule.model.model.article.ArticleIdentity;
import dkGithup2022.multimodule.model.model.article.structuredArticle.qna.Answer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnswerReader implements ChildArticleReaderBase<Answer> {
    private final AnswerRepository answerRepository;
    @Override
    public List<Answer> readByParentId(ArticleIdentity parentIdentity) {
        return answerRepository.findByParentIdentity(parentIdentity);
    }

    @Override
    public Answer read(ArticleIdentity identity) {
        return answerRepository.findByIdentity(identity);
    }
}
