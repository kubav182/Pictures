package cz.venglarjakub.ppj.pictures.configuration;

import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.test.ImportAutoConfiguration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by Jakub Venglar on 20. 5. 2016.
 */
@Profile("prod-mongo")
@ImportAutoConfiguration({
        MongoAutoConfiguration.class,
        MongoDataAutoConfiguration.class,
        MongoRepositoriesAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class,
        DataSourceAutoConfiguration.class})
@EnableMongoRepositories(basePackages = "cz.venglarjakub.ppj.pictures.repository")
public class MongoConfig {
}
