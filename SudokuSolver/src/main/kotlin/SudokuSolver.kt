import kotlin.math.sqrt

class SudokuSolver(val boardSize : Int, val validSymbols : List<String>, val board : MutableList<MutableList<Cell>>) {
    val potentialSolutions = mutableListOf<List<List<Cell>>>()
    private val solvingStrategies = listOf(
        OneCellRemaining(),
        OnePossibility(),
        ScanPotential()
    )

    init {
        val sqaureRoot = sqrt(boardSize.toDouble())
        if(sqaureRoot.toInt() - sqaureRoot != 0.0) {
            println("Improper File Format")
        }
        else if(board.size != boardSize) {
            println("Improper File Format")
        }
        else {
            var columnsUniform = true
            var allSymbolsValid = true
            for (row in board) {
                if (row.size != boardSize) {
                    columnsUniform = false
                }
                for (cell in row) {
                    if(validSymbols.contains(cell.value)) {
                        allSymbolsValid = false
                    }
                }
            }
            if (columnsUniform && allSymbolsValid) {
                solveBoard()
            }
            else {
                println("Improper File Format")
            }
        }
        for (row in board) {
            println(row)
        }
    }

    fun solveBoard() {
        //while the current board isn't solved, go through each strategy
        while(!checkSolved(board)) {
            var changeMade = false
            for (strategy in solvingStrategies) {
                val strategyCausedChange = strategy.execute(board, validSymbols)
                if(!changeMade && strategyCausedChange) {
                    changeMade = true
                }
            }

            //if no changes are made after each strategy is executed, no solution is found, break loop
            if (!changeMade) {
                break
            }
        }
        for (strategy in solvingStrategies) {
            println(strategy.strategyName + ": ")
            println("\tNumber of Uses: " + strategy.numUses.toString())
            println("\tTime Elapsed: " + strategy.elapsedTime)
        }

        for (row in board) {
            println(row)
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