package component.config

import component.provider.TransactionProvider
import org.pismo.transaction.repository.OperationTypeRepository
import org.pismo.transaction.repository.TransactionRepository
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean

@TestConfiguration
class TransactionTestConfig {

    @Bean
    fun transactionProvider(transactionRepository: TransactionRepository,
                            operationTypeRepository: OperationTypeRepository
    ) =
        TransactionProvider(transactionRepository, operationTypeRepository)
}
