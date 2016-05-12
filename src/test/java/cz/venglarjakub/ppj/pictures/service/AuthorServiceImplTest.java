package cz.venglarjakub.ppj.pictures.service;

import cz.venglarjakub.ppj.pictures.Application;
import cz.venglarjakub.ppj.pictures.domain.Author;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Created by Jakub Venglar on 2. 5. 2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
//@Profile("prod-mysql")
public class AuthorServiceImplTest {

    private static final Logger logger = LoggerFactory.getLogger(AuthorServiceImplTest.class);

    @Autowired
    private AuthorService instance;
    //@Autowired
    //JpaAuthorRepository instance;

    @Test
    public void testSave() throws Exception {
        Author newAuthor = new Author();
        newAuthor.setName("kuba");
        newAuthor.setRegistrationDate(new Date());
        System.out.println(instance.save(newAuthor));
    }
}