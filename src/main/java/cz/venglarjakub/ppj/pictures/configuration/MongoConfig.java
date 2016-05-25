package cz.venglarjakub.ppj.pictures.configuration;

import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.test.ImportAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.integration.transaction.PseudoTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * Created by Jakub Venglar on 20. 5. 2016.
 */
@Profile("prod-mongo")
@ImportAutoConfiguration({
        MongoAutoConfiguration.class,
        MongoDataAutoConfiguration.class,
        MongoRepositoriesAutoConfiguration.class})
@EnableMongoRepositories(basePackages = "cz.venglarjakub.ppj.pictures.repository")
public class MongoConfig {

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new PseudoTransactionManager();
    }

}
