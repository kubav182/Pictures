package cz.venglarjakub.ppj.pictures.repository;

import cz.venglarjakub.ppj.pictures.domain.Tag;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by kuba on 25. 4. 2016.
 */
@Profile("PROD_MYSQL")
@Repository
public interface JpaTagRepository extends JpaRepository<Tag, Integer>, TagRepository {
}
