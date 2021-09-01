package com.vic.spring.pdf.controller;


import com.vic.spring.pdf.receipt.CollectReceipt;
import com.vic.spring.pdf.receipt.DistributionReceipt;
import com.vic.spring.pdf.receipt.TranshipmentReceipt;
import com.vic.spring.pdf.service.ReceiptService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("receipts")
public class ReceiptController {

    private final ReceiptService receiptService;

    public ReceiptController(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    @GetMapping(value = "collections", produces = "application/pdf")
    public ResponseEntity<byte[]> getCollections() {
        return createResponseBytes(receiptService.getReceipt(new CollectReceipt()));
    }

    @GetMapping(value = "distributions", produces = "application/pdf")
    public ResponseEntity<byte[]> getDistributions() {
        return createResponseBytes(receiptService.getReceipt(new DistributionReceipt()));
    }

    @GetMapping(value = "overflows", produces = "application/pdf")
    public ResponseEntity<byte[]> getOverflows() {
        return createResponseBytes(receiptService.getReceipt(new TranshipmentReceipt()));
    }

    private ResponseEntity<byte[]> createResponseBytes(byte[] bytes) {
        return ResponseEntity.ok()
                .header("Content-disposition", "attachment; filename=receipt.pdf")
                .body(bytes);
    }

}
