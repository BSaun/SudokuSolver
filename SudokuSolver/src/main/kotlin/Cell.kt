class Cell(var value : String, var potentialValues : MutableList<String>) {

    init {
        if (value != "-") {
            potentialValues = mutableListOf()
        }
    }

    override fun toString(): String {
        return value
    }
}