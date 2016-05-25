package cz.venglarjakub.ppj.pictures.service;

import cz.venglarjakub.ppj.pictures.Application;
import cz.venglarjakub.ppj.pictures.domain.Author;
import cz.venglarjakub.ppj.pictures.domain.Comment;
import cz.venglarjakub.ppj.pictures.domain.Picture;
import cz.venglarjakub.ppj.pictures.domain.Tag;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.InputStream;
import java.net.URL;
import java.util.Date;

/**
 * Created by Jakub Venglar on 2. 5. 2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@ActiveProfiles({"test"})
public class CrudServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(CrudServiceTest.class);

    @Value("${server.contextPath}")
    private String contextPath;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private TagService tagService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private PictureService pictureService;

    @Test
    public void testSavePictureToLocal() throws Exception {
        URL url = new URL("http://www.inf.sgsp.edu.pl/pub/MALUNKI_DUZE/ROZNE_DUZE/zaba.png");
        InputStream is = null;
        try {
            is = url.openStream();
            byte[] imageBytes = IOUtils.toByteArray(is);

            Author author = new Author();
            author.setName("Kuba");
            author.setRegistrationDate(new Date());
            author = authorService.save(author);

            Picture picture = new Picture();
            picture.setAuthor(author);
            picture.setName("obrazek.png");
            picture.setUrl("url");
            picture.setLastUpdate(new Date());
            Picture newPicture = pictureService.save(picture);
            newPicture = pictureService.save(newPicture, imageBytes);
            Assert.assertEquals(contextPath + "/images/" + newPicture.getId() + ".png", newPicture.getUrl());
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }

    @Test
    public void testCrudAuthor() {
        Author author = new Author();
        author.setName("Kuba");
        author.setRegistrationDate(new Date());
        Author newAuthor = authorService.save(author);
        Assert.assertEquals(newAuthor, authorService.getById(newAuthor.getId()));

        newAuthor.setName("Jakub");
        authorService.save(newAuthor);
        Assert.assertEquals("Jakub", authorService.getById(newAuthor.getId()).getName());

        authorService.delete(newAuthor.getId());
        Assert.assertNull(authorService.getById(newAuthor.getId()));
    }

    @Test
    public void testCrudTag() {
        Tag tag = new Tag();
        tag.setName("ovoce");
        Tag newTag = tagService.save(tag);
        Assert.assertEquals(newTag, tagService.getById(newTag.getId()));

        newTag.setName("zelenina");
        tagService.save(newTag);
        Assert.assertEquals("zelenina", tagService.getById(newTag.getId()).getName());

        tagService.delete(newTag.getId());
        Assert.assertNull(tagService.getById(newTag.getId()));
    }

    @Test
    public void testCrudPicture() {
        Author author = new Author();
        author.setName("Kuba");
        author.setRegistrationDate(new Date());
        author = authorService.save(author);

        Picture picture = new Picture();
        picture.setAuthor(author);
        picture.setName("obrazek");
        picture.setUrl("url");
        picture.setLastUpdate(new Date());
        Picture newPicture = pictureService.save(picture);
        Assert.assertEquals(newPicture, pictureService.getById(newPicture.getId()));

        newPicture.setName("olejomalba");
        pictureService.save(newPicture);
        Assert.assertEquals("olejomalba", pictureService.getById(newPicture.getId()).getName());

        pictureService.delete(newPicture.getId());
        Assert.assertNull(pictureService.getById(newPicture.getId()));
    }

    @Test
    public void testCrudComment() {
        Author author = new Author();
        author.setName("Kuba");
        author.setRegistrationDate(new Date());
        author = authorService.save(author);

        Picture picture = new Picture();
        picture.setAuthor(author);
        picture.setName("obrazek");
        picture.setUrl("url");
        picture.setLastUpdate(new Date());
        picture = pictureService.save(picture);

        Comment comment = new Comment();
        comment.setComment("komentuju");
        comment.setAuthor(author);
        comment.setPicture(picture);
        Comment newComment = commentService.save(comment);

        Assert.assertEquals(newComment, commentService.getById(newComment.getId()));

        newComment.setComment("nekomentuju");
        commentService.save(newComment);
        Assert.assertEquals("nekomentuju", commentService.getById(newComment.getId()).getComment());

        commentService.delete(newComment.getId());
        Assert.assertNull(commentService.getById(newComment.getId()));
    }

}