package cz.venglarjakub.ppj.pictures.service;

import cz.venglarjakub.ppj.pictures.domain.Picture;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by kuba on 25. 4. 2016.
 */
public interface PictureService {

    public int like(BigInteger id);

    public int dislike(BigInteger id);

    public Picture save(Picture picture);

    public Picture update(Picture picture);

    public void delete(BigInteger id);

    public List<Picture> getAll();

    public Picture getById(BigInteger id);

    public Picture getNextById(BigInteger id);

    public Picture getPreviousById(BigInteger id);

}
