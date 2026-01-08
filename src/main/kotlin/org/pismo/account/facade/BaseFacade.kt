package org.pismo.account.facade

import kotlin.jvm.internal.CallableReference
import org.pismo.account.config.MapperLogConfiguration
import org.slf4j.Logger
import org.slf4j.LoggerFactory

open class BaseFacade {

    protected val logger: Logger = LoggerFactory.getLogger(this.javaClass)
    protected val logMapper = MapperLogConfiguration.logMapper

    protected fun <T> T.execAndLog(func: (T) -> T): T {
        val method = (func as CallableReference).name

        return try {
            func(this).also { r -> logger.info("Method: {}, Param: {}", method, logMapper.writeValueAsString(r)) }
        } catch (ex: Throwable) {
            logger.error("Method: {}, Exception: {}, Context: {}", method, ex, logMapper.writeValueAsString(this!!))
            throw ex
        }
    }
}

