# Description
This project implements the reversi game. The game keeps changing 
and adding new disks to the board until no player can move. 

If a player cannot move but the opponent can, then the opponent has
a chance to move.

# Structure
1. **Board** - Stores the information about the board, validates all the
moves and prints the boar.
1. **Game** - Implements the game workflow. Stores information about the
board, calls for input and asks the board to update its state.
1. **Input** - Uses regular expressions to validate input and returns
a move in board coordinates
1. **Main** - Main starting class
1. **Move** - Translates UI coordinates to board cordinates

# Setup 
Java 7/8 is required.
Maven

To execute the application, run:

```bash
mv clean package exec:java
```