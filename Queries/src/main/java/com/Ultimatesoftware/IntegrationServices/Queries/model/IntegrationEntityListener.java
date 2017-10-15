package com.Ultimatesoftware.IntegrationServices.Queries.model;

import com.Ultimatesoftware.IntegrationServices.Queries.Api.IntegrationCreatedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Console;

@Component
public class IntegrationEntityListener {

    private IntegrationRepository repository;

    @Autowired
    public IntegrationEntityListener(IntegrationRepository repository){
        this.repository = repository;
    }

    @EventHandler
    public void on(IntegrationCreatedEvent event){
        repository.save(new IntegrationEntity(event.getIntegrationId(), event.getIntegrationName(), event.getPartner()));
    }
}
