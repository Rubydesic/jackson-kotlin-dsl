package com.rubydesic.jacksonktdsl

import com.fasterxml.jackson.databind.JsonNode

interface ObjectNodeBuilder {
    infix fun String.to(other: Any)
    infix fun String.to(other: JsonNode)
    infix fun String.to(other: ObjectNodeBuilder.() -> Unit) = to(obj(other))
    operator fun String.invoke(other: JsonNode) = to(other)
}