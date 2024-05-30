package de.volkswagen.interpreter.parser

class Line(private val text: String) {

    fun withoutComment() = text.withoutComment()

    private fun String.withoutComment() = this.split(";").first().trim()

    fun commandName() = this.withoutComment().split(" ").first().lowercase().trim()

    fun arguments() = this.withoutComment().replace(commandName(), "").trim()

    fun subroutineName() = if (isSubroutineStart()) commandName().dropLast(1) else ""

    fun isSubroutineStart() = commandName().last() == ':'
}