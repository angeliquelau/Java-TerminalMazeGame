package edu.curtin.Assignment1_20322904;

public class South implements Movement
{
    private int updatedRow;
    private int updatedCol;
    private Player player;
    private Key key;
    private Door door;

    public South()
    {
        updatedRow = 0;
        updatedCol = 0;
        player = null;
        key = null;
        door = null;
    }

    public South(int newUpdatedRow, int newUpdatedCol, Player inPlayer, Key inKey, Door inDoor)
    {
        updatedRow = newUpdatedRow;
        updatedCol = newUpdatedCol;
        player = inPlayer;
        key = inKey;
        door = inDoor;
    }
    
    @Override
    public int updatePRow(int userRowPos, int userColPos, int bRow, int bCol, String[][] mapStr) throws AssignmentException
    {
        // System.out.println("user row pos: " + userRowPos);
        // userRowPos = userRowPos + 1;
        //check first if its wall, if it is, tell user its a wall
        if(mapStr[userRowPos + 1][userColPos] != "\u2500" && (userRowPos <= bRow - 2))
        {
            userRowPos = userRowPos + 2; //skips 2 rows
            if(mapStr[userRowPos][userColPos] == " ") //check if its space
            {
                System.out.println("key or space");
                updatedRow = userRowPos;
            }
            else if(mapStr[userRowPos][userColPos] == "\u2555") //check if its key
            {
                updatedRow = userRowPos;
                player.addKey(key.getColour());
            }
            else if(mapStr[userRowPos][userColPos] == "\u2592") //check if its door
            {
                //COMPARE KEY COLOUR AND DOOR COLOUR
            }
            else if(mapStr[userRowPos][userColPos] == "E") //check if its end position
            {
                updatedRow = userRowPos;
            }
            
            // System.out.println("user row pos then updated " + userRowPos + " " + updatedRow);
        }
        else //othewise, tell user it cannot go down
        {
            throw new AssignmentException("got wall. cannot move. ");
        }
        // System.out.println("updated row: " + updatedRow);
        return updatedRow;
    }

    @Override
    public int updatePCol(int userRowPos, int userColPos, int bRow, int bCol, String[][] mapStr) 
    {
        if(userColPos >= 1 && userColPos <= bCol - 2)
        {
            updatedCol = userColPos;
        }
        // System.out.println("updated col: " + updatedCol);
        return updatedCol;
    }
    
}
