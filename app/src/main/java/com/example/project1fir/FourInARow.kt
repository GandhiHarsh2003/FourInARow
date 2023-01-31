import java.util.*

/**
 * TicTacToe class implements the interface
 * @author relkharboutly
 * @date 2/12/2022
 */
class FourInARow
/**
 * clear board and set current player
 */
    : IGame {
    // game board in 2D array initialized to zeros
    private val board = Array(GameConstants.ROWS) { IntArray(GameConstants.COLS) { 0 } }

    override fun clearBoard() {
        // TODO Auto-generated method stub
        val rows = GameConstants.ROWS
        val columns = GameConstants.COLS
        for (i in 0 until rows) {
            for (j in 0 until columns) {
                board[i][j] = 0
            }
        }
    }

    override fun setMove(player: Int, location: Int) {
        val row: Int = location / GameConstants.ROWS
        val column: Int = location % GameConstants.COLS
        if (player == 1) {
            board[row][column] = 1
        }
        if (player == 2) {
            board[row][column] = 2
        }
    }

    override val computerMove: Int
        get() {
            var valid: Boolean = false
            while (!valid) {
                val move = (0 until GameConstants.ROWS * GameConstants.COLS).random() // TODO Auto-generated method stub
                val row: Int = move / GameConstants.ROWS
                val column: Int = move % GameConstants.COLS
                if (board[row][column] == 0) {
                    valid = true
                    return move
                }
            }
            return 0
        }

    override fun checkForWinner(): Int {
        // TODO Auto-generated method stub
        // check horizontal
        for (i in 0 until GameConstants.ROWS) {
            for (j in 0 until GameConstants.COLS - 3) {
                if (board[i][j] != GameConstants.EMPTY && board[i][j] == board[i][j + 1] && board[i][j] == board[i][j + 2] && board[i][j] == board[i][j + 3]) {
                    if (board[i][j] == 1) {
                        return GameConstants.BLUE_WON
                    } else {
                        return board[i][j]
                    }
                }
            }
        }

        // check vertical
        for (i in 0 until GameConstants.ROWS - 3) {
            for (j in 0 until GameConstants.COLS) {
                if (board[i][j] != GameConstants.EMPTY && board[i][j] == board[i + 1][j] && board[i][j] == board[i + 2][j] && board[i][j] == board[i + 3][j]) {
                    if (board[i][j] == 1) {
                        return GameConstants.BLUE_WON
                    } else {
                        return board[i][j]
                    }
                }
            }
        }

        // check diagonal
        for (i in 0 until GameConstants.ROWS - 3) {
            for (j in 0 until GameConstants.COLS - 3) {
                if (board[i][j] != GameConstants.EMPTY && board[i][j] == board[i + 1][j + 1] && board[i][j] == board[i + 2][j + 2] && board[i][j] == board[i + 3][j + 3]) {
                    if (board[i][j] == 1) {
                        return GameConstants.BLUE_WON
                    } else {
                        return board[i][j]
                    }
                }
            }
        }
        for (i in 0 until GameConstants.ROWS - 3) {
            for (j in 3 until GameConstants.COLS) {
                if (board[i][j] != GameConstants.EMPTY && board[i][j] == board[i + 1][j - 1] && board[i][j] == board[i + 2][j - 2] && board[i][j] == board[i + 3][j - 3]) {
                    if (board[i][j] == 1) {
                        return GameConstants.BLUE_WON
                    } else {
                        return board[i][j]
                    }
                }
            }
        }

        // check if it is a tie
        var tie: Boolean = true
        for (i in 0 until GameConstants.ROWS) {
            for (j in 0 until GameConstants.COLS) {
                if (board[i][j] == 0) {
                    tie = false
                    break;
                }
            }
        }
        if (tie) {
            return GameConstants.TIE
        }
        return GameConstants.PLAYING
    }

    /**
     * Print the game board
     */
    fun printBoard() {
        for (row in 0 until GameConstants.ROWS) {
            for (col in 0 until GameConstants.COLS) {
                printCell(board[row][col]) // print each of the cells
                if (col != GameConstants.COLS - 1) {
                    print("|") // print vertical partition
                }
            }
            println()
            if (row != GameConstants.ROWS - 1) {
                println("-----------------------") // print horizontal partition
            }
        }
        println()
    }

    /**
     * Print a cell with the specified "content"
     * @param content either BLUE, RED or EMPTY
     */
    fun printCell(content: Int) {
        when (content) {
            GameConstants.EMPTY -> print("   ")
            GameConstants.BLUE -> print(" X ")
            GameConstants.RED -> print(" O ")
        }
    }
}

