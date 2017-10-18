package com.ultimatesoftware.integrationservices.Commands.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.axonframework.eventsourcing.eventstore.EventStorageEngine;
import org.axonframework.mongo.eventsourcing.eventstore.DefaultMongoTemplate;
import org.axonframework.mongo.eventsourcing.eventstore.MongoEventStorageEngine;
import org.axonframework.mongo.eventsourcing.eventstore.MongoTemplate;
import org.axonframework.mongo.eventsourcing.eventstore.documentperevent.DocumentPerEventStorageStrategy;
import org.axonframework.serialization.Serializer;
import org.axonframework.serialization.json.JacksonSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class AxonConfig {

    @Value("${mongodb.default.uri}")
    private String mongohost;

    @Value("${mongodb.default.databaseName}")
    private String mongoDbName;

    @Value("${mongodb.events.collection.name}")
    private String eventsCollectionName;

    @Value("${mongodb.events.snapshot.collection.name}")
    private String snapshotCollectionName;

    @Autowired
    private Environment environment;

    @Bean
    public Serializer axonJsonSerializer() {
        return new JacksonSerializer();
    }


    @Bean
    public EventStorageEngine eventStorageEngine(){
//        Map<String, Object> map = new HashMap();
//        for(Iterator it = ((AbstractEnvironment) environment).getPropertySources().iterator(); it.hasNext(); ) {
//            PropertySource propertySource = (PropertySource) it.next();
//            if (propertySource instanceof MapPropertySource) {
//                map.putAll(((MapPropertySource) propertySource).getSource());
//            }
//        }
//        System.out.println(map);
        return new MongoEventStorageEngine(
                axonJsonSerializer(),null, axonMongoTemplate(), new DocumentPerEventStorageStrategy());
    }

    @Bean(name = "axonMongoTemplate")
    public MongoTemplate axonMongoTemplate() {
        MongoTemplate template = new DefaultMongoTemplate(mongoClient(), mongoDbName, "domainevents", "snapshotevents");
        return template;
    }

    @Bean
    public MongoClient mongoClient(){
        MongoClientURI uri = new MongoClientURI(mongohost);
        return new MongoClient(uri);
    }
}
