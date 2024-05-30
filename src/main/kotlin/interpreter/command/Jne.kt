package de.volkswagen.interpreter.command

import de.volkswagen.interpreter.computer.Memory

class Jne(private val pointer: String) : JumpCommand {
    override fun execute(memory: Memory) {
        if (memory.lastCompare != null && memory.lastCompare!! != 0) {
            memory.commandPointer.jumpTo(pointer.toInt())
            memory.lastCompare = null
        }
    }
}