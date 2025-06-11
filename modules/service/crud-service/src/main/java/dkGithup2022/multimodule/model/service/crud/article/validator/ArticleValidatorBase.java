package dkGithup2022.multimodule.model.service.crud.article.validator;

import dkGithup2022.multimodule.model.model.article.ArticleBase;

public interface ArticleValidatorBase<T extends ArticleBase> {
    void validateRegister(T article);

    void validateUpdate(T article);
}
