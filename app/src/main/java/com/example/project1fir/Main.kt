import java.util.*
/**
 * TicTacToe class implements the interface
 * @author Harsh Gandhi
 * @date 2/2/2023
 */

val FIR_board = FourInARow()

/** The entry main method (the program starts here)  */
fun main() {
    var currentState: Int = GameConstants.PLAYING
    var userInput = ""

    //game loop
    do {
        FIR_board.printBoard()
        // until the player provides a valid position keep running the loop.
        var validPosition: Boolean = false
        while (validPosition != true) {
            println("What's your move? Enter q to quit")
            // read the input.
            userInput = readln()
            // if the user inputs 1 then end the game.
            if (userInput == "q") {
                currentState = GameConstants.TIE
                break;
            }
            // convert the cell number to row and column number. If it is not out of bounds then call the setMove method.
            var playerMove: Int = Integer.parseInt(userInput)
            val row: Int = playerMove / GameConstants.ROWS
            val column: Int = playerMove % GameConstants.COLS
            if (row > GameConstants.ROWS - 1 || column > GameConstants.COLS - 1) {
                println("position is out of bounds")
            } else {
                FIR_board.setMove(1, playerMove)
                validPosition = true
            }
        }
        // check for winner after the player move. If blue or red won or if is a tie then end the game.
        var winner: Int = FIR_board.checkForWinner()
        if (winner == GameConstants.BLUE_WON) {
            println("player 1 is winner")
            FIR_board.printBoard()
            currentState = GameConstants.BLUE_WON
            break
        } else if (winner == GameConstants.RED_WON) {
            println("You lost!!")
            FIR_board.printBoard()
            currentState = GameConstants.RED_WON
            break
        } else if (winner == GameConstants.TIE) {
            println("It's a tie!!")
            FIR_board.printBoard()
            currentState = GameConstants.TIE
            break
        }

        // call for computer move
        var computerMove: Int = FIR_board.computerMove
        FIR_board.setMove(2, computerMove)

        // check for winner after the computer move. If blue or red won or if is a tie then end the game.
        winner = FIR_board.checkForWinner()
        if (winner == GameConstants.BLUE_WON) {
            println("You are the winner!!!")
            FIR_board.printBoard()
            currentState = GameConstants.BLUE_WON
        } else if (winner == 2) {
            println("You lost!!")
            FIR_board.printBoard()
            currentState = GameConstants.RED_WON
        } else if (winner == GameConstants.TIE) {
            println("It's a tie!!")
            FIR_board.printBoard()
            currentState = GameConstants.TIE
        }

        /** TODO implement the game loop
         * 1- accept user move
         * 2- call getComputerMove
         * 3- Check for winner
         * 4- Print game end messages in case of Win , Lose or Tie !
         */
    } while (currentState == GameConstants.PLAYING && userInput != "q")
// repeat if not game-over
}
 