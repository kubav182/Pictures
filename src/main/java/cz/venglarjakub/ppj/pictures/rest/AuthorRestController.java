package cz.venglarjakub.ppj.pictures.rest;

import cz.venglarjakub.ppj.pictures.domain.Author;
import cz.venglarjakub.ppj.pictures.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Jakub Venglar on 25. 4. 2016.
 */
@RestController
@RequestMapping(value = "/rest", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AuthorRestController {

    @Autowired
    private AuthorService authorService;

    @RequestMapping(value = "/author", method = RequestMethod.GET)
    public List<Author> getAll() {
        return authorService.getAll();
    }

    @RequestMapping(value = "/author/{id}", method = RequestMethod.GET)
    public Author getById(@PathVariable Integer id) {
        return authorService.getById(id);
    }

    @RequestMapping(value = "/author", method = RequestMethod.POST)
    public Author save(@RequestBody Author author) {
        return authorService.save(author);
    }

    @RequestMapping(value = "/author/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        authorService.delete(id);
    }

    @RequestMapping(value = "/author/{id}", method = RequestMethod.PUT)
    public Author update(@PathVariable Integer id, @RequestBody Author author) {
        author.setId(id);
        return authorService.update(author);
    }

}
