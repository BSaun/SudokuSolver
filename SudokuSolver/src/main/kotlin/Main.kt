fun main() {
    val solver = SudokuSolver()
    val fileReader = SudokuFileReader(solver)
    fileReader.readFile("SamplePuzzles//Input//Puzzle-4x4-0001.txt")
    println(solver.boardSize)
    println(solver.validSymbols)
    for (row in solver.board) {
        println(row)
    }
}