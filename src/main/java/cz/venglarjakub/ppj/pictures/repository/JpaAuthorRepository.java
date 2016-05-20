package cz.venglarjakub.ppj.pictures.repository;

import cz.venglarjakub.ppj.pictures.domain.Author;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

/**
 * Created by kuba on 25. 4. 2016.
 */
@Profile({"prod-mysql", "test"})
@Repository
public interface JpaAuthorRepository extends JpaRepository<Author, BigInteger>, AuthorRepository {

}
