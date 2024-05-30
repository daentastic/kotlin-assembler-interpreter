package de.volkswagen.interpreter.command

import de.volkswagen.interpreter.computer.Memory

class Msg(text: String) : Command {
    private val elements = text
        .trim()
        .split(",")
        .map { it.trim() }

    override fun execute(memory: Memory) {
        memory.output.add(elements
            .joinToString("") { stringOf(it, memory) })
    }

    private fun stringOf(value: String, memory: Memory) =
        if (value.isText()) value.trim('\'')
        else memory.valueOf(value.trim()).toString()

    private fun String.isText() = this.first() == '\'' && this.last() == '\''

}