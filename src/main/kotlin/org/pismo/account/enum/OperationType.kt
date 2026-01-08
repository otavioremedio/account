package org.pismo.account.enum

enum class OperationType(val id: Long, val description: String, val type: TransactionType) {
    PURCHASE(1, "PURCHASE", TransactionType.DEBIT),
    INSTALLMENT_PURCHASE(2, "INSTALLMENT PURCHASE", TransactionType.DEBIT),
    WITHDRAWAL(3, "WITHDRAWAL", TransactionType.DEBIT),
    PAYMENT(4, "PAYMENT", TransactionType.CREDIT);

    companion object {
        fun fromId(id: Long) = OperationType.entries.find { it.id == id }
            ?: throw IllegalArgumentException("Invalid operation type ID")
    }
}