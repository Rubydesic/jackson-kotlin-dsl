package com.rubydesic.jacksonktdsl

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.node.ArrayNode
import com.fasterxml.jackson.databind.node.JsonNodeFactory

internal class ArrayNodeFactoryImpl(private val nodeFactory: JsonNodeFactory) : ArrayNodeFactory {
    override fun get(vararg elements: Any): ArrayNode {
        val arr = nodeFactory.arrayNode(elements.size)
        elements.forEach(arr::addPOJO)
        return arr
    }

    override fun get(elements: List<JsonNode>): ArrayNode {
        return ArrayNode(nodeFactory, elements)
    }
}