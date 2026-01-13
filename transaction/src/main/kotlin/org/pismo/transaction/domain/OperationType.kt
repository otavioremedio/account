package org.pismo.transaction.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "OPERATION_TYPES")
data class OperationType(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OPERATION_TYPE_ID")
    val id: Long,

    @Column(name = "DESCRIPTION", nullable = false)
    val description: String
)

