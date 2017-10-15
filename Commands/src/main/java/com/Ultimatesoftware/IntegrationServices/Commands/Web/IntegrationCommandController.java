package com.Ultimatesoftware.IntegrationServices.Commands.Web;

import com.Ultimatesoftware.IntegrationServices.Commands.Api.CreateIntegrationCommand;
import com.rabbitmq.client.Command;
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
        return commandGateway.send(new CreateIntegrationCommand(request.get("integrationid"),
                request.get("integrationName"), request.get("partner")));
    }
}
