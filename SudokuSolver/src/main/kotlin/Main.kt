fun main() {
    val files = listOf("Puzzle-4x4-0001.txt",
    "Puzzle-4x4-0002.txt",
    "Puzzle-4x4-0101.txt",
    "Puzzle-4x4-0201.txt",
    "Puzzle-4x4-0901.txt",
    "Puzzle-4x4-0902.txt",
    "Puzzle-4x4-0904.txt",
    "Puzzle-4x4-0905.txt",
    "Puzzle-4x4-0906.txt",
    "Puzzle-4x4-0907.txt",
    "Puzzle-9x9-0001.txt",
    "Puzzle-9x9-0002.txt",
    "Puzzle-9x9-0101.txt",
    "Puzzle-9x9-0102.txt",
    "Puzzle-9x9-0103.txt",
    "Puzzle-9x9-0201.txt",
    "Puzzle-9x9-0202.txt",
    "Puzzle-9x9-0203.txt",
    "Puzzle-9x9-0204.txt",
    "Puzzle-9x9-0205.txt",
    "Puzzle-9x9-0206.txt",
    "Puzzle-9x9-0301.txt",
    "Puzzle-9x9-0302.txt",
    "Puzzle-9x9-0401.txt",
    "Puzzle-9x9-0901.txt",
    "Puzzle-16x16-0001.txt",
    "Puzzle-16x16-0002.txt",
    "Puzzle-16x16-0101.txt",
    "Puzzle-16x16-0102.txt",
    "Puzzle-16x16-0201.txt",
    "Puzzle-16x16-0301.txt",
    "Puzzle-16x16-0401.txt",
    "Puzzle-16x16-0901.txt",
    "Puzzle-16x16-0902.txt",
    "Puzzle-25x25-0101.txt",
    "Puzzle-25x25-0901.txt",
    "Puzzle-25x25-0902.txt",
    "Puzzle-25x25-0903.txt",
    "Puzzle-25x25-0904.txt",
    "Puzzle-36x36-01-A001.txt",
    "Puzzle-36x36-01-B001.txt",
    "Puzzle-36x36-01-C001.txt")
    for (file in files) {
        val fileReader = SudokuFileReader()
        fileReader.readFile("SamplePuzzles//Input//$file")
    }
}