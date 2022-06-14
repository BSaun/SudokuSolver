import java.io.File

class TextFileReader {
    fun readFile(fileName : String) {
        var lines : List<String> = File(fileName).readLines()
        if (lines.last() == "") {
            lines = lines.dropLast(1)
        }
        println(lines)
    }
}