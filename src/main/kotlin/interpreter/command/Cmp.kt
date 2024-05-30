package de.volkswagen.interpreter.command

import de.volkswagen.interpreter.computer.Memory

class Cmp(text: String) : Command {
    private val value1 = text.split(" ")[0]
    private val value2 = text.split(" ")[1]
    override fun execute(memory: Memory) {
        memory.lastCompare = memory.valueOf(value1).compareTo(memory.valueOf(value2))
    }
}