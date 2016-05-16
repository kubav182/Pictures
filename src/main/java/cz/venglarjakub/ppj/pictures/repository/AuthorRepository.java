package cz.venglarjakub.ppj.pictures.repository;

import cz.venglarjakub.ppj.pictures.domain.Author;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

/**
 * Created by Jakub Venglar on 2. 5. 2016.
 */
public interface AuthorRepository {

    public Author findByName(String name);

    public List<Author> findAll();

    public Author findById(Integer id);

    @Modifying
    public Author save(Author author);

    @Modifying
    public void delete(Integer id);

}
