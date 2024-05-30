package de.volkswagen.interpreter.command

import de.volkswagen.interpreter.computer.Memory

class Dec(text: String) : Command {
    private val variable = text.split(" ").first()

    override fun execute(memory: Memory) {
        if (memory.contains(variable)) {
            memory.change(variable, increment = -1)
        }

    }
}