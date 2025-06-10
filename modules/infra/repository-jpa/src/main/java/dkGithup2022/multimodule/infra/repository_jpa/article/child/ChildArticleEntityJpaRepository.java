package dkGithup2022.multimodule.infra.repository_jpa.article.child;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChildArticleEntityJpaRepository extends JpaRepository<ChildArticleEntity, Long> {

    List<ChildArticleEntity> findByParentId(Long parentId);
}
