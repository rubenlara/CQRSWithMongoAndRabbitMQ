package com.Ultimatesoftware.Integrationservices.Commands.Web;

import com.Ultimatesoftware.Integrationservices.Api.CreateIntegrationCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/integrationCommands")
public class IntegrationCommandController {

    private final CommandGateway commandGateway;

    public IntegrationCommandController(CommandGateway commandGateway){
        this.commandGateway = commandGateway;
    }
    @PostMapping
    public CompletableFuture<String> CreateIntegration(@RequestBody Map<String, String> request){
        return commandGateway.send(new CreateIntegrationCommand(request.get("integrationId"),
                request.get("integrationName"), request.get("partner")));
    }
}
