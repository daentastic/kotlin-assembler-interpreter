package de.volkswagen.interpreter.parser

import de.volkswagen.interpreter.command.*

class Parser {

    private var lines: List<Line> = emptyList()

    fun parse(program: Array<String>): List<Command> {
        lines = program.lines()
        return program
            .map { Line(it) }
            .filter { it.get().isNotBlank() }
            .map { it.toCommand() }
    }

    private fun Array<String>.lines() = this
        .map { Line(it) }
        .filter { it.get().isNotBlank() }

    private fun Line.toCommand(): Command = when (this.commandName()) {
        "mov" -> Mov(this.get())
        "inc" -> Inc(this.get())
        "dec" -> Dec(this.get())
        "jnz" -> Jnz(this.get())
        "msg" -> Msg(this.get())
        "call" -> Call(this.pointer())
        "ret" -> Ret()
        "end" -> End()
        "div" -> Div(this.get())
        else -> Skip()
    }

    private fun Line.pointer() = pointerOf()[this.get().split(" ")[1]]!!

    private fun pointerOf(): Map<String, Int> = lines.indices
        .filter { lines[it].isSubroutineStart() }
        .groupBy { lines[it].subroutineName() }
        .mapValues { it.value.first() }
}
