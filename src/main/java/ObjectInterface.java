package edu.curtin.Assignment1_20322904;

import java.util.List;

public interface ObjectInterface
{
    public String[][] print(String[][] mapStr) /*throws AssignmentException*/;
    public String[][] updatedPrint(String[][] mapStr, int pRow, int pCol, int prevRow, int prevCol, int i, int j);
    public int getRow();
    public int getCol(); 
    public String getType();
}
