package cz.venglarjakub.ppj.pictures.repository;

import cz.venglarjakub.ppj.pictures.domain.Comment;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

/**
 * Created by Jakub Venglar on 2. 5. 2016.
 */
public interface CommentRepository {

    public List<Comment> findAll();

    public Comment findById(Integer id);

    @Modifying
    public Comment save(Comment comment);

    @Modifying
    public void delete(Integer id);

}
