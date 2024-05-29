package de.volkswagen.interpreter

fun parse(program: Array<String>): Map<String, Int> {
    return Processor().process(program)
}
