package org.crm.crmback.application.v1.repository.product;

import org.crm.crmback.domain.model.products.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {}
