fun main() {

 fun isValidSudoku(board: Array<CharArray>): Boolean {
    val digits = '1'..'9'

    // التحقق من الصفوف
    for (row in board) {
        val seen = mutableSetOf<Char>()
        for (cell in row) {
            if (cell == '-') continue
            if (cell !in digits || !seen.add(cell)) return false
        }
    }

    // التحقق من الأعمدة
    for (col in 0 until 3) {
        val seen = mutableSetOf<Char>()
        for (row in 0 until 3) {
            val cell = board[row][col]
            if (cell == '-') continue
            if (cell !in digits || !seen.add(cell)) return false
        }
    }

    // التحقق من المربّع الفرعي (3×3)
    val seen = mutableSetOf<Char>()
    for (row in 0 until 3) {
        for (col in 0 until 3) {
            val cell = board[row][col]
            if (cell == '-') continue
            if (cell !in digits || !seen.add(cell)) return false
        }
    }

    return true
}

    val validSudoku = arrayOf(
        charArrayOf('1', '2', '3'),
        charArrayOf('4', '5', '6'),
        charArrayOf('7', '8', '9')
    )
    val validSudokuWithDash = arrayOf(
        charArrayOf('1', '2', '3'),
        charArrayOf('4', '-', '6'),
        charArrayOf('7', '8', '9')
    )

    val emptySudoku = arrayOf(
        charArrayOf('-', '-', '-'),
        charArrayOf('-', '-', '-'),
        charArrayOf('-', '-', '-')
    )
    val SudokuContainChar = arrayOf(
        charArrayOf('1', '2', '3'),
        charArrayOf('x', '-', '6'), // حرف غير مسموح
        charArrayOf('7', '8', '9')
    )
    val duplicateRow = arrayOf(
        charArrayOf('1', '2', '2'), // الرقم 2 مكرر في الصف الأول
        charArrayOf('4', '5', '6'),
        charArrayOf('7', '8', '9')
    )
    val duplicateColumn = arrayOf(
        charArrayOf('1', '2', '3'),
        charArrayOf('4', '5', '6'),
        charArrayOf('1', '8', '9') // الرقم 1 مكرر في العمود الأول
    )
    val duplicateGrid = arrayOf(
        charArrayOf('1', '2', '3'),
        charArrayOf('4', '5', '6'),
        charArrayOf('7', '8', '1') // الرقم 1 مكرر في الشبكة الكاملة
    )
    println(isValidSudoku(duplicateGrid))
    check(name = "valid sudoku" , result = isValidSudoku(validSudoku), correctResult = true)
    check(name = "valid sudoku" , result = isValidSudoku(validSudokuWithDash), correctResult = true)
    check(name = "invalid sudoku  " , result = isValidSudoku(SudokuContainChar), correctResult = false)
    check(name = "invalid sudoku " , result = isValidSudoku(emptySudoku), correctResult = false)
    check(name = "invalid sudoku due to duplicate Row" , result = isValidSudoku(duplicateRow), correctResult = false)
    check(name = "invalid sudoku due to duplicate Column" , result = isValidSudoku(duplicateColumn), correctResult = false)
    check(name = "invalid sudoku due to duplicate Grid" , result = isValidSudoku(duplicateGrid), correctResult = false)


}
fun check(name: String, result: Boolean, correctResult: Boolean) {
    if (result == correctResult) {
        println("Success -> $name")
    } else {
        println("Falid -> $name")
    }
}