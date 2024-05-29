package de.volkswagen.interpreter.computer

class Output {

    private var content = ""
    internal var isValid = false

    fun add(text: String) {
        content += text
    }

    fun get(): String = content
}