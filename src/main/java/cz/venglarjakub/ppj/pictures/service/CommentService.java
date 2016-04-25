package cz.venglarjakub.ppj.pictures.service;

import cz.venglarjakub.ppj.pictures.domain.Comment;

import java.util.List;

/**
 * Created by kuba on 25. 4. 2016.
 */
public interface CommentService {

    public int like();

    public int dislike();

    public Comment save(Comment comment);

    public Comment update(Comment comment);

    public void delete(Integer id);

    public List<Comment> getAll();

    public Comment getById(Integer id);

}
