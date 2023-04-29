package org.crm.crmback.domain.model.invoices;

import java.math.BigDecimal;
import java.util.Date;

public record NewInvoiceData(
    Long customerId, Date invoiceDate, BigDecimal totalAmount, String status) {}
