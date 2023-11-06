package edu.curtin.Assignment1_20322904;


public abstract class Objects implements ObjectInterface
{
    protected ObjectInterface obj;

    public Objects(ObjectInterface inObj)
    {
        obj = inObj;
    }

    public ObjectInterface getObj()
    {
        return obj;
    }

    @Override
    public String[][] print(String[][] mapStr) 
    {
        return obj.print(mapStr);
    }

    @Override
    public String[][] updatedPrint(String[][] mapStr, int pRow, int pCol, int prevRow, int prevCol, int i, int j) 
    {

        return obj.updatedPrint(mapStr, pRow, pCol, prevRow, prevCol, i, j);
    }

    @Override
    public int getRow() 
    {
        // System.out.println("from Objects: " + obj.getRow());
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
        return obj.getType();
    }

    @Override
    public String toString() 
    {
        return getRow() + " " + getCol() + " " + getType();
    }
}
