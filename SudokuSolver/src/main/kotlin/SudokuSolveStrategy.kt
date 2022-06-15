
abstract class SudokuSolveStrategy {
    var numUses = 0
        private set
    var elapsedTime : Long = 0
        private set
    fun execute(board : List<List<Cell>>, validSymbols: List<String>) : Boolean {
        val startTime = System.currentTimeMillis()
        val cells = findApplicableCells(board, validSymbols)
        var changeMade = false
        if (cells.isNotEmpty()) {
            numUses++
            changeMade = applyChanges(board, validSymbols, cells)
        }
        elapsedTime += System.currentTimeMillis() - startTime
        return changeMade
    }
    abstract fun findApplicableCells(board : List<List<Cell>>, validSymbols: List<String>) : List<Cell>
    abstract fun applyChanges(board : List<List<Cell>>, validSymbols : List<String>, cells : List<Cell>) : Boolean

}
