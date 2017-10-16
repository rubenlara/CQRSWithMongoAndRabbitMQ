package com.ultimatesoftware.integrationservices.Queries.model;

import com.ultimatesoftware.integrationservices.api.IntegrationCreatedEvent;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@ProcessingGroup("Integration")
@Component
public class IntegrationEntityListener {

    private IntegrationRepository repository;

    public IntegrationEntityListener(){

    }

    @Autowired
    public IntegrationEntityListener(IntegrationRepository repository){
        this.repository = repository;
    }

    @EventHandler
    public void on(IntegrationCreatedEvent event){
        System.out.println("Event been raised.");
        repository.save(new IntegrationEntity(event.getIntegrationId(), event.getIntegrationName(), event.getPartner()));
    }
}
