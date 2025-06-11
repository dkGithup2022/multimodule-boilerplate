package dkGithup2022.multimodule.model.service.crud.article.validator;

import dkGithup2022.multimodule.infra.repository.article.article.AnnouncementRepository;
import dkGithup2022.multimodule.model.model.article.article.Announcement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AnnouncementValidator implements ArticleValidatorBase<Announcement> {
    private final AnnouncementRepository announcementRepository;

    @Override
    public void validateRegister(Announcement article) {
        /* validate article before upsert!  */
        return;
    }

    @Override
    public void validateUpdate(Announcement article) {
        /* validate article before upsert!  */
        return;
    }
}
