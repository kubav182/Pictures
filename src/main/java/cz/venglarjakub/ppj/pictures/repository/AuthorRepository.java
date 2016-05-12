package cz.venglarjakub.ppj.pictures.repository;

import cz.venglarjakub.ppj.pictures.domain.Author;
import org.springframework.data.jpa.repository.Modifying;

/**
 * Created by Jakub Venglar on 2. 5. 2016.
 */
public interface AuthorRepository {
    public Author findByName(String name);

    @Modifying
    public Author save(Author author);
}
