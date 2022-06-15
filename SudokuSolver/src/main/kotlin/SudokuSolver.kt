class SudokuSolver(val boardSize : Int, val validSymbols : List<String>, val board : MutableList<MutableList<Cell>>) {
    val potentialSolutions = mutableListOf<List<List<Cell>>>()
    private val solvingStrategies = listOf(
        OnlyOnePossibility(),
        MostFilledRow(),
        NumberByNumberScan()
    )

    init {
//        solveBoard()
    }

    fun solveBoard() {
        var changeMade = false
        //while the current board isn't solved, go through each strategy
        while(!checkSolved(board)) {
            for (strategy in solvingStrategies) {
                val strategyCausedChange = strategy.execute(board)
                if(!changeMade && strategyCausedChange) {
                    changeMade = true
                }
            }
            //if no changes are made after each strategy is executed, no solution is found, break loop
            if (!changeMade) {
                break
            }
        }
        //report solutions
    }

    fun checkSolved(board : MutableList<MutableList<Cell>>) : Boolean{
        for (row in board) {
            val remainingSymbols = validSymbols.toMutableList()
            for (cell in row) {
                remainingSymbols.remove(cell.value)
            }
            if (remainingSymbols.size > 0) {
                return false
            }
        }

        for (column in board.indices) {
            val remainingSymbols = validSymbols.toMutableList()
            for (row in board) {
                remainingSymbols.remove(row[column].value)
            }
            if (remainingSymbols.size > 0) {
                return false
            }
        }
        return true
    }
}