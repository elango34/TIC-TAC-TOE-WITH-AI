# TIC-TAC-TOE

Everybody remembers this paper-and-pencil game from childhood: Tic-Tac-Toe, also known as Noughts and crosses or Xs and Os. A single mistake usually costs you the game, but thankfully it is simple enough that most players discover the best strategy quickly. Execute the program and get playing!

There are Nine choices you can play with such as

    start easy user
    start user easy
    start easy easy
    start user user
    start medium user
    start user medium
    start hard user
    start user hard
    start hard hard

Then enter co-ordinates to play.

<img src="https://github.com/elango34/TIC-TAC-TOE-WITH-AI/blob/master/Tic%20tac%20toe%20demonstration.gif" width="800" height="500" />

    
First choice is "X" and the second one is "O". Here user is you (Human).

"easy" means opponent move is only random uses only Math.Random method. so, user can easily win.

"medium" means opponent move is quite smart. so, there is fifty-fifty chance of user and opponent win. It uses looping and conditional statement.

"hard" means opponent play optimally using MiniMax algorithm.

## What is Minimax?
Minimax is a artificial intelligence applied in two player games, such as tic-tac-toe, checkers, chess and go. This games are known as zero-sum games, because in a mathematical representation: one player wins (+1) and other player loses (-1) or both of anyone not to win (0).

## How does it works?
The algorithm search, recursively, the best move that leads the *Max* player to win or not lose (draw). It consider the current state of the game and the available moves at that state, then for each valid move it plays (alternating *min* and *max*) until it finds a terminal state (win, draw or lose).

A Minimax algorithm can be best defined as a recursive function that does the following things:

    * Return a value if a terminal state is found (+10, 0, -10)
    * Go through available spots on the board
    * Call the minimax function on each available spot (recursion)
    * Evaluate returning values from function calls
    * And return the best value

## Pseudocode
    function minimax(board, depth, isMaximizingPlayer):
    
        if current board state is a terminal state :
            return value of the board
        
        if isMaximizingPlayer :
            bestVal = -INFINITY 
            for each move in board :
                value = minimax(board, depth+1, false)
                bestVal = max( bestVal, value) 
            return bestVal
    
        else :
            bestVal = +INFINITY 
            for each move in board :
                value = minimax(board, depth+1, true)
                bestVal = min( bestVal, value) 
            return bestVal
     
    
 ## For more information visit
 Wikipédia: https://en.wikipedia.org/wiki/Minimax
 
 Geeks for Geeks: https://www.geeksforgeeks.org/minimax-algorithm-in-game-theory-set-3-tic-tac-toe-ai-finding-optimal-move/

