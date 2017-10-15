package com.Ultimatesoftware.IntegrationServices.Commands;


import com.Ultimatesoftware.IntegrationServices.Commands.Api.CreateIntegrationCommand;
import com.Ultimatesoftware.IntegrationServices.Commands.Api.IntegrationCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.Date;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@Aggregate
public class Integration {
    @AggregateIdentifier
    private String id;

    private String partner;
    private String name;
    private String category;
    private String fileType;
    private boolean enabled;
    private String fileName;
    private Date lastRun;
    private String tenantId;

    public String getCategory() {
        return category;
    }

    public String getTenantId() {
        return tenantId;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public String getId() {
        return this.id;
    }

    public Date getLastRun() {
        return lastRun;
    }

    public String getName() {
        return name;
    }

    public String getPartner() {
        return this.partner;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public void setLastRun(Date lastRun) {
        this.lastRun = lastRun;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    @SuppressWarnings("unused")
    private Integration(){}

    @CommandHandler
    public Integration(CreateIntegrationCommand command){
        apply(new IntegrationCreatedEvent(command.getIntegrationId(), command.getIntegrationName(), command.getPartner()));
    }

    @EventSourcingHandler
    public void on(IntegrationCreatedEvent event){
        this.id = event.getIntegrationId();
        this.name = event.getIntegrationName();
        this.partner = event.getPartner();
    }
}