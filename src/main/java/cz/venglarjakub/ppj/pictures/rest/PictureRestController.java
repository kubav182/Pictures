package cz.venglarjakub.ppj.pictures.rest;

import cz.venglarjakub.ppj.pictures.domain.Picture;
import cz.venglarjakub.ppj.pictures.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Jakub Venglar on 25. 4. 2016.
 */
@RestController
@RequestMapping(value = "/rest", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PictureRestController {

    @Autowired
    private PictureService pictureService;

    @RequestMapping(value = "/picture", method = RequestMethod.GET)
    public List<Picture> getAll() {
        return pictureService.getAll();
    }

    @RequestMapping(value = "/picture/{id}", method = RequestMethod.GET)
    public Picture getById(@PathVariable Integer id) {
        return pictureService.getById(id);
    }

    @RequestMapping(value = "/picture", method = RequestMethod.POST)
    public Picture save(@RequestBody Picture picture) {
        return pictureService.save(picture);
    }

    @RequestMapping(value = "/picture/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        pictureService.delete(id);
    }

    @RequestMapping(value = "/picture/{id}", method = RequestMethod.PUT)
    public Picture update(@PathVariable Integer id, @RequestBody Picture picture) {
        picture.setId(id);
        return pictureService.update(picture);
    }

}
