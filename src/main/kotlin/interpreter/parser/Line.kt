package de.volkswagen.interpreter.parser

class Line(text: String) {

    private val commandLine = text.withoutComment()

    fun get() = commandLine

    private fun String.withoutComment() = this.split(";").first().trim()

    fun commandName() = commandLine.split(" ").first().lowercase()

    fun subroutineName() = if (isSubroutineStart()) commandName().dropLast(1) else ""

    fun isSubroutineStart() = commandName().last() == ':'
}