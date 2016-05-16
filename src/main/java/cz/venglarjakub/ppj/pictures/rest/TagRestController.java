package cz.venglarjakub.ppj.pictures.rest;

import cz.venglarjakub.ppj.pictures.domain.Tag;
import cz.venglarjakub.ppj.pictures.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Jakub Venglar on 25. 4. 2016.
 */
@RestController
@RequestMapping(value = "/rest", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TagRestController {

    @Autowired
    private TagService tagService;

    @RequestMapping(value = "/tag", method = RequestMethod.GET)
    public List<Tag> getAll() {
        return tagService.getAll();
    }

    @RequestMapping(value = "/tag/{id}", method = RequestMethod.GET)
    public Tag getById(@PathVariable Integer id) {
        return tagService.getById(id);
    }

    @RequestMapping(value = "/tag", method = RequestMethod.POST)
    public Tag save(@RequestBody Tag tag) {
        return tagService.save(tag);
    }

    @RequestMapping(value = "/tag/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        tagService.delete(id);
    }

    @RequestMapping(value = "/tag/{id}", method = RequestMethod.PUT)
    public Tag update(@PathVariable Integer id, @RequestBody Tag tag) {
        tag.setId(id);
        return tagService.update(tag);
    }
    
}
