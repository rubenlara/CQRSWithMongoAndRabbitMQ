package com.ultimatesoftware.integrationservices.Queries;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

public class SpringMongoConfig extends AbstractMongoConfiguration {
    @Value("${spring.data.mongodb.port}")
    private String mongoPort;

    @Value("${spring.data.mongodb.database}")
    private String mongoDB;

    @Value("${spring.data.mongodb.host}")
    private String mongoHost;

    @Override
    public MongoMappingContext mongoMappingContext()
            throws ClassNotFoundException {
        // TODO Auto-generated method stub
        return super.mongoMappingContext();
    }

    @Override
    protected String getDatabaseName() {
        return mongoDB;
    }

    @Override
    @Bean
    public Mongo mongo() throws Exception {
        return new MongoClient(mongoHost + ":" + mongoPort);
    }
}
