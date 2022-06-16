import org.junit.jupiter.api.Test

class TestScanPotential {
    @Test
    fun testScanPotential() {
        val validSymbols = mutableListOf("1", "2", "3", "4")
        val board = listOf(
            listOf(Cell("-", validSymbols),Cell("2", validSymbols),Cell("3", validSymbols),Cell("4", validSymbols)),
            listOf(Cell("3", validSymbols),Cell("-", validSymbols),Cell("2", validSymbols),Cell("-", validSymbols)),
            listOf(Cell("2", validSymbols),Cell("-", validSymbols),Cell("4", validSymbols),Cell("3", validSymbols)),
            listOf(Cell("4", validSymbols),Cell("3", validSymbols),Cell("-", validSymbols),Cell("2", validSymbols)),
        )
        ScanPotential().execute(board,validSymbols)
        assert(board[0][0].potentialValues == mutableListOf("1"))
        assert(board[1][1].potentialValues == mutableListOf("1","4"))
        assert(board[1][3].potentialValues == mutableListOf("1"))
        assert(board[2][1].potentialValues == mutableListOf("1"))
        assert(board[3][2].potentialValues == mutableListOf("1"))
    }
}