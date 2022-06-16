fun main() {
    val fileReader = SudokuFileReader()
    val solver = fileReader.readFile("SamplePuzzles//Input//Puzzle-4x4-0902.txt")
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