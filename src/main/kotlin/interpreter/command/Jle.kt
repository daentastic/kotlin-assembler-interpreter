package de.volkswagen.interpreter.command

import de.volkswagen.interpreter.computer.Memory

class Jle(private val pointer: String) : JumpCommand {
    override fun execute(memory: Memory) {
        if (memory.lastCompare != null && (memory.lastCompare!! == 0 || memory.lastCompare!! == -1)) {
            memory.commandPointer.jumpTo(pointer.toInt())
            memory.lastCompare = null
        }
    }
}