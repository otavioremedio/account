package org.pismo.commons.aspect

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.pismo.commons.facade.LogMapperRegistry
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Aspect
@Component
class ControllerLogAspect {

    private val logger = LoggerFactory.getLogger(this::class.java)
    private val logMapper = LogMapperRegistry.logMapper

    @Around("@within(org.springframework.web.bind.annotation.RestController)")
    fun logControllerAccess(joinPoint: ProceedingJoinPoint): Any? {
        val methodName = joinPoint.signature.name
        val args = joinPoint.args

        try {
            val requestJson = logMapper.writeValueAsString(args)
            logger.info("START - Method: [{}], Request: {}", methodName, requestJson)
        } catch (e: Exception) {
            logger.error("START - Method: [{}], Exception: {}", methodName, e.message)
        }

        val result = joinPoint.proceed()

        try {
            val responseJson = logMapper.writeValueAsString(result)
            logger.info("END - Method: [{}], Response: {}", methodName, responseJson)
        } catch (e: Exception) {
            logger.error("END - Method: [{}], Exception: {}", methodName, e.message)
        }

        return result
    }
}
