package com.ultimatesoftware.integrationservices.Queries.model;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IntegrationRepository extends MongoRepository<IntegrationEntity, String> {
    public List<IntegrationEntity> findByPartner(String partner);
    public List<IntegrationEntity> findByTenantId(String tenantId);
    public List<IntegrationEntity> findByTenantIdAndPartner(String tenantId, String partner);
}
