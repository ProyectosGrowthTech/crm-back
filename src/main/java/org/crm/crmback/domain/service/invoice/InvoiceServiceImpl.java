package org.crm.crmback.domain.service.invoice;

import lombok.RequiredArgsConstructor;
import org.crm.crmback.domain.exception.UserAlreadyExistsException;
import org.crm.crmback.domain.model.invoices.Invoice;
import org.crm.crmback.domain.model.invoices.NewInvoiceData;
import org.crm.crmback.domain.model.security.NewUserData;
import org.crm.crmback.domain.model.security.User;
import org.crm.crmback.domain.service.user.UserService;
import org.crm.crmback.infrastructure.hash.HashFacade;
import org.crm.crmback.infrastructure.invoices.entity.InvoiceEntity;
import org.crm.crmback.infrastructure.invoices.facade.InvoicePersistenceFacade;
import org.crm.crmback.infrastructure.rdbms.entity.Role;
import org.crm.crmback.infrastructure.rdbms.facade.UserPersistenceFacade;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

  private final HashFacade hashFacade;

  private final InvoicePersistenceFacade invoicePersistenceFacade;

  @Override
  public Invoice createInvoice(NewInvoiceData newInvoiceData) {
    //TODO: Implement logic business to check if invoice already exists, that customer exists, etc.
    Invoice newInvoice =
        Invoice.builder()
            .customerId(newInvoiceData.customerId())
            .invoiceDate(newInvoiceData.invoiceDate())
            .totalAmount(newInvoiceData.totalAmount())
            .status(newInvoiceData.status())
            .build();
    Invoice resultInvoice = invoicePersistenceFacade.save(newInvoice);
    return resultInvoice;
  }
}
