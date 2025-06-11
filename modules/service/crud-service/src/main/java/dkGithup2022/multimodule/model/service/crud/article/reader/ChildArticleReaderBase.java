package dkGithup2022.multimodule.model.service.crud.article.reader;

import dkGithup2022.multimodule.model.model.article.ArticleBase;
import dkGithup2022.multimodule.model.model.article.ArticleIdentity;

import java.util.List;

public interface ChildArticleReaderBase<T extends ArticleBase> extends ArticleReaderBase<T> {
    List<T> readByParentId(ArticleIdentity parentIdentity);
}