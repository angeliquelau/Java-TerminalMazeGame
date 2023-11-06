package edu.curtin.Assignment1_20322904;

public interface Movement 
{
    public int updatePRow(int userRowPos, int userColPos, int bRow, int bCol, String[][] mapStr) throws AssignmentException;
    public int updatePCol(int userRowPos, int userColPos, int bRow, int bCol, String[][] mapStr) throws AssignmentException;    
}
