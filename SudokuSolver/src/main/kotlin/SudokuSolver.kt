import java.io.File
import kotlin.math.sqrt

class SudokuSolver(boardSize : Int,
                   private val validSymbols : List<String>,
                   private val board : MutableList<MutableList<Cell>>,
                   private var fileName : String) {
    val potentialSolutions = mutableListOf<List<List<Cell>>>()
    private var totalSolvingTime : Long = 0
    private var solutionString : String = ""
    private val solvingStrategies = listOf(
        OneCellRemaining(),
        OnePossibility(),
        ScanPotential()
    )

    init {
        solutionString += ("$boardSize \n")
        for (symbol in validSymbols) {
            solutionString += ("$symbol ")
        }
        solutionString += "\n"
        for (row in board) {
            for (cell in row) {
                solutionString += (cell.value + " ")
            }
            solutionString += "\n"
        }
        val squareRoot = sqrt(boardSize.toDouble())
        val perfectSquare = squareRoot.toInt() - squareRoot == 0.0
        val rowsUniform = board.size == boardSize
        var columnsUniform = true
        var allSymbolsValid = true
        for (row in board) {
            if (row.size != boardSize) {
                columnsUniform = false
            }
            for (cell in row) {
                if(!validSymbols.contains(cell.value) && cell.value != "-") {
                    allSymbolsValid = false
                }
            }
        }
        if (perfectSquare && rowsUniform && columnsUniform && allSymbolsValid) {
            println("Solving " + fileName)
            solveBoard()
        }
        else {
            solutionString += "Invalid: Improper File Format\n"
        }
        File(fileName).writeText(solutionString)
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
        if(checkSolved(board)) {
            solutionString += ("\nSolution\n")
        }
        else {
            solutionString += ("\nNo Solution Found\n")
        }
        for (row in board) {
            for (cell in row) {
                solutionString += (cell.value + " ")
            }
            solutionString += "\n"
        }

        for (strategy in solvingStrategies) {
            totalSolvingTime += strategy.elapsedTime
            solutionString += ("\n" + strategy.strategyName + ": \n")
            solutionString += ("\tNumber of Uses: " + strategy.numUses.toString() + "\n")
            solutionString += ("\tTime Elapsed: " + strategy.elapsedTime + " milliseconds\n")
        }
        solutionString += ("\nTotal solving time: $totalSolvingTime milliseconds\n")
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