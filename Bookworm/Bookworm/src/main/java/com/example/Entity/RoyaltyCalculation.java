package com.example.Entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "royalty_calculation")
public class RoyaltyCalculation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roycal_id")
    private int roycalId;

    // -------- Relationship with InvoiceDetail --------

    @ManyToOne
    @JoinColumn(name = "invdtl_id", nullable = false)
    private InvoiceDetail invoiceDetail;

    // -------- Transaction Date --------

    @Column(name = "roycal_trandate")
    private LocalDate roycalTranDate;

    // -------- Relationship with Product --------

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    // -------- Financial Fields --------

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    @Column(name = "royalty_percent")
    private BigDecimal royaltyPercent;

    @Column(name = "Total_Royalty")
    private BigDecimal totalRoyalty;

    // -------- Constructors --------

    public RoyaltyCalculation() {
    }

    

    // -------- Getters and Setters --------

    public int getRoycalId() {
        return roycalId;
    }

    public void setRoycalId(int roycalId) {
        this.roycalId = roycalId;
    }

    public InvoiceDetail getInvoiceDetail() {
        return invoiceDetail;
    }

    public void setInvoiceDetail(InvoiceDetail invoiceDetail) {
        this.invoiceDetail = invoiceDetail;
    }

    public LocalDate getRoycalTranDate() {
        return roycalTranDate;
    }

    public void setRoycalTranDate(LocalDate roycalTranDate) {
        this.roycalTranDate = roycalTranDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getRoyaltyPercent() {
        return royaltyPercent;
    }

    public void setRoyaltyPercent(BigDecimal royaltyPercent) {
        this.royaltyPercent = royaltyPercent;
    }

    public BigDecimal getTotalRoyalty() {
        return totalRoyalty;
    }

    public void setTotalRoyalty(BigDecimal totalRoyalty) {
        this.totalRoyalty = totalRoyalty;
    }
}
