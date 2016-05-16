package cz.venglarjakub.ppj.pictures.rest;

import cz.venglarjakub.ppj.pictures.domain.Comment;
import cz.venglarjakub.ppj.pictures.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Jakub Venglar on 25. 4. 2016.
 */
@RestController
@RequestMapping(value = "/rest", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CommentRestController {

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/comment", method = RequestMethod.GET)
    public List<Comment> getAll() {
        return commentService.getAll();
    }

    @RequestMapping(value = "/comment/{id}", method = RequestMethod.GET)
    public Comment getById(@PathVariable Integer id) {
        return commentService.getById(id);
    }

    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public Comment save(@RequestBody Comment comment) {
        return commentService.save(comment);
    }

    @RequestMapping(value = "/comment/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        commentService.delete(id);
    }

    @RequestMapping(value = "/comment/{id}", method = RequestMethod.PUT)
    public Comment update(@PathVariable Integer id, @RequestBody Comment comment) {
        comment.setId(id);
        return commentService.update(comment);
    }

}
