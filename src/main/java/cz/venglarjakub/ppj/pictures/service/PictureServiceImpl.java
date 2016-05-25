package cz.venglarjakub.ppj.pictures.service;

import cz.venglarjakub.ppj.pictures.domain.Picture;
import cz.venglarjakub.ppj.pictures.repository.PictureRepository;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by kuba on 25. 4. 2016.
 */
@Transactional
@Service
public class PictureServiceImpl implements PictureService {

    private static final Logger logger = LoggerFactory.getLogger(PictureServiceImpl.class);

    @Autowired
    private PictureRepository pictureRepository;

    @Value("${server.contextPath}")
    private String contextPath;

    @Value("${cz.venglarjakub.ppj.pictures.web.image-dir}")
    private String imageDir;

    @Override
    public int like(BigInteger id) {
        Picture picture = pictureRepository.findOne(id);
        if (picture != null) {
            int likes = picture.getLikes() + 1;
            picture.setLikes(likes);
            pictureRepository.save(picture);
            return likes;
        } else {
            return -1;
        }
    }

    @Override
    public int dislike(BigInteger id) {
        Picture picture = pictureRepository.findOne(id);
        if (picture != null) {
            int dislikes = picture.getDislikes() + 1;
            picture.setDislikes(dislikes);
            pictureRepository.save(picture);
            return dislikes;
        } else {
            return -1;
        }
    }

    @Override
    public Picture save(Picture picture) {
        return pictureRepository.save(picture);
    }

    @Override
    public Picture save(Picture picture, byte[] image) {
        try {
            String ext = FilenameUtils.getExtension(picture.getName());
            String imagePath = imageDir + "/" + picture.getId() + "." + ext;
            FileUtils.writeByteArrayToFile(new File(imagePath), image);
            picture.setUrl(contextPath + "/images/" + picture.getId() + "." + ext);
            pictureRepository.save(picture);
        } catch (IOException ex) {
            logger.error("obrazek nelze ulozit ", ex);
        }

        return picture;
    }

    @Override
    public Picture update(Picture picture) {
        return pictureRepository.save(picture);
    }

    @Override
    public void delete(BigInteger id) {
        pictureRepository.delete(id);
    }

    @Override
    public List<Picture> getAll() {
        return pictureRepository.findAll();
    }

    @Override
    public Picture getById(BigInteger id) {
        return pictureRepository.findOne(id);
    }

    @Override
    public Picture getNextById(BigInteger id) {
        return pictureRepository.findFirstByIdGreaterThan(id);
    }

    @Override
    public Picture getPreviousById(BigInteger id) {
        return pictureRepository.findFirstByIdLessThanOrderByIdDesc(id);
    }
}
