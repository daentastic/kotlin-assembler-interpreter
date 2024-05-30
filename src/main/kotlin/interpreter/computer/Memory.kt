package de.volkswagen.interpreter.computer

class Memory {
    internal val content = mutableMapOf<String, Int>()
    internal var commandPointer = Pointer()
    internal val output = Output()
    internal var lastCompare: Int? = null


    internal fun valueOf(variable: String) =
        if (variable.trim().isNumeric()) {
            variable.trim().toInt()
        } else {
            if (variable.trim().isNegative()) {
                content[variable.trim().substring(1)]!! * -1
            } else {
                content[variable.trim()]!!
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