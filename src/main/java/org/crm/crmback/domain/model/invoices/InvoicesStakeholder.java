package org.crm.crmback.domain.model.invoices;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.*;
import org.crm.crmback.domain.model.stakeholders.Stakeholder;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "invoices_stakeholders")
public class InvoicesStakeholder implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @NotNull
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "invoice_id", nullable = false)
  private Invoice invoice;

  @NotNull
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "stakeholder_id", nullable = false)
  private Stakeholder stakeholder;
}
