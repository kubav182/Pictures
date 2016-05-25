package cz.venglarjakub.ppj.pictures.service;

import cz.venglarjakub.ppj.pictures.domain.Comment;
import cz.venglarjakub.ppj.pictures.domain.Picture;
import cz.venglarjakub.ppj.pictures.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by kuba on 25. 4. 2016.
 */
@Transactional
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public int like(BigInteger id) {
        Comment comment = commentRepository.findOne(id);
        if (comment != null) {
            int likes = comment.getLikes() + 1;
            comment.setLikes(likes);
            commentRepository.save(comment);
            return likes;
        } else {
            return -1;
        }
    }

    @Override
    public int dislike(BigInteger id) {
        Comment comment = commentRepository.findOne(id);
        if (comment != null) {
            int dislikes = comment.getDislikes() + 1;
            comment.setDislikes(dislikes);
            commentRepository.save(comment);
            return dislikes;
        } else {
            return -1;
        }
    }

    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment update(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public void delete(BigInteger id) {
        commentRepository.delete(id);
    }

    @Override
    public List<Comment> getAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment getById(BigInteger id) {
        return commentRepository.findOne(id);
    }

    @Override
    public List<Comment> getByPicture(Picture picture) {
        return commentRepository.findByPicture(picture);
    }
}
