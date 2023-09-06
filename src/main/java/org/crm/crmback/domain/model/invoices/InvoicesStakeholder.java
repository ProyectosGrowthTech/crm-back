package org.crm.crmback.domain.model.invoices;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.*;
import org.crm.crmback.domain.model.stakeholders.Stakeholder;

@Entity
@Table(name = "invoices_stakeholders")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class InvoicesStakeholder implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @NotNull
  @JsonBackReference
  @ManyToOne(optional = false)
  @JoinColumn(name = "invoice_id", nullable = false)
  private Invoice invoice;

  @NotNull
  @ManyToOne(optional = false)
  @JoinColumn(name = "stakeholder_id", nullable = false)
  private Stakeholder stakeholder;
}
