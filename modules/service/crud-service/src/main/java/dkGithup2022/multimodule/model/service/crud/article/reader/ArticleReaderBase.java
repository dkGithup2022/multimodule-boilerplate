package dkGithup2022.multimodule.model.service.crud.article.reader;

import dkGithup2022.multimodule.model.model.article.ArticleBase;
import dkGithup2022.multimodule.model.model.article.ArticleIdentity;

public interface ArticleReaderBase <T extends ArticleBase> {
    T read(ArticleIdentity identity);
}
