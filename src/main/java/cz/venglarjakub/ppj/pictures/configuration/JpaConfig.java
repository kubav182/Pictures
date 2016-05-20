package cz.venglarjakub.ppj.pictures.configuration;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.test.ImportAutoConfiguration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by Jakub Venglar on 20. 5. 2016.
 */

@Profile({"prod-mysql", "test"})
@ImportAutoConfiguration({
        HibernateJpaAutoConfiguration.class,
        DataSourceAutoConfiguration.class,
        JpaRepositoriesAutoConfiguration.class
})
@EnableJpaRepositories(basePackages = "cz.venglarjakub.ppj.pictures.repository")
public class JpaConfig {
}
