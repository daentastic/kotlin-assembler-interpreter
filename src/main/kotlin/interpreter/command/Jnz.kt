package de.volkswagen.interpreter.command

import de.volkswagen.interpreter.Memory

class Jnz(text: String) : Command {
    private val variable = text.split(" ")[1]
    private val value = text.split(" ")[2]

    override fun execute(memory: Memory) {
        memory.commandPointer =
            when {
                (increasePointer(memory)) -> memory.commandPointer + memory.valueOf(value) - 1
                (decreasePointer(memory)) -> memory.commandPointer + memory.valueOf(value)
                else -> memory.commandPointer
            }
    }

    private fun decreasePointer(memory: Memory) = memory.valueOf(value) > 0 && memory.valueOf(variable) != 0

    private fun increasePointer(memory: Memory) = memory.valueOf(value) < 0 && memory.valueOf(variable) != 0
}
