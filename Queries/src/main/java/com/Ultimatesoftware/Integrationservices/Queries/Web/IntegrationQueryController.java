package com.Ultimatesoftware.Integrationservices.Queries.Web;

import com.Ultimatesoftware.Integrationservices.Queries.model.IntegrationEntity;
import com.Ultimatesoftware.Integrationservices.Queries.model.IntegrationRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/integrationQueries")
public class IntegrationQueryController {

    private final IntegrationRepository integrationRepository;

    public IntegrationQueryController(IntegrationRepository integrationRepository){
        this.integrationRepository = integrationRepository;
    }

    @GetMapping
    public Iterable<IntegrationEntity> all() { return integrationRepository.findAll(); }
}
