package de.volkswagen.interpreter.command

import de.volkswagen.interpreter.computer.Memory

class Div(text: String):Command {

    private val variable = text.split(" ")[1]
    private val value = text.split(" ")[2]

    override fun execute(memory: Memory) {
        memory.set(variable, memory.content[variable]!! / memory.valueOf(value))
    }
}