package cz.venglarjakub.ppj.pictures.repository;

import cz.venglarjakub.ppj.pictures.domain.Comment;
import cz.venglarjakub.ppj.pictures.domain.Picture;
import org.springframework.data.jpa.repository.Modifying;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Jakub Venglar on 2. 5. 2016.
 */
public interface CommentRepository {

    public List<Comment> findAll();

    public Comment findById(BigInteger id);

    @Modifying
    public Comment save(Comment comment);

    @Modifying
    public void delete(BigInteger id);

    public List<Comment> findByPicture(Picture picture);

}
