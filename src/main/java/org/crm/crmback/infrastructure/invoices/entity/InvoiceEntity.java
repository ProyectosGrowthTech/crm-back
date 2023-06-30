package org.crm.crmback.infrastructure.invoices.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.*;
import lombok.*;
import org.crm.crmback.infrastructure.invoicesstakeholders.InvoicesStakeholderEntity;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "invoices")
public class InvoiceEntity implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "invoice_date")
  private Date invoiceDate;

  @Column(name = "total_amount")
  private BigDecimal totalAmount;

  @Column(name = "status")
  private String status;

  @Column(name = "modified_by")
  private Long modifiedBy;

  @OneToMany(mappedBy = "invoice")
  private Set<InvoicesStakeholderEntity> invoicesStakeholders = new LinkedHashSet<>();
}
