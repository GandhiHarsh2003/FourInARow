import java.util.*


val FIR_board = FourInARow()

/** The entry main method (the program starts here)  */
fun main() {
    var currentState: Int = GameConstants.PLAYING
    var userInput = ""

    //game loop
    do {
        FIR_board.printBoard()
        var validPosition: Boolean = false
        while (validPosition != true) {
            println("What's your move? Enter q to quit")
            userInput = readln()
            if (userInput == "q") {
                currentState = GameConstants.TIE
                break;
            }
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
        // check for winner after the player move
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

        // computer move
        var computerMove: Int = FIR_board.computerMove
        FIR_board.setMove(2, computerMove)

        // check for winner again after the move of computer
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
 