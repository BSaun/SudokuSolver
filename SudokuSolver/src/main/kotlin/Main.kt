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
}