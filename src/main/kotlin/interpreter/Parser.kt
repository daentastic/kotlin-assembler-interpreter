package de.volkswagen.interpreter

import de.volkswagen.interpreter.command.Jnz
import de.volkswagen.interpreter.command.Command
import de.volkswagen.interpreter.command.Dec
import de.volkswagen.interpreter.command.Inc
import de.volkswagen.interpreter.command.Mov

class Parser {

    fun parse(program: Array<String>) = program.map { it.toCommand() }

    private fun String.toCommand(): Command = when (split(" ")[0]) {
        "mov" -> Mov(this)
        "inc" -> Inc(this)
        "dec" -> Dec(this)
        "jnz" -> Jnz(this)
        else -> throw IllegalArgumentException()
    }
}
