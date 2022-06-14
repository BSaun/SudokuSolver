import java.io.File

class SudokuFileReader(val solver : SudokuSolver) {
    fun readFile(fileName : String) {
        var lines : List<String> = File(fileName).readLines()
        if (lines.last() == "") {
            lines = lines.dropLast(1)
        }
        solver.setSudokuBoardSize(lines[0].toInt())
        solver.setValidSudokuSymbols(lines[1].split(" "))
        val sudokuBoard = mutableListOf(listOf<String>())
        for (i in 2 until lines.size) {
            val row = lines[i].split(" ")
            if (row.size != lines[0].toInt()) {
                println("Invalid file format")
                return
            }
            sudokuBoard.add(row)
        }
        //Strip empty first element
        sudokuBoard.removeFirst()
        solver.setSudokuBoard(sudokuBoard)
    }
}