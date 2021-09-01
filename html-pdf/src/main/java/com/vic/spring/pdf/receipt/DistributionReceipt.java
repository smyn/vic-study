package com.vic.spring.pdf.receipt;


import com.vic.spring.pdf.model.Receipt;
import com.vic.spring.pdf.repository.ReceiptRepository;
import org.thymeleaf.TemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static com.vic.spring.pdf.util.PDFUtils.generateFile;
import static com.vic.spring.pdf.util.ThymeleafUtils.generateHtmlFromMap;

public class DistributionReceipt implements ReceiptInterface {

    private Map<String, Object> receiptInfoMap = new HashMap<>();
    private final String templateName = "distribution.html";

    @Override
    public byte[] createTemplate(Receipt receiptInfo, TemplateEngine templateEngine) {
        receiptInfoMap.put("id", receiptInfo.getId());
        receiptInfoMap.put("description", receiptInfo.getDescription());
        receiptInfoMap.put("quantity", receiptInfo.getQuantity());
        String html = generateHtmlFromMap(templateEngine, receiptInfoMap, templateName);
        return generateFile(html);
    }

    @Override
    public Receipt getReceiptInfo(ReceiptRepository receiptRepository) {
        return receiptRepository.findById(2L).orElse(null);
    }

}
