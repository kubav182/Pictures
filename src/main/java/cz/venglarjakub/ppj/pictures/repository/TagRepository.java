package cz.venglarjakub.ppj.pictures.repository;

import cz.venglarjakub.ppj.pictures.domain.Tag;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

/**
 * Created by Jakub Venglar on 2. 5. 2016.
 */
public interface TagRepository {

    public List<Tag> findAll();

    public Tag findById(Integer id);

    @Modifying
    public Tag save(Tag tag);

    @Modifying
    public void delete(Integer id);

}
