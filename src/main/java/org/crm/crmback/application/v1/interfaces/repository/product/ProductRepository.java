package org.crm.crmback.application.v1.interfaces.repository.product;

import java.util.List;
import org.crm.crmback.domain.model.products.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
  List<Product> findAll(Pageable pageable);
}
