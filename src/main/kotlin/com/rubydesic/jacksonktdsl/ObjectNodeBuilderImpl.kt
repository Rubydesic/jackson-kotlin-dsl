package com.rubydesic.jacksonktdsl

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.JsonNodeFactory
import com.fasterxml.jackson.databind.node.ObjectNode

internal class ObjectNodeBuilderImpl(
    val nodeFactory: JsonNodeFactory,
    val obj: ObjectNode = nodeFactory.objectNode()
) : ObjectNodeBuilder {

    override infix fun String.to(other: Any) {
        obj.replace(this, nodeFactory.pojoNode(other))
    }

    override fun String.to(other: JsonNode) {
        obj.replace(this, other)
    }

    fun build(block: ObjectNodeBuilder.() -> Unit): ObjectNode = obj.also { block() }
}