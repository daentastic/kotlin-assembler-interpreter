package de.volkswagen.interpreter

class Memory {
    internal val content = mutableMapOf<String, Int>()
    internal var commandPointer = 0

    internal fun valueOf(variable: String) =
        if (variable.isNumeric()) {
            variable.toInt()
        } else {
            if (variable.isNegative()) {
                content[variable.substring(1)]!! * -1
            } else {
                content[variable]!!
            }
        }

    private fun String.isNumeric() = this.toIntOrNull() != null

    private fun String.isNegative() = this[0] == '-'

    fun contains(variable: String) = content.contains(variable)

    fun set(variable: String, value: Int) {
        content[variable] = value
    }

    fun change(variable: String, increment: Int) {
        content[variable] = content[variable]!! + increment
    }

}