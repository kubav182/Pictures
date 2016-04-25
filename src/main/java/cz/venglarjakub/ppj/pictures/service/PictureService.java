package cz.venglarjakub.ppj.pictures.service;

import cz.venglarjakub.ppj.pictures.domain.Picture;

import java.util.List;

/**
 * Created by kuba on 25. 4. 2016.
 */
public interface PictureService {

    public int like();

    public int dislike();

    public Picture save(Picture picture);

    public Picture update(Picture picture);

    public void delete(Integer id);

    public List<Picture> getAll();

    public Picture getById(Integer id);

}
