package de.volkswagen.interpreter.command

import de.volkswagen.interpreter.Memory

interface Command {

    fun execute(memory: Memory)

}