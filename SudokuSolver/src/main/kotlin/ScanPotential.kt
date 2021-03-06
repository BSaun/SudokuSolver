import kotlin.math.sqrt

class ScanPotential : SudokuSolveStrategy() {
    override val strategyName = "ScanPotential"
    override fun findApplicableCells(board: List<List<Cell>>, validSymbols: List<String>): List<Cell> {
        val presentInRow = mutableListOf(mutableListOf<String>())
        val presentInColumn = mutableListOf(mutableListOf<String>())
        val presentInBlock = mutableListOf(mutableListOf(mutableListOf<String>()))
        val blockSize = sqrt(board.size.toDouble()).toInt()
        for (i in 0 until blockSize) {
            presentInBlock.add(mutableListOf())
            for (j in 0 until blockSize) {
                presentInBlock[i].add(mutableListOf())
            }
        }
        for (i in board.indices) {
            presentInRow.add(mutableListOf())
            presentInColumn.add(mutableListOf())
        }

        val cellsToReturn = mutableListOf<Cell>()

        for (row in board.indices) {
            for (column in board.indices) {
                if(board[row][column].value != "-") {
                    presentInRow[row].add(board[row][column].value)
                    presentInColumn[column].add(board[row][column].value)
                    presentInBlock[row / blockSize][column / blockSize].add(board[row][column].value)
                }
            }
        }

        for (row in board.indices) {
            for (column in board.indices) {
                if(board[row][column].value == "-") {
                    val cellToModify = board[row][column]
                    val startPotentialValues = cellToModify.potentialValues.toMutableList()
                    val currentAllowedSymbols = startPotentialValues.toMutableList()
                    for(value in presentInRow[row]) {
                        currentAllowedSymbols.remove(value)
                    }
                    for(value in presentInColumn[column]) {
                        currentAllowedSymbols.remove(value)
                    }
                    for(value in presentInBlock[row / blockSize][column / blockSize]) {
                        currentAllowedSymbols.remove(value)
                    }
                    if (startPotentialValues != currentAllowedSymbols) {
                        cellsToReturn.add(cellToModify)
                        cellToModify.potentialValues = currentAllowedSymbols
                    }
                }
            }
        }

        return cellsToReturn
    }

    override fun applyChanges(board: List<List<Cell>>, validSymbols: List<String>, cells: List<Cell>): Boolean {
        return cells.isNotEmpty()
    }
}