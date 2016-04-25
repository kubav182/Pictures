package cz.venglarjakub.ppj.pictures.service;


import cz.venglarjakub.ppj.pictures.domain.Tag;

import java.util.List;

/**
 * Created by kuba on 25. 4. 2016.
 */
public interface TagService {

    public Tag save(Tag tag);

    public Tag update(Tag tag);

    public void delete(Integer id);

    public List<Tag> getAll();

    public Tag getById(Integer id);

}
