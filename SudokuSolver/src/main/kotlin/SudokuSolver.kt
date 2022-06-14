class SudokuSolver {
    lateinit var board : List<List<String>>
    lateinit var validSymbols : List<String>
    var boardSize : Int = 0

    fun readPuzzleFile() {

    }

    fun solveBoard() {

    }

    fun setSudokuBoardSize(size : Int) {
        boardSize = size
    }

    fun setValidSudokuSymbols(symbols : List<String>) {
        validSymbols = symbols
    }

    fun setSudokuBoard(sudokuBoard : List<List<String>>) {
        board = sudokuBoard
    }
}