package de.volkswagen.interpreter.command

import de.volkswagen.interpreter.computer.Memory

class Mul(text: String) : Command {

    val variable = text.split(" ")[0]
    val value = text.split(" ")[1]

    override fun execute(memory: Memory) {
        memory.set(variable, memory.valueOf(variable) * memory.valueOf(value))
    }
}
