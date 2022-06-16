class OneCellRemaining : SudokuSolveStrategy() {
    override val strategyName = "OneCellRemaining"
    override fun findApplicableCells(board: List<List<Cell>>, validSymbols: List<String>): List<Cell> {
        val cellsToReturn = mutableListOf<Cell>()

        for (row in board) {
            var blankSpaces = 0
            var cellToModify : Cell? = null
            val remainingSymbols = validSymbols.toMutableList()
            for (cell in row) {
                if (cell.value != "-") {
                    remainingSymbols.remove(cell.value)
                }
                if (cell.value == "-" && blankSpaces == 0) {
                    blankSpaces++
                    cellToModify = cell
                }
                else if(cell.value == "-" && blankSpaces > 0) {
                    cellToModify = null
                }
            }
            if (cellToModify == null) {
                continue
            }
            else {
                cellToModify.potentialValues = remainingSymbols
                cellsToReturn.add(cellToModify)
            }
        }
        return cellsToReturn
    }

    override fun applyChanges(board: List<List<Cell>>, validSymbols: List<String>, cells: List<Cell>): Boolean {
        var changeMade = false
        for (cell in cells) {
            if (cell.potentialValues.size == 1) {
                cell.value = cell.potentialValues[0]
                cell.potentialValues = mutableListOf()
                changeMade = true
            }
        }
        return changeMade
    }
}