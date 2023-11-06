package edu.curtin.Assignment1_20322904;

public class Key extends Objects
{
    private int row;
    private int col;
    private int colour; //6 colours available

    public Key(ObjectInterface inObj, int inRow, int inCol, int inColour) 
    {
        super(inObj);
        row = inRow;
        col = inCol;
        colour = inColour;
    }

    @Override
    public String[][] print(String[][] keyStr) 
    {
        int rowChar = row * 2 + 1;
        int colChar = col * 4 + 1;
        int getRowChar = obj.getRow() * 2 + 1;
        int getColChar = obj.getCol() * 4 + 1;

        if(rowChar == getRowChar && colChar == getColChar)
        {   
            //\033[31m\u2555\033[m = \033[31m is the colour, \u2555 is the unicode for key, \033[m resets to default colour
            switch(colour)
            {
                case 1: //red
                    keyStr[rowChar][colChar++] = " ";
                    keyStr[rowChar][colChar] = "\033[31m\u2555\033[m";
                    break;

                case 2: //green
                    keyStr[rowChar][colChar++] = " ";
                    keyStr[rowChar][colChar] = "\033[32m\u2555\033[m";
                    break;
                    
                case 3: //yellow
                    keyStr[rowChar][colChar++] = " ";
                    keyStr[rowChar][colChar] = "\033[33m\u2555\033[m";
                    break;

                case 4: //blue
                    keyStr[rowChar][colChar++] = " ";
                    keyStr[rowChar][colChar] = "\033[34m\u2555\033[m";
                    break;
                    
                case 5: //magenta
                    keyStr[rowChar][colChar++] = " ";
                    keyStr[rowChar][colChar] = "\033[35m\u2555\033[m";
                    break;

                case 6: //cyan
                    keyStr[rowChar][colChar++] = " ";
                    keyStr[rowChar][colChar] = "\033[36m\u2555\033[m";
                    break;
            }  
        }
        return keyStr;
    }

    @Override
    public String[][] updatedPrint(String[][] keyStr, int pRow, int pCol, int prevRow, int prevCol, int i, int j) 
    {
        //should make key disappear here if player obtained the key
        return obj.updatedPrint(keyStr, pRow, pCol, prevRow, prevCol, i, j);
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
        return "K";
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
