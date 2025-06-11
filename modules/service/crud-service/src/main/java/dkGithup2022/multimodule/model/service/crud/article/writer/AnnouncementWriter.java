package dkGithup2022.multimodule.model.service.crud.article.writer;

import dkGithup2022.multimodule.infra.repository.article.article.AnnouncementRepository;
import dkGithup2022.multimodule.model.model.article.article.Announcement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnnouncementWriter implements ArticleWriterBase<Announcement> {
    private final AnnouncementRepository announcementRepository;
    //private final ArticleEventWriter eventWriter;
    @Override
    public Announcement write(Announcement article) {
        return announcementRepository.save(article);
    }
}
