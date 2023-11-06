package edu.curtin.Assignment1_20322904;

import java.io.*;
import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Maze 
{
    private static Logger logger = Logger.getLogger(Maze.class.getName()); //for error logging
    private static Map<Integer,Movement> moveMap = new HashMap<>(); //for my movements
    
    public static void main(String[] args) throws IOException
    {
        Maze maze = new Maze();
        Scanner sc = new Scanner(System.in);
        String filename;
       
        do 
        {
            System.out.print("Please enter a file to proceed: ");
            filename = sc.nextLine();
    
            if(filename.isEmpty()) 
            {
                System.out.println("Its an empty string. Please try again!");
            }
        } while (filename.isEmpty());

        MapObj map = maze.readFile(filename); //get the details of the map

        int rowChar = map.getMap().get(0).getRow() * 2 + 1; //eg. if row is 4, then no. of characters to be printed will be 9
        int colChar = map.getMap().get(0).getCol() * 4 + 1; //eg. if col is 4, then no. of characters to be printed will be 17
        int pRowPos = 0;
        int pColPos = 0;
        int endRow = 0;
        int endCol = 0;

        String[][] mapStr = new String[rowChar][colChar]; //for storing 

        String[][] printMap = map.getMap().get(0).print(mapStr); //for printing

        System.out.println("\033[2J"); //clear screen
        //initial state of the maze
        for(int i = 1; i < map.getMap().size(); i++)
        {
            printMap = map.getMap().get(i).print(mapStr); //get the map objects to be printed

            if(map.getMap().get(i).getType().equals("S"))
            {
                pRowPos = map.getMap().get(i).getRow() * 2 + 1;
                pColPos = map.getMap().get(i).getCol() * 4 + 2; //* 4 + (1 + 2) to get it in the center
            }
            if(map.getMap().get(i).getType().equals("E"))
            {
                // System.out.println("hii");
                endRow = map.getMap().get(i).getRow() * 2 + 1;
                endCol = map.getMap().get(i).getCol() * 4 + 2;
                // System.out.println(endRow + " " + endCol);
            }
            if(i == map.getMap().size() - 2)
            {
                for(int j = 0; j < rowChar; j++)
                {
                    for(int k = 0; k < colChar; k++)
                    {
                        System.out.print(printMap[j][k]);
                    }
                    System.out.println();
                }
            }
        } 
        // System.out.println("end row and col: " + endRow + " " + endCol);

        
        maze.initMovements();
        int updatePRow = pRowPos;
        int updatePCol = pColPos;
        char action = ' ';
            while (pRowPos != endRow || pColPos != endCol) //stop the program when player reaches end position
            {
                try 
                {
                    do //get user input here. if user enter anything that is not n,s,w,e, ask user for input again
                    {
                        System.out.print("Enter:\n'n' to go up\n's' to go down\n'w' to go left\n'e' to go right\nmovement: ");
                        action = sc.next().charAt(0);
                    } while ((action != 'n' && action != 'N') && (action != 's' && action != 'S') && (action != 'w' && action != 'W') && (action != 'e' && action != 'E'));
            
                    //depending on user's choice of movement, then the updated row and column accordingly
                    switch(action)
                    {
                        case 'n': case 'N':
                            updatePRow = moveMap.get(1).updatePRow(pRowPos, pColPos, rowChar, colChar, mapStr); 
                            updatePCol = moveMap.get(1).updatePCol(pRowPos, pColPos, rowChar, colChar, mapStr); 
                            break;
        
                        case 's': case 'S':
                            updatePRow = moveMap.get(2).updatePRow(pRowPos, pColPos, rowChar, colChar, mapStr); 
                            updatePCol = moveMap.get(2).updatePCol(pRowPos, pColPos, rowChar, colChar, mapStr); 
                            break;
        
                        case 'e': case 'E':
                            updatePRow = moveMap.get(3).updatePRow(pRowPos, pColPos, rowChar, colChar, mapStr); 
                            updatePCol = moveMap.get(3).updatePCol(pRowPos, pColPos, rowChar, colChar, mapStr); 
                            break;
        
                        case 'w': case 'W':
                            updatePRow = moveMap.get(4).updatePRow(pRowPos, pColPos, rowChar, colChar, mapStr); 
                            updatePCol = moveMap.get(4).updatePCol(pRowPos, pColPos, rowChar, colChar, mapStr); 
                            break;
        
                    }
        
                    System.out.println("\033[2J"); //clear screen
        
                    //updated state of the maze
                    for(int i = 1; i < map.getMap().size(); i++)
                    {
                        for(int j = 0; j < rowChar; j++)
                        {
                            for(int k = 0; k < colChar; k++)
                            {
                                //here the pRowPos and pColPos is the previous player position
                                printMap = map.getMap().get(i).updatedPrint(mapStr, updatePRow, updatePCol, pRowPos, pColPos, j, k);
                            }
                        }
                    }
                    //printing the updated map
                    for(int j = 0; j < rowChar; j++)
                    {
                        for(int k = 0; k < colChar; k++)
                        {
                            System.out.print(printMap[j][k]);
                        }
                        System.out.println();
                    }
                } 
                catch (AssignmentException e) 
                {
                    System.out.println(e);
                }
                //update my user positions for the next move
                pRowPos = updatePRow;
                pColPos = updatePCol;
                // System.out.println("p row and col: " + pRowPos + " " + pColPos);
            }
        
        
    }  

    public MapObj readFile(String filename) throws IOException
    {
        //refered to https://www.geeksforgeeks.org/logger-fine-method-in-java-with-examples/#:~:text=The%20fine()%20method%20of,has%20happened%20in%20our%20application
        FileHandler handler = new FileHandler("logs.txt"); //the file that will have all the messages from logger.fine()
        handler.setFormatter(new SimpleFormatter());
        logger.setLevel(Level.FINE);
        logger.addHandler(handler);

        //stores the map details
        MapObj map = new MapObj();
        String line;
        
        try
        {
            FileInputStream fs = new FileInputStream(filename); 
            InputStreamReader read = new InputStreamReader(fs);
            BufferedReader bufRead = new BufferedReader(read);
            line = bufRead.readLine(); //reads the first line of the file

            Map<String,String> msg = new HashMap<>();
            int row = 0;
            int col = 0;
            String[] parts = line.split(" ", 2);
            row = Integer.parseInt(parts[0]);
            col = Integer.parseInt(parts[1]);

            ObjectInterface objects = new PlainMap(row, col);
            map.storeMapObj(objects);
            logger.fine("for plain map: " + objects.toString());

            line = bufRead.readLine(); //read next line for the loop to begin with

            while(line != null)
            {
                parts = line.split(" ", 4);
                
                //row and col is no longer in parts[0] and parts[1] so need to do this
                row = Integer.parseInt(parts[1]);
                col = Integer.parseInt(parts[2]);
                objects = new PlainMap(row, col);
                
                if(parts.length == 4) //for the lines doors, keys, player
                {
                    //stores row and column of door/keys, colour of door/key
                    if(parts[0].equals("K"))
                    {
                        //store coordinates(row and column), colour
                        objects = new Key(objects, row, col, Integer.parseInt(parts[3]));
                        //log the row and col details of my walls (my toString() returns row and col)
                        logger.fine("for keys: " + objects.toString());
                        // key.storeKeyToFind(objects, row, col, Integer.parseInt(parts[3]), key); //store it to FindKey()
                    }
                    if(parts[0].equals("DV") || parts[0].equals("DH"))
                    {
                        //store type of door (horizontal or vertical), coordinates(row and column), colour
                        objects = new Door(objects, parts[0], row, col, Integer.parseInt(parts[3]));
                        //log the row and col details of my walls (my toString() returns row and col)
                        logger.fine("for doors: " + objects.toString());
                        // key.storeLockedDoor(objects, row, col, Integer.parseInt(parts[3]));
                    }
                }

                if(parts.length == 3) //for the lines about walls
                {
                    if(parts[0].equals("WH") || parts[0].equals("WV"))
                    {
                        //store type of wall(horizontal or vertical), coordinates(row and column)
                        objects = new Wall(objects, parts[0], row, col);
                        //log the row and col details of my walls (my toString() returns row and col)
                        logger.fine("for walls: " + objects.toString());
                    }
                    if(parts[0].equals("S") || parts[0].equals("E"))
                    {
                        //player's initial position and end position to win the game
                        objects = new Player(objects, parts[0], row, col, 0, 0, null);
                        //log the row and col details of my walls (my toString() returns row and col)
                        logger.fine("for player(start/end): " + objects.toString());
                    }
                }
                if(parts.length >= 4 && parts[0].equals("M")) //for lines about the messages
                {

                    //row and column as the key, value is the message
                    msg.put(parts[1] + " " + parts[2], parts[3]);
                    // System.out.println(msg.get(parts[1] + " " + parts[2]));
                    //stores row and column of message and the message
                    objects = new Player(objects, parts[0], 0, 0, row, col, msg);
                    logger.fine("for message: " + objects.toString());
                }
                
                map.storeMapObj(objects);

                line = bufRead.readLine(); //get next line
            }
        }
        catch(IOException e)
        {
            System.out.println("File not found");
        }
        
        return map;
    }

    //initialisation for different movements
    public void initMovements()
    {
        moveMap.put(1, new North());
        moveMap.put(2, new South());
        moveMap.put(3, new East());
        moveMap.put(4, new West());
    }

    //NOT USED BECAUSE MY CODE IS NOT COMPLETED. IF IT IS A COMPLETE CODE, I WOULD HAVE USED THIS
    //FOR MY MOVEMENTS INSTEAD SINCE I WILL NEED TO CHECK IF KEY COLOUR AND DOOR COLOUR IS THE SAME
    public void initMovements(int updatePRow, int updatePCol, Player player, Key key, Door door)
    {
        moveMap.put(1, new North(updatePRow, updatePCol, player, key, door));
        moveMap.put(2, new South(updatePRow, updatePCol, player, key, door));
        moveMap.put(3, new East(updatePRow, updatePCol, player, key, door));
        moveMap.put(4, new West(updatePRow, updatePCol, player, key, door));
    }
}
