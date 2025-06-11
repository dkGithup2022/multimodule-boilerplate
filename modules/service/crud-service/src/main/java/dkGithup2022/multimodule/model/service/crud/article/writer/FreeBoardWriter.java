package dkGithup2022.multimodule.model.service.crud.article.writer;

import dkGithup2022.multimodule.infra.repository.article.article.FreeBoardRepository;
import dkGithup2022.multimodule.model.model.article.article.FreeBoard;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class FreeBoardWriter implements ArticleWriterBase<FreeBoard> {
    private final FreeBoardRepository freeBoardRepository;
    //private final ArticleEventWriter eventWriter;

    @Override
    public FreeBoard write(FreeBoard article) {
        return freeBoardRepository.save(article);
    }
}
