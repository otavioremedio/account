package component.provider

import java.math.BigDecimal
import org.pismo.transaction.domain.OperationType
import org.pismo.transaction.domain.Transaction
import org.pismo.transaction.repository.OperationTypeRepository
import org.pismo.transaction.repository.TransactionRepository
import org.springframework.boot.test.context.TestComponent

@TestComponent
class TransactionProvider(
    private val transactionRepository: TransactionRepository,
    private val operationTypeRepository: OperationTypeRepository
) {
    fun createForAccount(accountId: Long, operationTypeId: Long = 1L, amount: Double = 100.50): Transaction {
        val opType: OperationType = operationTypeRepository.findById(operationTypeId).orElseThrow()
        val transaction = Transaction(
            accountId = accountId,
            operationTypeId = opType,
            amount = BigDecimal.valueOf(amount)
        )
        return transactionRepository.save(transaction)
    }
}