package de.volkswagen.interpreter.command

import de.volkswagen.interpreter.computer.Memory
import de.volkswagen.interpreter.computer.Pointer

class End : Command {
    override fun execute(memory: Memory) {
        memory.output.isValid = true
        stopProgram(memory)
    }

    private fun stopProgram(memory: Memory) {
        memory.commandPointer.jumpTo(Pointer.end)
    }
}