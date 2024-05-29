package de.volkswagen.interpreter.command

import de.volkswagen.interpreter.computer.Memory

class Ret : Command {
    override fun execute(memory: Memory) {
        memory.commandPointer.jumpBack()
    }
}