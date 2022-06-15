class SudokuSolver(val boardSize : Int, val validSymbols : List<String>, val board : MutableList<MutableList<Cell>>) {
    val potentialSolutions = mutableListOf<List<List<Cell>>>()
    val solvingStrategies = mapOf(
        Pair("onlyOnePossibility", OnlyOnePossibility()),
        Pair("mostFilledRow", MostFilledRow()),
        Pair("numberByNumberScan", NumberByNumberScan())
    )
    fun solveBoard() {
        //while the current board isn't solved, go through each strategy
        //if no changes are made after each strategy is executed, no solution is found, break loop
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
        return true
    }
}