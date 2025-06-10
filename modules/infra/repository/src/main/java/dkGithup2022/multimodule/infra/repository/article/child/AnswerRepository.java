package dkGithup2022.multimodule.infra.repository.article.child;

import dkGithup2022.multimodule.infra.repository.article.ChildArticleRepository;
import dkGithup2022.multimodule.model.model.article.structuredArticle.qna.Answer;
import dkGithup2022.multimodule.model.model.article.structuredArticle.qna.Question;

public interface AnswerRepository extends ChildArticleRepository<Answer, Question> {
}
