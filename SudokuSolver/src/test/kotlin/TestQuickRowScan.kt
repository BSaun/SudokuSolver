import org.junit.jupiter.api.Test

class TestQuickRowScan {
    @Test
    fun noChanges() {
        val validSymbols = mutableListOf("1", "2", "3", "4")
        val board = listOf(
            listOf(Cell("1", validSymbols),Cell("2", validSymbols),Cell("3", validSymbols),Cell("4", validSymbols)),
            listOf(Cell("-", validSymbols),Cell("-", validSymbols),Cell("-", validSymbols),Cell("-", validSymbols)),
            listOf(Cell("-", validSymbols),Cell("-", validSymbols),Cell("-", validSymbols),Cell("-", validSymbols)),
            listOf(Cell("4", validSymbols),Cell("3", validSymbols),Cell("1", validSymbols),Cell("2", validSymbols)),
        )
        QuickRowScan().execute(board,validSymbols)
        for (i in 1..2) {
            for (cell in board[i]) {
                assert(cell.value == "-")
            }
        }
    }

    @Test
    fun oneChange() {
        val validSymbols = mutableListOf("1", "2", "3", "4")
        val board = listOf(
            listOf(Cell("1", validSymbols),Cell("2", validSymbols),Cell("3", validSymbols),Cell("4", validSymbols)),
            listOf(Cell("3", validSymbols),Cell("4", validSymbols),Cell("2", validSymbols),Cell("1", validSymbols)),
            listOf(Cell("2", validSymbols),Cell("-", validSymbols),Cell("4", validSymbols),Cell("3", validSymbols)),
            listOf(Cell("4", validSymbols),Cell("3", validSymbols),Cell("1", validSymbols),Cell("2", validSymbols)),
        )
        QuickRowScan().execute(board,validSymbols)
        assert(board[0].toString() == listOf(Cell("1", validSymbols),Cell("2", validSymbols),Cell("3", validSymbols),Cell("4", validSymbols)).toString())
        assert(board[1].toString() == listOf(Cell("3", validSymbols),Cell("4", validSymbols),Cell("2", validSymbols),Cell("1", validSymbols)).toString())
        assert(board[2].toString() == listOf(Cell("2", validSymbols),Cell("1", validSymbols),Cell("4", validSymbols),Cell("3", validSymbols)).toString())
        assert(board[3].toString() == listOf(Cell("4", validSymbols),Cell("3", validSymbols),Cell("1", validSymbols),Cell("2", validSymbols)).toString())
    }

    @Test
    fun multipleChanges() {
        val validSymbols = mutableListOf("1", "2", "3", "4")
        val board = listOf(
            listOf(Cell("-", validSymbols),Cell("2", validSymbols),Cell("3", validSymbols),Cell("4", validSymbols)),
            listOf(Cell("3", validSymbols),Cell("4", validSymbols),Cell("-", validSymbols),Cell("1", validSymbols)),
            listOf(Cell("2", validSymbols),Cell("-", validSymbols),Cell("4", validSymbols),Cell("3", validSymbols)),
            listOf(Cell("4", validSymbols),Cell("3", validSymbols),Cell("1", validSymbols),Cell("-", validSymbols)),
        )
        QuickRowScan().execute(board,validSymbols)
        assert(board[0].toString() == listOf(Cell("1", validSymbols),Cell("2", validSymbols),Cell("3", validSymbols),Cell("4", validSymbols)).toString())
        assert(board[1].toString() == listOf(Cell("3", validSymbols),Cell("4", validSymbols),Cell("2", validSymbols),Cell("1", validSymbols)).toString())
        assert(board[2].toString() == listOf(Cell("2", validSymbols),Cell("1", validSymbols),Cell("4", validSymbols),Cell("3", validSymbols)).toString())
        assert(board[3].toString() == listOf(Cell("4", validSymbols),Cell("3", validSymbols),Cell("1", validSymbols),Cell("2", validSymbols)).toString())
    }
}