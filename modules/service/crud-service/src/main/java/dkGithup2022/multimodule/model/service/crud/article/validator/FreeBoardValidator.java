package dkGithup2022.multimodule.model.service.crud.article.validator;

import dkGithup2022.multimodule.infra.repository.article.article.FreeBoardRepository;
import dkGithup2022.multimodule.model.model.article.article.FreeBoard;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FreeBoardValidator implements ArticleValidatorBase<FreeBoard> {
    private final FreeBoardRepository freeBoardRepository;
    @Override
    public void validateRegister(FreeBoard article) {
        /* validate article before upsert!  */
        return;
    }

    @Override
    public void validateUpdate(FreeBoard article) {
        /* validate article before upsert!  */
        return;
    }
}
