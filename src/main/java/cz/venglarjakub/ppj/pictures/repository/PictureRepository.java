package cz.venglarjakub.ppj.pictures.repository;

import cz.venglarjakub.ppj.pictures.domain.Picture;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

/**
 * Created by Jakub Venglar on 2. 5. 2016.
 */
public interface PictureRepository {

    public List<Picture> findAll();

    public Picture findById(Integer id);

    @Modifying
    public Picture save(Picture picture);

    @Modifying
    public void delete(Integer id);

}
