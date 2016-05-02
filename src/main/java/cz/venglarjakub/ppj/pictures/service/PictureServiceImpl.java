package cz.venglarjakub.ppj.pictures.service;

import cz.venglarjakub.ppj.pictures.domain.Picture;
import cz.venglarjakub.ppj.pictures.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by kuba on 25. 4. 2016.
 */
@Transactional
@Service
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PictureRepository pictureRepository;

    @Override
    public int like() {
        return 0;
    }

    @Override
    public int dislike() {
        return 0;
    }

    @Override
    public Picture save(Picture picture) {
        return null;
    }

    @Override
    public Picture update(Picture picture) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Picture> getAll() {
        return null;
    }

    @Override
    public Picture getById(Integer id) {
        return null;
    }
}
