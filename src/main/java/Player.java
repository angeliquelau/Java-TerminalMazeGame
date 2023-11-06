package edu.curtin.Assignment1_20322904;

import java.util.Map;
import java.util.stream.Stream;
import java.util.HashMap;
import java.util.List;

public class Player extends Objects
{
    private String type;
    private int pRow; //player
    private int pCol;
    private int mRow; //message
    private int mCol;
    private Map<String,String> msg;
    protected Map<Integer,Integer> newKeyMap = new HashMap<>();

    public Player(ObjectInterface inObj, String inType, int inPRow, int inPCol, int inMRow, int inMCol, Map<String, String> inMsg) 
    {
        super(inObj);
        type = inType;
        pRow = inPRow;
        pCol = inPCol;
        mRow = inMRow;
        mCol = inMCol;
        msg = inMsg;
    }

    @Override
    public String[][] print(String[][] playerStr) 
    {
        //so that player prints where it should be when its 9 x 17 instead of 4 x 4
        int pRowChar = pRow * 2 + 1;
        int pColChar = pCol * 4 + 1;
        //for message
        int mRowChar = mRow * 2 + 1;
        int mColChar = mCol * 4 + 1;
        int getRowChar = obj.getRow() * 2 + 1;
        int getColChar = obj.getCol() * 4 + 1;
        
        //initial position
        if(type.equals("S")) //only run this when the program just start
        {
            //print P at the start position
            if(pRowChar == getRowChar && pColChar == getColChar)
            {
                pColChar++;
                playerStr[pRowChar][pColChar] = "P";
            }
        }
        //only run this when the program just start
        if(type.equals("E")) //if startEnd is E. the win condition is here
        {
            if(pRowChar == getRowChar && pColChar == getColChar)
            {
                pColChar++;
                playerStr[pRowChar][pColChar] = "E";
            }
        }
        // System.out.println("updated: " + updatedRow + updatedCol);
        
        if(type.equals("M"))
        {
            // System.out.println("message: " + mRowChar + " " + mColChar);
            // String pPos = pRowChar + " " + pColChar;
            // System.out.println(pPos + " " + "msg size: " + msg.size());
            // if((pPos.equals(msg.get(mRow + " " + mCol))))
            // {
            //     System.out.println("msg get: " + msg.get(mRow + " " + mCol).toString());
            // }
        }

        // System.out.println("updatedRow and updatedCol: " + updatedRow + " " + updatedCol);
        
        return playerStr;
    }

    @Override
    public String[][] updatedPrint(String[][] playerStr, int updatedRow, int updatedCol, int prevRow, int prevCol, int i, int j) 
    {
        String userPos = "";
        
        //set the previous position of P to empty space
        playerStr[prevRow][prevCol] = " ";

        if(i == updatedRow && j == updatedCol)
        {
            playerStr[i][j] = "P";
            // System.out.println("pColChar after: " + pColChar);
        }
        userPos = updatedRow + " " + updatedCol;

        return playerStr;
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

    public void addKey(int keyColour)
    {
        newKeyMap.put(keyColour, keyColour);
    }

    @Override
    public String toString() 
    {
        return getRow() + " " + getCol();
    }

}        