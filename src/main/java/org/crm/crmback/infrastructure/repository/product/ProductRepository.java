package org.crm.crmback.infrastructure.repository.product;

import org.crm.crmback.domain.model.products.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductEntity, Long> {}
