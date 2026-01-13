package org.pismo.commons.config

import com.fasterxml.jackson.databind.ObjectMapper

abstract class MapperLogConfiguration {
    open val logMapper: ObjectMapper = ObjectMapper()
}