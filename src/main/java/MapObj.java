package edu.curtin.Assignment1_20322904;

import java.io.*;
import java.util.*;

/*

store objects available in map

*/
public class MapObj
{
    private List<ObjectInterface> mapObj;

    public MapObj()
    {
        mapObj = new LinkedList<ObjectInterface>();
    }

    public MapObj(List<ObjectInterface> inMapObj)
    {
        mapObj = inMapObj;
    }

    public List<ObjectInterface> getMap()
    {
        return mapObj;
    }

    public void storeMapObj(ObjectInterface newObject)
    {
        mapObj.add(newObject);
    }

    @Override
    public String toString() 
    {
        return super.toString();
    }
}
