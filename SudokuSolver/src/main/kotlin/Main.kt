fun main() {
    val fileReader = SudokuFileReader()
    val solver = fileReader.readFile("SamplePuzzles//Input//Puzzle-4x4-0001.txt")
    println(solver.boardSize)
    println(solver.validSymbols)
    for (row in solver.board) {
        println(row)
    }
    println(solver.checkSolved(solver.board))
    solver.board[0][1].value = "4"
    solver.board[1][2].value = "2"
    solver.board[2][3].value = "2"
    solver.board[3][0].value = "4"
    for (row in solver.board) {
        println(row)
    }
    println(solver.checkSolved(solver.board))
}