package dkGithup2022.multimodule.model.service.crud.article.reader;

import dkGithup2022.multimodule.infra.repository.article.article.AnnouncementRepository;
import dkGithup2022.multimodule.model.model.article.ArticleIdentity;
import dkGithup2022.multimodule.model.model.article.article.Announcement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AnnouncementReader {
    private final AnnouncementRepository announcementRepository;

    public Announcement read(ArticleIdentity articleIdentity) {
        return announcementRepository.findByIdentity(articleIdentity);
    }
}
