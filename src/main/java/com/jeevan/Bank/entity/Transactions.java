package com.jeevan.Bank.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "transactions")
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "application_used", nullable = false)
    private String applicationUsed;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "to_bank_acc", nullable = false)
    private Long toBankAccNum;

    @Column(name = "from_bank_acc")
    private Long fromBankAccNum;

    @Column(name = "transaction_status")
    private String transactionStatus;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
