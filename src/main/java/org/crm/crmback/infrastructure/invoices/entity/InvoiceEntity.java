package org.crm.crmback.infrastructure.invoices.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.*;

import jdk.jfr.Timestamp;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@Table(name = "invoices")
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;

    private Date invoiceDate;

    private BigDecimal totalAmount;

    private String status;

    private Long modifiedBy;
}
