
/**
 * Represents a 3 by 3 square containing numbers.
 *
 * @author Max Freeman
 * @version 08/12/21
 */
public class Square3x3
{
    private int[][] _square;
    
    private final int FIRST_INDEX_NUM = 0;
    private final int LAST_INDEX_NUM = 2;
    private final int MAX_ROW_SIZE = 3;
    private final int MAX_COL_SIZE = 3;
    private final int MIN_ROW_SIZE = 1;
    private final int DEFAULT_VAL = -1;
    private final int FIRST_N = 1;
    private final int LAST_N = 9;

    
    /**
     * Constructs a two-dimensional array with the values of -1 in each cell
     */
    public Square3x3(){
        
        _square = new int [MAX_ROW_SIZE][MAX_COL_SIZE];
        
        for (int row = FIRST_INDEX_NUM; row < _square.length; row++)
            
            for (int col = FIRST_INDEX_NUM; col < _square.length; col++){
            
                _square[row][col] = DEFAULT_VAL;
                
            }
    }
    
    
    
    /**
     * Constructs a two-dimensional array with values from another array and rest of unfilled values is -1
     * @param array another array of x dimensions
     */
    public Square3x3(int[][]array){
        this();
        
        if (array != null){
    
            
            for (int row = FIRST_INDEX_NUM; row < _square.length && row < array.length; row++){
            
                for (int col = FIRST_INDEX_NUM; col < _square[row].length && col < array[row].length; col++){
                    
                        _square[row][col] = array[row][col];
                
                }
        
            }
        }
    }
    
    
    /**
     * Copy constructor for objects of class Square3x3.
     * Constructs a 2-Dimensional array of array size 3x3, whose vales are taken from another Square3x3 two-dimensional array
     * @param other another Square3x3 array
     */    
        
    public Square3x3(Square3x3 other){
        
        this(other != null ? other._square : null);
        
        
    }

    
    /**
     * Returns cell at a specific row and column
     * @param row row in the array
     * @param col column in the array
     * @return value at row and column
     */
    public int getCell(int row, int col){
        
        if (row >=FIRST_INDEX_NUM && row <= LAST_INDEX_NUM &&
        col >=FIRST_INDEX_NUM && col <= LAST_INDEX_NUM){
            return _square[row][col];
        }else
            return DEFAULT_VAL;

    }
    
    
    /**
     * Sets value at a specific cell
     * @param row row in the array
     * @param col column in the array
     * @param value value to set at row,column index
     */
    public void setXY(int row, int col, int value){
        if (row >=FIRST_INDEX_NUM && row <= LAST_INDEX_NUM &&
        col >=FIRST_INDEX_NUM && col <= LAST_INDEX_NUM){
            _square[row][col] = value;
        }
    }
    
    
    /**
     * Returns a String which looks like a square
     * @return a sentence in format: "x\ty\tz\n" 3 times
     */
    public String toString(){
        
        String output = "";
        for(int row = FIRST_INDEX_NUM; row < MAX_ROW_SIZE; row++){
            for(int col = FIRST_INDEX_NUM; col < MAX_COL_SIZE; col++){
                output += _square[row][col] ;

                if(col != LAST_INDEX_NUM){ //only if its not the last iteration it will add the space
                    output += "\t";
                }
            }
            output += "\n";
        }
        
        return output;
    }
     
     
     /**
     * Checks if the board contains all values 1-9
     * @return true if board contains only 1-9, false otherwaize
     */
    public boolean allThere(){
         
        boolean[] val = new boolean[10];
       // Uses whosThereRow method to check numbers in each row specifically  
       for(int row = FIRST_INDEX_NUM; row < MAX_ROW_SIZE; row++){
        whosThereRow(row,val);
       }
       
       for (int i = MIN_ROW_SIZE; i < val.length; i++){
            if (val[i] == false){
                return false;
            }
             
        }
        return true;
    }
    
     
    /**
     * Gets row number and boolean with 10 indexes, for each 1-9 cell values in the specific row it'll set the
     * value at the index ( cell values ) to true ( ex. 1,3,5 will set in the values array
     * values[1],values[5],values[3]=true )
     * @param row row between 0-2
     * @param values a boolean array
     */ 
    public void whosThereRow (int row, boolean[] values ){
        
        //check if the row is valid num
        if (row >= FIRST_INDEX_NUM && row < MAX_ROW_SIZE){
        
            for (int col = FIRST_INDEX_NUM; col < MAX_COL_SIZE; col++){
                //check if the cell's value is valid
                if (_square[row][col] >= FIRST_N &&
                _square[row][col] <= LAST_N ){
                    values[_square[row][col]] = true;
                }
            
            }
        
        }
    }
     
    
    /**
     * Gets column number and boolean with 10 indexes, for each 1-9 cell values in the specific column it'll set the
     * value at the index ( cell values ) to true ( ex. 1,3,5 will set in the values array
     * values[1],values[5],values[3]=true )
     * @param col column between 0-2
     * @param values a boolean array
     */
    public void whosThereCol (int col, boolean[] values ){
        
        //check if the col is valid num
        if (col >= FIRST_INDEX_NUM && col < MAX_ROW_SIZE){
        
            for (int row = FIRST_INDEX_NUM; row < MAX_ROW_SIZE; row++){
                //check if the cell's value is valid
                if (_square[row][col] >= FIRST_N &&
                _square[row][col] <= LAST_N ){
                    values[_square[row][col]] = true;
                }
            
            }
        
        }
    }
        
}