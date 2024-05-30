package de.volkswagen.interpreter.parser

import de.volkswagen.interpreter.command.Command
import de.volkswagen.interpreter.command.JumpCommand
import de.volkswagen.interpreter.command.commandFunction


class Parser {

    private var lines: List<Line> = emptyList()

    fun parse(program: Array<String>): List<Command> {
        lines = program.lines()
        return program
            .map { Line(it) }
            .filter { it.withoutComment().isNotBlank() }
            .map { it.toCommand() }
    }

    private fun Array<String>.lines() = this
        .map { Line(it) }
        .filter { it.withoutComment().isNotBlank() }


    private fun Line.toCommand(): Command {
        val commandFunction = commandName().commandFunction()
        val args = if (commandFunction("dummy string with several words") is JumpCommand) pointer().toString()
        else arguments()
        return commandFunction(args)
    }

    private fun Line.pointer() = pointerOf(this.withoutComment().split(" ")[1])

    private fun pointerOf(subroutineName: String): Int = lines.indices
        .filter { lines[it].isSubroutineStart() }
        .groupBy { lines[it].subroutineName() }
        .mapValues { it.value.first() }[subroutineName]!!
}
