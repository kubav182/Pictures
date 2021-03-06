package cz.venglarjakub.ppj.pictures.repository;

import cz.venglarjakub.ppj.pictures.domain.Tag;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

/**
 * Created by Jakub Venglar on 25. 4. 2016.
 */
@Profile("prod-mongo")
@Repository
public interface MongoTagRepository extends MongoRepository<Tag, BigInteger>, TagRepository {
}
