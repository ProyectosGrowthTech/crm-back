package org.crm.crmback.infrastructure.invoicesitems;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.*;
import org.crm.crmback.infrastructure.products.ProductEntity;
import org.crm.crmback.infrastructure.services.ServiceEntity;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "invoices_items")
public class InvoicesItemEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @NotNull
  @Column(name = "invoice_id", nullable = false)
  private Long invoiceId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "service_id")
  private ServiceEntity service;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "product_id")
  private ProductEntity product;

  @NotNull
  @Column(name = "quantity", nullable = false)
  private Integer quantity;
}
