package org.crm.crmback.domain.model.invoices;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "invoice_types", schema = "crm")
public class InvoiceType implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Size(max = 255)
  @NotNull
  @Column(name = "description", nullable = false)
  private String description;

  @OneToMany(mappedBy = "invoiceType")
  @JsonBackReference
  private Set<Invoice> invoices = new LinkedHashSet<>();
}
