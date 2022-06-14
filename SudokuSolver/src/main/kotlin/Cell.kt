class Cell(var value : String, var potentialValues : List<String>) {

    init {
        if (value != "-") {
            potentialValues = emptyList()
        }
    }

    override fun toString(): String {
        return value
    }
}