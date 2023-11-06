package edu.curtin.Assignment1_20322904;

// import java.util.List;

/*
*
* just the map border
*
*/
public class PlainMap implements ObjectInterface
{
    //fields
    //row and column for size and coordinates of the objects
    private int row;
    private int col;
    
    //constructor
    public PlainMap()
    {
        row = 0;
        col = 0;
    }
    
    //alternate constructor
    public PlainMap(int inRow, int inCol)
    {
        row = inRow;
        col = inCol;
    }

    @Override
    public String[][] print(String[][] mapStr/*, int pRow, int pCol*/) 
    {
        int rowChar = getRow() * 2 + 1;
        int colChar = getCol() * 4 + 1; 

        // System.out.println("row and col " + row + " " + col);
        // System.out.println("rowChar and colChar " + rowChar + " " + colChar);

        for(int i = 0; i < rowChar; i++)
        {
            for(int j = 0; j < colChar; j++)
            {
                //borders
                //print the 4 corners
                if(i == 0 && j == 0)
                {
                    
                    mapStr[i][j] = "\u250c"; 
                }
                else if(i == 0 && j == colChar - 1)
                {
                    mapStr[i][j] = "\u2510";
                }
                else if(i == rowChar - 1 && j == 0)
                {
                    mapStr[i][j] = "\u2514";
                }
                else if(i == rowChar - 1 && j == colChar - 1)
                {
                    mapStr[i][j] = "\u2518";
                }
                //print borders between the corners
                else if(i == 0 || i == rowChar - 1) 
                {
                    mapStr[i][j] = "\u2500";
                }
                else if(j == 0 || j == colChar - 1)
                {
                    mapStr[i][j] = "\u2502";
                }
                else
                {
                    mapStr[i][j] = " ";
                }
            }
        }
        return mapStr;
    }
    
    @Override
    public String[][] updatedPrint(String[][] mapStr, int pRow, int pCol, int prevRow, int prevCol, int i, int j) 
    {
        return mapStr;
    }

    //getters
    @Override
    public int getRow()
    {
        return row;
    }

    @Override
    public int getCol() 
    {
        return col;
    }

    @Override
    public String getType() 
    {
        return "grid";
    }

    @Override
    public String toString() 
    {
        return getRow() + " " + getCol() + " " + getType();
    }
}
