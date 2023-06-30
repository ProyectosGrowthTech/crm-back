package org.crm.crmback.domain.model.invoices;

import java.math.BigDecimal;
import java.util.Date;

public record NewInvoiceData(
     Date invoiceDate, BigDecimal totalAmount, String status) {}