package cz.venglarjakub.ppj.pictures.service;

import cz.venglarjakub.ppj.pictures.domain.Author;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by kuba on 25. 4. 2016.
 */
public interface AuthorService {

    public Author save(Author author);

    public Author update(Author author);

    public void delete(BigInteger id);

    public List<Author> getAll();

    public Author getById(BigInteger id);

}
