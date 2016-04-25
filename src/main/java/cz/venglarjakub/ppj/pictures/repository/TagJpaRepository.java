package cz.venglarjakub.ppj.pictures.repository;

import cz.venglarjakub.ppj.pictures.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by kuba on 25. 4. 2016.
 */
@Repository
public interface TagJpaRepository extends JpaRepository<Tag, Integer> {
}
