package de.volkswagen.interpreter.computer

import de.volkswagen.interpreter.parser.Parser

class Processor {
    private val memory = Memory()

    fun process(program: Array<String>): Map<String, Int> {
        val commands = Parser().parse(program)
        while (memory.commandPointer.current in commands.indices) {
            commands[memory.commandPointer.current].execute(memory)
            memory.commandPointer.goNextStep()
        }
        return memory.content
    }

    fun print(): String? = if (memory.output.isValid)
        memory.output.get()
    else null
}