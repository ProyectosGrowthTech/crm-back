package org.crm.crmback.application.v1.interfaces.repository.product;

import org.crm.crmback.domain.model.invoices.Invoice;
import org.crm.crmback.domain.model.products.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
  List<Product> findAll(Pageable pageable);
}
