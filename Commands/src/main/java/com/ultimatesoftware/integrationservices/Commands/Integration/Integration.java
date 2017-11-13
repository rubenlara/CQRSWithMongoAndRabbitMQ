package com.ultimatesoftware.integrationservices.Commands.Integration;

import com.ultimatesoftware.integrationservices.api.CreateIntegrationCommand;
import com.ultimatesoftware.integrationservices.api.IntegrationCreatedEvent;
import com.ultimatesoftware.integrationservices.api.IntegrationUpdatedEvent;
import com.ultimatesoftware.integrationservices.api.UpdateIntegrationCommand;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.Date;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@Aggregate
@NoArgsConstructor
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

    @CommandHandler
    public Integration(CreateIntegrationCommand command){
        System.out.println("Create handler been called");
        apply(new IntegrationCreatedEvent(command.getIntegrationId(), command.getIntegrationName(), command.getPartner()));
    }

    @EventSourcingHandler
    public void on(IntegrationCreatedEvent event){
        this.id = event.getIntegrationId();
        this.name = event.getIntegrationName();
        this.partner = event.getPartner();
    }

    @CommandHandler
    public void handleUpdate(UpdateIntegrationCommand command){
        System.out.println("Update handler been called");
        apply(new IntegrationUpdatedEvent(command.getIntegrationId(), command.getIntegrationName()));
    }

    @EventSourcingHandler
    public void onUpdatedEvent(IntegrationUpdatedEvent event){
        this.name = event.getIntegrationName();
    }
}