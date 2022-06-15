fun main() {
    val fileReader = SudokuFileReader()
    val solver = fileReader.readFile("SamplePuzzles//Input//Puzzle-4x4-0001.txt")
    println(solver?.boardSize)
    println(solver?.validSymbols)
    if (solver != null) {
        for (row in solver.board) {
            println(row)
        }
    }
    println(solver?.checkSolved(solver.board))
    solver?.board?.get(0)?.get(1)?.value = "4"
    solver?.board?.get(1)?.get(2)?.value = "2"
    solver?.board?.get(2)?.get(3)?.value = "2"
    solver?.board?.get(3)?.get(0)?.value = "4"
    if (solver != null) {
        for (row in solver.board) {
            println(row)
        }
    }
    println(solver?.checkSolved(solver.board))
}