package dkGithup2022.multimodule.model.service.crud.article.writer;

import dkGithup2022.multimodule.model.model.article.ArticleBase;

public interface ArticleWriterBase <T extends ArticleBase> {
    T write(T article);
}
