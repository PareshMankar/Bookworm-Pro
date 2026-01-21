package com.example.Entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_id")
    private int invoiceId;

    @Column(name = "invoice_date", nullable = false)
    private LocalDate invoiceDate;

    // -------- Relationship with User --------

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // -------- Invoice Amount --------

    @Column(name = "invoice_amount", nullable = false)
    private BigDecimal invoiceAmount;

    // -------- Relationship with InvoiceDetail --------
    // One Invoice → Many InvoiceDetails

    @OneToMany
    @JoinColumn(name = "invdtl_id") 
    private List<InvoiceDetail> invoiceDetails;

    // -------- Constructors --------

    public Invoice() {
    }

    

    // -------- Getters and Setters --------

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BigDecimal getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(BigDecimal invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public List<InvoiceDetail> getInvoiceDetails() {
        return invoiceDetails;
    }

    public void setInvoiceDetails(List<InvoiceDetail> invoiceDetails) {
        this.invoiceDetails = invoiceDetails;
    }
}
