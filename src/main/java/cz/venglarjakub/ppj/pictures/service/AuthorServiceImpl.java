package cz.venglarjakub.ppj.pictures.service;

import cz.venglarjakub.ppj.pictures.domain.Author;
import cz.venglarjakub.ppj.pictures.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Jakub Venglar on 25. 4. 2016.
 */
@Transactional
@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author update(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void delete(BigInteger id) {
        authorRepository.delete(id);
    }

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author getById(BigInteger id) {
        return authorRepository.findById(id);
    }
}
