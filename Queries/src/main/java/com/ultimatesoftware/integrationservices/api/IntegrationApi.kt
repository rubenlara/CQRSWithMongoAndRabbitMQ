package com.ultimatesoftware.integrationservices.api

import lombok.NoArgsConstructor

class IntegrationCreatedEvent(val integrationId: String, val integrationName: String, val partner: String){
    constructor() : this("", "", "")
}