package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.TransactionItem;

import java.util.List;

public interface TransactionItemRepository 
        extends JpaRepository<TransactionItem, Long> {

    List<TransactionItem> findByTransactionTransactionId(Long transactionId);
}

