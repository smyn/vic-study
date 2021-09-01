package com.vic.spring.pdf.receipt;

import com.vic.spring.pdf.model.Receipt;
import com.vic.spring.pdf.repository.ReceiptRepository;
import org.thymeleaf.TemplateEngine;

public interface ReceiptInterface {

    byte[] createTemplate(Receipt receiptInfo, TemplateEngine templateEngine);
    Receipt getReceiptInfo(ReceiptRepository receiptRepository);

}
