package com.vic.spring.pdf.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Double total;
    private Integer quantity;

    @Column(name = "receipt_date")
    private LocalDate date;

    public Receipt(Long id, String description, Double total, Integer quantity, LocalDate date) {
        this.id = id;
        this.description = description;
        this.total = total;
        this.quantity = quantity;
        this.date = date;
    }
}
