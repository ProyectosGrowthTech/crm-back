package org.crm.crmback.domain.model.invoices;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.*;
import org.crm.crmback.domain.model.products.Product;
import org.crm.crmback.domain.model.services.Service;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "invoices_items")
public class InvoicesItem implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @NotNull
  @Column(name = "invoice_id", nullable = false)
  private Long invoiceId;

  @ManyToOne
  @JoinColumn(name = "service_id")
  private Service service;

  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;

  @NotNull
  @Column(name = "quantity", nullable = false)
  private Integer quantity;
}
