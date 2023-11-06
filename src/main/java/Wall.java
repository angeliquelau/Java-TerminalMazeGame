package edu.curtin.Assignment1_20322904;

// import java.util.HashMap;
// import java.util.List;

public class Wall extends Objects
{
    private String type; // either vertical or horizontal wall
    private int row;
    private int col;

    public Wall(ObjectInterface inObj, String inType, int inRow, int inCol) 
    {
        super(inObj);
        type = inType;
        row = inRow;
        col = inCol;
    }

    @Override
    public String[][] print(String[][] wallStr/*, int pRow, int pCol*/) 
    {
        int rowChar = row * 2 + 1;
        int colChar = col * 4 + 1;
        int getRowChar = obj.getRow() * 2 + 1;
        int getColChar = obj.getCol() * 4 + 1;

        // System.out.println("walls: " + rowChar + " " + colChar);

        if(type.equals("WV") && (rowChar == getRowChar && colChar == getColChar))
        {
            colChar--;
            wallStr[rowChar][colChar] = "\u2502";
        
        }
        if(type.equals("WH") && (rowChar == getRowChar && colChar == getColChar))
        {
            //print unicode 3 times because its horizontal
            rowChar--;
            wallStr[rowChar][colChar++] = "\u2500";
            wallStr[rowChar][colChar++] = "\u2500";
            wallStr[rowChar][colChar++] = "\u2500";
        }
        return wallStr;
    }

    @Override
    public String[][] updatedPrint(String[][] wallStr, int pRow, int pCol, int prevRow, int prevCol, int i, int j) 
    {
        return obj.updatedPrint(wallStr, pRow, pCol, prevRow, prevCol, i, j);
    }

    @Override
    public int getRow() 
    {
        return obj.getRow();
    }

    @Override
    public int getCol() 
    {
        return obj.getCol();
    }
    
    @Override
    public String getType() 
    {
        return type;
    }

    @Override
    public String toString() 
    {
        return getRow() + " " + getCol();
    }
}
