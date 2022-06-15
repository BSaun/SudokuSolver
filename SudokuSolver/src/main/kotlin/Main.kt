fun main() {
    val fileReader = SudokuFileReader()
    val solver = fileReader.readFile("SamplePuzzles//Input//Puzzle-4x4-0101.txt")
    println(solver.boardSize)
    println(solver.validSymbols)
    for (row in solver.board) {
        println(row)
    }
    println(solver.checkSolved(solver.board))
    solver.solveBoard()
    for (row in solver.board) {
        println(row)
    }
    println(solver.checkSolved(solver.board))
}