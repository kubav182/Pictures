package cz.venglarjakub.ppj.pictures.repository;

import cz.venglarjakub.ppj.pictures.domain.Picture;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Jakub Venglar on 25. 4. 2016.
 */
@Profile("prod-mongo")
@Repository
public interface MongoPictureRepository extends MongoRepository<Picture, Integer>, PictureRepository {
}
