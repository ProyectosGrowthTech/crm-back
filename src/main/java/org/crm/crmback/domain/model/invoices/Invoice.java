package org.crm.crmback.domain.model.invoices;

import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@Table(name = "invoices")
public class Invoice {
    private Long id;

    private Long customerId;

    private Date invoiceDate;

    private BigDecimal totalAmount;

    private String status;

    private Long modifiedBy;
}
