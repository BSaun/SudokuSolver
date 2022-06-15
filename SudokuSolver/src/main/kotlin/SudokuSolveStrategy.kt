
abstract class SudokuSolveStrategy {
    var numUses = 0
        private set
    var elapsedTime : Long = 0
        private set
    fun execute(board : List<List<Cell>>) : Boolean {
        val startTime = System.currentTimeMillis()
        val result = findApplicableCells(board)
        val cells = result.first
        var changeMade = false
        val manipulationParam = result.second
        if (cells.isNotEmpty()) {
            numUses++
            changeMade = applyChanges(board, cells, manipulationParam)
        }
        elapsedTime += System.currentTimeMillis() - startTime
        return changeMade
    }
    abstract fun findApplicableCells(board : List<List<Cell>>) : Pair<List<Cell>, Any>
    abstract fun applyChanges(board : List<List<Cell>>, cells : List<Cell>, manipulationParam: Any) : Boolean

}
