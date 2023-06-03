package org.crm.crmback.domain.model.invoices;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@Table(name = "invoices")
public class Invoice {
  private Long id;

  private Date invoiceDate;

  private BigDecimal totalAmount;

  private String status;
}
