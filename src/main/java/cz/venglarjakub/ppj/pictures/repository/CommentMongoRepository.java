package cz.venglarjakub.ppj.pictures.repository;

import cz.venglarjakub.ppj.pictures.domain.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Jakub Venglar on 25. 4. 2016.
 */
@Repository
public interface CommentMongoRepository extends MongoRepository<Comment, Integer> {
}
