package com.rubydesic.jacksonktdsl

import com.fasterxml.jackson.databind.node.JsonNodeFactory
import com.fasterxml.jackson.databind.node.ObjectNode

private val defaultNodeFactory = JsonNodeFactory.instance

fun obj(block: ObjectNodeBuilder.() -> Unit) =
    defaultNodeFactory.obj(block)

fun JsonNodeFactory.obj(block: ObjectNodeBuilder.() -> Unit): ObjectNode =
    ObjectNodeBuilderImpl(this).build(block)

val arr: ArrayNodeFactory = defaultNodeFactory.arr

val JsonNodeFactory.arr get(): ArrayNodeFactory = ArrayNodeFactoryImpl(this)