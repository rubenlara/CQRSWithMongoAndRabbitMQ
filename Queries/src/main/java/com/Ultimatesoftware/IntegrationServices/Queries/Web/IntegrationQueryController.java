package com.Ultimatesoftware.IntegrationServices.Queries.Web;

import com.Ultimatesoftware.IntegrationServices.Queries.Api.IntegrationCreatedEvent;
import com.Ultimatesoftware.IntegrationServices.Queries.model.IntegrationEntity;
import com.Ultimatesoftware.IntegrationServices.Queries.model.IntegrationRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.config.ProcessingGroup;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@ProcessingGroup("Integration")
@RestController
@RequestMapping(value = "/integrationQueries")
public class IntegrationQueryController {

    private final CommandGateway commandGateway;
    private final IntegrationRepository integrationRepository;

    public IntegrationQueryController(CommandGateway commandGateway, IntegrationRepository integrationRepository){
        this.commandGateway = commandGateway;
        this.integrationRepository = integrationRepository;
    }

    @GetMapping
    public Iterable<IntegrationEntity> all() { return integrationRepository.findAll(); }
}
