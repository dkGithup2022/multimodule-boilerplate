package dkGithup2022.multimodule.model.service.crud.article.reader;


import dkGithup2022.multimodule.infra.repository.article.article.FreeBoardRepository;
import dkGithup2022.multimodule.model.model.article.ArticleIdentity;
import dkGithup2022.multimodule.model.model.article.article.FreeBoard;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FreeBoardReader implements ArticleReaderBase<FreeBoard> {
    private final FreeBoardRepository freeBoardRepository;

    public FreeBoard read(ArticleIdentity articleIdentity) {
        return freeBoardRepository.findByIdentity(articleIdentity);
    }
}
