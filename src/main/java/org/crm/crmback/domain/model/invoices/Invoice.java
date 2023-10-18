package org.crm.crmback.domain.model.invoices;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.Set;
import javax.persistence.*;
import lombok.*;
import org.crm.crmback.infrastructure.rdbms.entity.UserEntity;

@Entity
@Table(name = "invoices")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Invoice implements Serializable {
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

  @ManyToOne
  @JoinColumn(name = "modified_by")
  private UserEntity modifiedBy;

  @OneToMany(mappedBy = "invoice")
  private Set<InvoicesStakeholder> invoicesStakeholders;

  @Column(name = "created_at")
  private Instant createdAt;

  @Column(name = "updated_at")
  private Instant updatedAt;

  @ManyToOne
  @JoinColumn(name = "invoice_type_id")
  @JsonIgnore
  private InvoiceType invoiceType;

  // Create a method to get the description from InvoiceType
  @JsonProperty("invoiceType")
  public String getInvoiceTypeDescription() {
    return invoiceType != null ? invoiceType.getDescription() : null;
  }
}
