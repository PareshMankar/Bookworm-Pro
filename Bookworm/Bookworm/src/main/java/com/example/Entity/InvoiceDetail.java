package com.example.Entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "invoice_detail")
public class InvoiceDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invdtl_id")
    private int invdtlId;

    // -------- Relationship with Product --------

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    // -------- Quantity --------

    @Column(name = "quantity")
    private int quantity;

    // -------- Total Amount --------

    @Column(name = "total_amount", nullable = false)
    private BigDecimal totalAmount;

    // -------- Transaction Type --------

    @Enumerated(EnumType.STRING)
    @Column(name = "tran_type")
    private TransactionType tranType;

    // -------- Rent No of Days --------

    @Column(name = "rent_no_of_days")
    private int rentNoOfDays;

    // -------- Constructors --------

    public InvoiceDetail() {
    }

   

    // -------- Getters and Setters --------

    public int getInvdtlId() {
        return invdtlId;
    }

    public void setInvdtlId(int invdtlId) {
        this.invdtlId = invdtlId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public TransactionType getTranType() {
        return tranType;
    }

    public void setTranType(TransactionType tranType) {
        this.tranType = tranType;
    }

    public int getRentNoOfDays() {
        return rentNoOfDays;
    }

    public void setRentNoOfDays(int rentNoOfDays) {
        this.rentNoOfDays = rentNoOfDays;
    }
}
