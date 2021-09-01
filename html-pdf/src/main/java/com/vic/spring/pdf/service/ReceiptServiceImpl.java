package com.vic.spring.pdf.service;

import com.vic.spring.pdf.model.Receipt;
import com.vic.spring.pdf.receipt.ReceiptInterface;
import com.vic.spring.pdf.repository.ReceiptRepository;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;

@Service
public class ReceiptServiceImpl implements ReceiptService {

    private final ReceiptRepository receiptRepository;
    private final TemplateEngine templateEngine;

    public ReceiptServiceImpl(ReceiptRepository receiptRepository, TemplateEngine templateEngine) {
        this.receiptRepository = receiptRepository;
        this.templateEngine = templateEngine;
    }

    @Override
    public byte[] getReceipt(ReceiptInterface receiptInterface) {
        Receipt receiptInfo = receiptInterface.getReceiptInfo(receiptRepository);
        receiptInfo = new Receipt(1L, "Success Collect", 100.00, null, null);
        return receiptInterface.createTemplate(receiptInfo, templateEngine);
    }

}
