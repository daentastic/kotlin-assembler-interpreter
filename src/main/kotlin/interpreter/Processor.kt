package de.volkswagen.interpreter

class Processor {
    private val memory = Memory()

    fun process(program: Array<String>): Map<String, Int> {
        val commands = Parser().parse(program)
        var index = memory.commandPointer
        while (index in commands.indices) {
            commands[index].execute(memory)
            ++memory.commandPointer
            index = memory.commandPointer
        }
        return memory.content
    }

//    private fun currentCommand() =
}