package org.pismo.transaction.enum

enum class TransactionTypeEnum(vararg val ids: Long) {
    DEBIT(1, 2, 3),
    CREDIT(4);

    companion object {
        fun fromId(id: Long): TransactionTypeEnum {
            return entries.find { id in it.ids }!!
        }
    }
}