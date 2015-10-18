Name : Aastha Gupta

Programming Language: java

Code Structure: 

File Name : maxconnect4.java

Function Name: main
Function Description: This function first maps commandline input to the variables in the code. Then, it runs the program in one-move mode or interactive mode (as specified by the user).

File Name : GameBoard.java

Function Name : getblocks
Function Description: This function takes the current player as arguments and returns an integer type . This function basically calculates the number of times the current player can block the opposite player to make a score (for the give board state). 

File Name: Aiplayer.java

Function Name : findBestPlay
Function Description : This function takes 3 arguments i.e. an object of GameBoard, current player and the depthlevel returning the column of play . This function performs the same task as alphabetadecision function in alpha beta pruning algorithm.

Function Name: max_value
Function Description : This function takes 4 arguments i.e. an object of GameBoard, alpha, beta and the depthlevel returning the utility of the leaf node. This function performs the same task as MaxValue function in alpha beta pruning algorithm. 

Function Name: min_value
Function Description : This function takes 4 arguments i.e. an object of GameBoard, alpha, beta and the depthlevel returning the utility of the leaf node. This function performs the same task as MinValue function in alpha beta pruning algorithm. 

Function Name: evalfuction
Function Description: This function takes 1 argument i.e. an object of GameBoard returning the utility value for the current state of the board. The function calculates utility by adding the weighted sum of current player score, current player blocks, number of possible 3 moves, number of possible 2 moves, number of possible 1 moves and subtracting opposite player score.

Function Name: getutility
Function Description: This function takes 1 argument i.e. an object of GameBoard returning the count of various move combinations for the current state of the board.

File Name: node.java
Class name : node
Class Description : The class node has 2 integers as data members i.e. the currenti and the currentj.
 
Compilation Instruction: The Entry point of the code is in maxconnect4.java file. Use standard java commands to compile and run the code.