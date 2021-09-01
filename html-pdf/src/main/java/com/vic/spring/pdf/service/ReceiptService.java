package com.vic.spring.pdf.service;

import com.vic.spring.pdf.receipt.ReceiptInterface;

public interface ReceiptService {

    byte[] getReceipt(ReceiptInterface receiptInterface);

}
