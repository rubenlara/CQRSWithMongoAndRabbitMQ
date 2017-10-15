package com.Ultimatesoftware.Integrationservices.Queries.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class IntegrationEntity {
    @Id
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

    public IntegrationEntity(){

    }

    public IntegrationEntity(String integrationId, String integrationName, String partner){
        this.id = integrationId;
        this.name = integrationName;
        this.partner = partner;
    }
}
