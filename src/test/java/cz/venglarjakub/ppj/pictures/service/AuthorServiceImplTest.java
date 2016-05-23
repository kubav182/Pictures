package cz.venglarjakub.ppj.pictures.service;

import cz.venglarjakub.ppj.pictures.Application;
import cz.venglarjakub.ppj.pictures.domain.Author;
import cz.venglarjakub.ppj.pictures.domain.Comment;
import cz.venglarjakub.ppj.pictures.domain.Picture;
import cz.venglarjakub.ppj.pictures.domain.Tag;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Jakub Venglar on 2. 5. 2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@ActiveProfiles({"test"})
@WebAppConfiguration
@IntegrationTest("server.port:8181")
public class AuthorServiceImplTest {

    private static final Logger logger = LoggerFactory.getLogger(AuthorServiceImplTest.class);

    @Autowired
    private AuthorService authorService;

    @Autowired
    private TagService tagService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private PictureService pictureService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    @Ignore
    public void test() throws Exception {

        mockMvc.perform(get("/rest/picture")).andExpect(status().isOk());

        /*mockMvc.perform(get("/address"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.street").value("12345 Horton Ave"));*/

    }

    @Test
    public void testSave() throws Exception {
        System.out.println();
        tagService.getAll().stream().forEach((t) -> tagService.delete(t.getId()));
        commentService.getAll().stream().forEach((c) -> commentService.delete(c.getId()));
        pictureService.getAll().stream().forEach((p) -> pictureService.delete(p.getId()));
        authorService.getAll().stream().forEach((a) -> authorService.delete(a.getId()));

        for (int i = 0; i < 10; i++) {
            Author author = new Author();
            author.setName("Kuba" + i);
            author.setRegistrationDate(new Date());
            authorService.save(author);
        }
        Tag tag = new Tag(null, "ovoce");
        tagService.save(tag);
        tag = new Tag(null, "zelenina");
        tagService.save(tag);
        tag = new Tag(null, "sport");
        tagService.save(tag);
        tag = new Tag(null, "hrušky");
        tagService.save(tag);
        tag = new Tag(null, "pomeranče");
        tagService.save(tag);

        Picture picture = new Picture();
        picture.setName("1");
        picture.setLastUpdate(new Date());
        picture.setLikes(5);
        picture.setDislikes(3);
        picture.setUrl("http://");
        picture.setAuthor(authorService.getAll().get(0));
        picture.setTagList(tagService.getAll());
        pictureService.save(picture);
        picture = new Picture();
        picture.setName("pastelky");
        picture.setLastUpdate(new Date());
        picture.setLikes(5);
        picture.setDislikes(3);
        picture.setUrl("http://");
        picture.setAuthor(authorService.getAll().get(0));
        picture.setTagList(tagService.getAll());
        pictureService.save(picture);
        picture = new Picture();
        picture.setName("silueta");
        picture.setLastUpdate(new Date());
        picture.setLikes(5);
        picture.setDislikes(3);
        picture.setUrl("http://");
        picture.setAuthor(authorService.getAll().get(0));
        picture.setTagList(tagService.getAll());
        pictureService.save(picture);

        for (Picture p : pictureService.getAll()) {
            logger.info(p + "");
        }
        logger.info("obrazek 0: " + pictureService.getAll().get(0));
        for (int i = 0; i < 4; i++) {
            Comment comment = new Comment();
            comment.setPicture(pictureService.getAll().get(0));
            logger.info("komentar: " + comment.getPicture().getId());
            comment.setComment("Komentar" + i);
            comment.setAuthor(authorService.getAll().get(0));
            comment.setLikes(i + 10);
            comment.setDislikes(i + 5);
            commentService.save(comment);
        }

        logger.info(authorService.getAll().size() + "");
        logger.info(pictureService.getAll().size() + "");
        logger.info(tagService.getAll().size() + "");
        logger.info(commentService.getAll().size() + "");

        /*Author author = new Author();
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
        Assert.assertEquals(pictureService.getAll().size(), 0);*/

    }
}