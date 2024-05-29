package de.volkswagen.interpreter

import de.volkswagen.interpreter.computer.Processor

fun interpret(program: String): String? {
    val code = program.split("\n").toTypedArray()
    val processor = Processor()
    processor.process(code)
    return processor.print()
}
