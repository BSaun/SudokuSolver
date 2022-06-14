import java.io.File

class SudokuFileReader() {
    fun readFile(fileName : String) : SudokuSolver? {
        var lines : List<String> = File(fileName).readLines()
        if (lines.last() == "") {
            lines = lines.dropLast(1)
        }
        val boardSize = lines[0].toInt()
        val symbols = lines[1].split(" ")
        val sudokuBoard = mutableListOf(listOf<String>())
        for (i in 2 until lines.size) {
            val row = lines[i].split(" ")
            if (row.size != lines[0].toInt()) {
                return null
            }
            sudokuBoard.add(row)
        }
        //Strip empty first element
        sudokuBoard.removeFirst()

        return SudokuSolver(boardSize, symbols, sudokuBoard)
    }
}