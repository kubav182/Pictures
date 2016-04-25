package cz.venglarjakub.ppj.pictures.service;

import cz.venglarjakub.ppj.pictures.repository.CommentJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by kuba on 25. 4. 2016.
 */
@Transactional
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentJpaRepository commentJpaRepository;

    @Override
    public int like() {
        return 0;
    }

    @Override
    public int dislike() {
        return 0;
    }
}
