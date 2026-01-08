package org.pismo.account.domain

import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OPERATION_TYPE_ID", nullable = false)
    val operationTypeId: OperationType,

    @Column(name = "AMOUNT", nullable = false)
    val amount: BigDecimal,

    @Column(name = "EVENT_DATE", nullable = false)
    @field:JsonSerialize(using = LocalDateTimeSerializer::class)
    val eventDate: LocalDateTime = LocalDateTime.now()
)