package de.volkswagen.interpreter.command

import de.volkswagen.interpreter.computer.Memory

class Call(private val pointer: String) : JumpCommand {
    override fun execute(memory: Memory) {
        memory.commandPointer.jumpTo(pointer.toInt())
    }
}