package org.pismo.account.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "ACCOUNTS")
data class Account(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACCOUNT_ID")
    val accountId: Long? = null,

    @Column(name = "DOCUMENT_NUMBER", unique = true, nullable = false)
    val documentNumber: String,
)
