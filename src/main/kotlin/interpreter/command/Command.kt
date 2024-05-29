package de.volkswagen.interpreter.command

import de.volkswagen.interpreter.computer.Memory

interface Command {

    fun execute(memory: Memory)

}