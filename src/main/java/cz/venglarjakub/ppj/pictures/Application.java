package cz.venglarjakub.ppj.pictures;

import cz.venglarjakub.ppj.pictures.configuration.JpaConfig;
import cz.venglarjakub.ppj.pictures.configuration.MongoConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Import;

/**
 * Created by kuba on 11. 4. 2016.
 */
@SpringBootApplication(exclude = {
        MongoAutoConfiguration.class,
        MongoDataAutoConfiguration.class,
        MongoRepositoriesAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class,
        DataSourceAutoConfiguration.class,
        JpaRepositoriesAutoConfiguration.class})
@Import({JpaConfig.class, MongoConfig.class})
@ServletComponentScan(basePackages = "cz.venglarjakub.ppj.pictures.web")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
