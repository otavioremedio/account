package org.pismo.account.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "TRANSACTIONS")
data class Transaction(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRANSACTION_ID")
    val transactionId: Long? = null,

    @Column(name = "ACCOUNT_ID", nullable = false)
    val accountId: Long,

    @Column(name = "OPERATION_TYPE_ID", nullable = false)
    val operationTypeId: Long,

    @Column(name = "AMOUNT", nullable = false)
    val amount: BigDecimal,

    @Column(name = "EVENT_DATE", nullable = false)
    val eventDate: LocalDateTime = LocalDateTime.now()
)