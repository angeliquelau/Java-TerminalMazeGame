package edu.curtin.Assignment1_20322904;

public class East implements Movement
{
    private int updatedRow;
    private int updatedCol;
    private Player player;
    private Key key;
    private Door door;

    public East()
    {
        updatedRow = 0;
        updatedCol = 0;
        player = null;
        key = null;
        door = null;
    }

    public East(int newUpdatedRow, int newUpdatedCol, Player inPlayer, Key inKey, Door inDoor)
    {
        updatedRow = newUpdatedRow;
        updatedCol = newUpdatedCol;
        player = inPlayer;
        key = inKey;
        door = inDoor;
    }
    
    @Override
    public int updatePRow(int userRowPos, int userColPos, int bRow, int bCol, String[][] mapStr) 
    {
        if(userRowPos >= 1 && userRowPos <= bRow - 2)
        {
            updatedRow = userRowPos;
        }
        // System.out.println("updated row: " + updatedRow);
        return updatedRow;
    }

    @Override
    public int updatePCol(int userRowPos, int userColPos, int bRow, int bCol, String[][] mapStr) throws AssignmentException
    {
        // userColPos = userColPos + 2; //check if the next box is empty
        // System.out.println("or we here?" + mapStr[userRowPos][userColPos]);
        // System.out.println("bRow n bCol, userColPos: " + bRow + " " + bCol + " " + userColPos);
        //check first if its wall, if it is, tell user its a wall
        if(mapStr[userRowPos][userColPos + 2] != "\u2502" && (userColPos <= bCol - 2))
        {
            userColPos = userColPos + 4; //skips 4 columns
            if(mapStr[userRowPos][userColPos] == " ") //check if its space
            {
                updatedCol = userColPos;
            }
            else if(mapStr[userRowPos][userColPos] == "\u2555") //check if its key
            {
                updatedCol = userColPos;
                player.addKey(key.getColour());
            }
            else if(mapStr[userRowPos][userColPos] == "\u2592")//check if its door 
            {
                //COMPARE KEY COLOUR AND DOOR COLOUR
            }
            else if(mapStr[userRowPos][userColPos] == "E") //check if its end position
            {
                updatedCol = userColPos;
            }
        }
        else //othewise, tell sure it cannot go right
        {
            throw new AssignmentException("got wall. cannot move. ");
        }

        // System.out.println("updated col: " + updatedCol);
        return updatedCol;
    }
    
}
