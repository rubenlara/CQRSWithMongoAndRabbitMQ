package com.ultimatesoftware.integrationservices.Commands.Web;

import com.ultimatesoftware.integrationservices.api.CreateIntegrationCommand;
import com.ultimatesoftware.integrationservices.api.UpdateIntegrationCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
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
        System.out.println("Post called");
        return commandGateway.send(new CreateIntegrationCommand(request.get("integrationId"),
                request.get("integrationName"), request.get("partner")));
    }

    @PutMapping
    public CompletableFuture<String> UpdateIntegration(@RequestBody Map<String, String> request){
        System.out.println("Put called");
        return commandGateway.send(new UpdateIntegrationCommand(request.get("integrationId"),
                request.get("integrationName")));
    }
}
