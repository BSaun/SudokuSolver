class OnePossibility : SudokuSolveStrategy() {
    override val strategyName = "OneCellColumn"
    override fun findApplicableCells(board: List<List<Cell>>, validSymbols: List<String>): List<Cell> {
        val cellsToReturn = mutableListOf<Cell>()

        for (row in board) {
            for (cell in row) {
                if(cell.potentialValues.size == 1) {
                    cellsToReturn.add(cell)
                }
            }
        }
        return cellsToReturn
    }

    override fun applyChanges(board: List<List<Cell>>, validSymbols: List<String>, cells: List<Cell>): Boolean {
        var changeMade = false
        for (cell in cells) {
            if (cell.potentialValues.size == 1) {
                cell.value = cell.potentialValues[0]
                cell.potentialValues = emptyList()
                changeMade = true
            }
        }
        return changeMade
    }
}