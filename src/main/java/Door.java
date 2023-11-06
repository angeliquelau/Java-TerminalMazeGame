package edu.curtin.Assignment1_20322904;


// import java.util.List;

public class Door extends Objects 
{
    private String type; //horizontal or vertical door
    private int row;
    private int col;
    private int colour; //6 colours available

    public Door(ObjectInterface inObj, String inType, int inRow, int inCol, int inColour) 
    {
        super(inObj);
        type = inType;
        row = inRow;
        col = inCol;
        colour = inColour;
    }

    @Override
    public String[][] print(String[][] doorStr/*, int pRow, int pCol*/) //throws AssignmentException
    {
        int rowChar = row * 2 + 1;
        int colChar = col * 4 + 1;
        int getRowChar = obj.getRow() * 2 + 1;
        int getColChar = obj.getCol() * 4 + 1;

        // if(rowChar == 0 || colChar == 0) //if any one is 0, it means its at the border
        // {
        //     throw new AssignmentException("Invalid to have doors at the border");
        // }
        //if its vertical door and its at that position, print door there
        if(type.equals("DV") && (rowChar == getRowChar && colChar == getColChar))
        {
            //\033[31m\u2592\033[m = \033[31m is the colour, \u2592 is the unicode for door, \033[m resets to default colour
            switch(colour)
            {
                case 1: //red
                    colChar--;
                    doorStr[rowChar][colChar] = "\033[31m\u2592\033[m";
                    break;

                case 2: //green
                    colChar--;
                    doorStr[rowChar][colChar] = "\033[32m\u2592\033[m";
                    break;
                    
                case 3: //yellow
                    colChar--;
                    doorStr[rowChar][colChar] = "\033[33m\u2592\033[m";
                    break;

                case 4: //blue
                    colChar--;
                    doorStr[rowChar][colChar] = "\033[34m\u2592\033[m";
                    break;
                    
                case 5: //magenta
                    colChar--;
                    doorStr[rowChar][colChar] = "\033[35m\u2592\033[m";
                    break;

                case 6: //cyan
                    colChar--;
                    doorStr[rowChar][colChar] = "\033[36m\u2592\033[m";
                    break;
            }   
        }
        //if its horizontal door and its at that position, print door there
        if(type.equals("DH") && (rowChar == getRowChar && colChar == getColChar))
        {
            //\033[31m\u2592\u2592\u2592\033[m = \033[31m is the colour, \u2592 is the unicode, \033[m resets to default colour
            //print unicode 3 times because its horizontal
            switch(colour)
            {
                case 1: //red
                    rowChar--;
                    doorStr[rowChar][colChar++] = "\033[31m\u2592\033[m";
                    doorStr[rowChar][colChar++] = "\033[31m\u2592\033[m";
                    doorStr[rowChar][colChar++] = "\033[31m\u2592\033[m";
                    break;

                case 2: //green
                    rowChar--;
                    doorStr[rowChar][colChar++] = "\033[32m\u2592\033[m";
                    doorStr[rowChar][colChar++] = "\033[32m\u2592\033[m";
                    doorStr[rowChar][colChar++] = "\033[32m\u2592\033[m";
                    
                    break;
                    
                case 3: //yellow
                    rowChar--;
                    doorStr[rowChar][colChar++] = "\033[33m\u2592\033[m";
                    doorStr[rowChar][colChar++] = "\033[33m\u2592\033[m";
                    doorStr[rowChar][colChar++] = "\033[33m\u2592\033[m";
                    break;

                case 4: //blue
                    rowChar--;
                    doorStr[rowChar][colChar++] = "\033[34m\u2592\033[m";
                    doorStr[rowChar][colChar++] = "\033[34m\u2592\033[m";
                    doorStr[rowChar][colChar++] = "\033[34m\u2592\033[m";
                    break;
                    
                case 5: //magenta
                    rowChar--;
                    doorStr[rowChar][colChar++] = "\033[35m\u2592\033[m";
                    doorStr[rowChar][colChar++] = "\033[35m\u2592\033[m";
                    doorStr[rowChar][colChar++] = "\033[35m\u2592\033[m";
                    break;

                case 6: //cyan
                    rowChar--;
                    doorStr[rowChar][colChar++] = "\033[36m\u2592\033[m";
                    doorStr[rowChar][colChar++] = "\033[36m\u2592\033[m";
                    doorStr[rowChar][colChar++] = "\033[36m\u2592\033[m";
                    break;
            }   
            
        }
        return doorStr;
    }
    
    @Override
    public String[][] updatedPrint(String[][] doorStr, int pRow, int pCol, int prevRow, int prevCol, int i, int j) 
    {
        return obj.updatedPrint(doorStr, pRow, pCol, prevRow, prevCol, i, j);
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

    public int getColour()
    {
        return colour;
    }

    @Override
    public String toString() 
    {
        return getRow() + " " + getCol();
    }
}
