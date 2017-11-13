package com.ultimatesoftware.integrationservices.api;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

class CreateIntegrationCommand(@TargetAggregateIdentifier val integrationId: String, val integrationName: String, val partner: String)

class IntegrationCreatedEvent(val integrationId: String, val integrationName: String, val partner: String)

class UpdateIntegrationCommand(@TargetAggregateIdentifier val integrationId: String, val integrationName: String)
class IntegrationUpdatedEvent(integrationId: String, val integrationName: String)