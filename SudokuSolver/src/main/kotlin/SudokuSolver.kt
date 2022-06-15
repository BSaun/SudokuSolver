class SudokuSolver(val boardSize : Int, val validSymbols : List<String>, val board : MutableList<MutableList<Cell>>) {
    val potentialSolutions = mutableListOf<List<List<Cell>>>()
    private val solvingStrategies = listOf(
        OneCellRemaining(),
        OnePossibility(),
        ScanPotential()
    )

    init {
//        solveBoard()
    }

    fun solveBoard() {
        //while the current board isn't solved, go through each strategy
        while(!checkSolved(board)) {
            var changeMade = false
//            for (strategy in solvingStrategies) {
//                val strategyCausedChange = strategy.execute(board, validSymbols)
//                if(!changeMade && strategyCausedChange) {
//                    changeMade = true
//                }
//            }

            changeMade = solvingStrategies[0].execute(board, validSymbols)

            //if no changes are made after each strategy is executed, no solution is found, break loop
            if (!changeMade) {
                break
            }
        }
        for (strat in solvingStrategies) {
            println(strat.strategyName + ": " + strat.numUses.toString())
        }
        //report solution
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