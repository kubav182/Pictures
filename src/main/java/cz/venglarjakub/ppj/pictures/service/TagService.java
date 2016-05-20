package cz.venglarjakub.ppj.pictures.service;


import cz.venglarjakub.ppj.pictures.domain.Picture;
import cz.venglarjakub.ppj.pictures.domain.Tag;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by kuba on 25. 4. 2016.
 */
public interface TagService {

    public Tag save(Tag tag);

    public Tag update(Tag tag);

    public void delete(BigInteger id);

    public List<Tag> getAll();

    public Tag getById(BigInteger id);

    public List<Tag> getByPicture(Picture picture);

}
