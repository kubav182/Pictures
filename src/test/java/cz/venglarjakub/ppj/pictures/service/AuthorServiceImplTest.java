package cz.venglarjakub.ppj.pictures.service;

import cz.venglarjakub.ppj.pictures.Application;
import cz.venglarjakub.ppj.pictures.domain.Author;
import cz.venglarjakub.ppj.pictures.domain.Picture;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Created by Jakub Venglar on 2. 5. 2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@ActiveProfiles({"test"})
public class AuthorServiceImplTest {

    private static final Logger logger = LoggerFactory.getLogger(AuthorServiceImplTest.class);

    @Autowired
    private AuthorService authorService;

    @Autowired
    private PictureService pictureService;

    @Test
    public void testSave() throws Exception {
        Author author = new Author();
        author.setName("kuba");
        author.setRegistrationDate(new Date());
        author = authorService.save(author);
        Assert.assertEquals(authorService.getAll().size(), 1);

        Picture picture = new Picture();
        picture.setName("obrazek");
        picture.setAuthor(author);
        picture.setLastUpdate(new Date());
        pictureService.save(picture);
        Assert.assertEquals(pictureService.getAll().size(), 1);

        authorService.delete(author.getId());
        Assert.assertEquals(authorService.getAll().size(), 0);
        Assert.assertEquals(pictureService.getAll().size(), 0);

    }
}