
/**
 * Constructs a sudoku 9x9 board.
 *
 * @author Max Freeman
 * @version 08/12/21
 */
public class Sudoku
{
    private Square3x3[][] _sudokuBoard;
    
    private final int MAX_ROW_SIZE = 3;
    private final int MAX_COL_SIZE = 3;
    private final int LAST_N = 9;
    private final int FIRST_INDEX_NUM = 0;
    private final int MIN_ROW_SIZE = 1;
    
    
    /**
     * Constructs a new Sudoku board filled with -1 in all cells using Square3x3 constructor
     * @see Square3x3
     */
    public Sudoku(){
        
        _sudokuBoard = new Square3x3[MAX_COL_SIZE][MAX_ROW_SIZE];
        
        for (int row = FIRST_INDEX_NUM; row < MAX_ROW_SIZE; row++){
            
            for (int col = FIRST_INDEX_NUM; col < MAX_COL_SIZE; col++){
            
                _sudokuBoard[row][col] = new Square3x3();
        
                }
            }
        
        
    
    }
    
    
    /**
     * Constructs a new Sudoku board and copies all values from a two-dimensional array of Square3x3
     * @param square3x3Array - A two-dimensional 3x3 array of Square3x3
     * @see Square3x3
     */
    public Sudoku(Square3x3[][] square3x3Array){
        
        this();
        
        if(square3x3Array != null){
        
            for (int row = FIRST_INDEX_NUM; row < MAX_ROW_SIZE; row++){
            
                for (int col = FIRST_INDEX_NUM; col < MAX_COL_SIZE; col++){
                
                    _sudokuBoard[row][col] = new Square3x3(square3x3Array[row][col]);
        
                }   
              } 
    
        }
    
    }
    
    
    /**
     * Private function responsible to check every row in the sudoku board
     * @return true if all numbers ( 1-9 ) are valid and false otherwise
     */
    private boolean checkRow(){
        
        
        // The function takes the current row of the Sudoku and the row it should check inside the square
        // After taking both of these it's checking for board 0 to board 2 the numbers in the same row and
        // returns true if all numbers present in the same Sudoku board
        
        for (int row = FIRST_INDEX_NUM; row < MAX_ROW_SIZE; row ++){
            for (int col = FIRST_INDEX_NUM; col < MAX_COL_SIZE; col++){
                boolean[] values = new boolean[10];
                for (int s = FIRST_INDEX_NUM; s < MAX_ROW_SIZE; s++){
                    _sudokuBoard[row][s].whosThereRow(col, values); // Checks the same row in each square inside the board for ..its values.
            }
            for (int t = MIN_ROW_SIZE; t <= LAST_N; t++){
                if(!values[t])
                return false;
                }
            }
        }  
        
        return true;
    }
    
    
    /**
     * Private function responsible to check every column in the Sudoku board
     * @return true if all numbers are valid ( 1-9 ) and false otherwise
     */
    private boolean checkCol(){
        
        
        // The function takes the current column of the Sudoku and the column should check inside the square
        // After taking both of these it's checking for board 0 to board 2 the numbers in the same column and
        // returns true if all numbers present in the same Sudoku board
        
        for (int row = FIRST_INDEX_NUM; row < MAX_ROW_SIZE; row ++){
            for (int col = FIRST_INDEX_NUM; col < MAX_COL_SIZE; col++){
                boolean[] values = new boolean[10];
                for (int s = FIRST_INDEX_NUM; s < MAX_ROW_SIZE; s++){
                    _sudokuBoard[s][row].whosThereCol(col, values); // Checks the same column in each square inside the board for its values.
                }
                for (int t = MIN_ROW_SIZE; t <= LAST_N; t++){
                    if (!values[t]){
                        return false;
                    }
                }
                
            }
            
        }
        
        return true;
    }
    
    
    /**
     * Checks if the Sudoku board is valid, true if it's valid and false otherwise
     * @return true if valid and false otherwise
     */
    public Boolean isValid(){
        
        // This function does this step for every square in the Sudoku board:
        // It takes the block and checks if it's null, if not it checks if all numbers ( 1-9 ) are there.
        // Then it checks for each row in the Sudoku if it's a valid row ( 1-9 numbers are present )
        // The final validation is the same thing as the row but for the column
        
        if(!checkRow())
        return false;
        if(!checkCol())
        return false;
        
        for (int row = FIRST_INDEX_NUM; row < MAX_ROW_SIZE; row++){
            for (int col = FIRST_INDEX_NUM; col < MAX_COL_SIZE; col++){
            if (!_sudokuBoard[row][col].allThere()){
                return false;
            }
            
          }
        }
        
        return true;
    }

}