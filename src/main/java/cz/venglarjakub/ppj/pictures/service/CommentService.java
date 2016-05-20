package cz.venglarjakub.ppj.pictures.service;

import cz.venglarjakub.ppj.pictures.domain.Comment;
import cz.venglarjakub.ppj.pictures.domain.Picture;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by kuba on 25. 4. 2016.
 */
public interface CommentService {

    public int like(BigInteger id);

    public int dislike(BigInteger id);

    public Comment save(Comment comment);

    public Comment update(Comment comment);

    public void delete(BigInteger id);

    public List<Comment> getAll();

    public Comment getById(BigInteger id);

    public List<Comment> getByPicture(Picture picture);

}
