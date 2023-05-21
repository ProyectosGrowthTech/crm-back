package org.crm.crmback.infrastructure.invoicesstakeholders;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.*;
import org.crm.crmback.infrastructure.invoices.entity.InvoiceEntity;
import org.crm.crmback.infrastructure.stakeholders.StakeholderEntity;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "invoices_stakeholders")
public class InvoicesStakeholderEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @NotNull
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "invoice_id", nullable = false)
  private InvoiceEntity invoice;

  @NotNull
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "stakeholder_id", nullable = false)
  private StakeholderEntity stakeholder;
}
