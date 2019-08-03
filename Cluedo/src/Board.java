/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4597.b7ac3a910 modeling language!*/


import java.util.*;

// line 34 "model.ump"
// line 90 "model.ump"
public class Board
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Board Associations
  private List<Room> rooms;
  private Cell cells[][];

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Board()
  {
    rooms = new ArrayList<Room>();
    cells = new Cell[24][25];
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
  public Room getRoom(int index)
  {
    Room aRoom = rooms.get(index);
    return aRoom;
  }

  public List<Room> getRooms()
  {
    List<Room> newRooms = Collections.unmodifiableList(rooms);
    return newRooms;
  }

  public int numberOfRooms()
  {
    int number = rooms.size();
    return number;
  }

  public boolean hasRooms()
  {
    boolean has = rooms.size() > 0;
    return has;
  }

  public int indexOfRoom(Room aRoom)
  {
    int index = rooms.indexOf(aRoom);
    return index;
  }
//  /* Code from template association_GetMany */
//  public Cell getCell(int index)
//  {
//    Cell aCell = cells.get(index);
//    return aCell;
//  }

//  public List<Cell> getCells()
//  {
//    List<Cell> newCells = Collections.unmodifiableList(cells);
//    return newCells;
//  }
//
//  public int numberOfCells()
//  {
//    int number = cells.size();
//    return number;
//  }
//
//  public boolean hasCells()
//  {
//    boolean has = cells.size() > 0;
//    return has;
//  }
//
//  public int indexOfCell(Cell aCell)
//  {
//    int index = cells.indexOf(aCell);
//    return index;
//  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfRooms()
  {
    return 0;
  }
  /* Code from template association_AddUnidirectionalMany */
  public boolean addRoom(Room aRoom)
  {
    boolean wasAdded = false;
    if (rooms.contains(aRoom)) { return false; }
    rooms.add(aRoom);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeRoom(Room aRoom)
  {
    boolean wasRemoved = false;
    if (rooms.contains(aRoom))
    {
      rooms.remove(aRoom);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addRoomAt(Room aRoom, int index)
  {  
    boolean wasAdded = false;
    if(addRoom(aRoom))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRooms()) { index = numberOfRooms() - 1; }
      rooms.remove(aRoom);
      rooms.add(index, aRoom);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveRoomAt(Room aRoom, int index)
  {
    boolean wasAdded = false;
    if(rooms.contains(aRoom))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRooms()) { index = numberOfRooms() - 1; }
      rooms.remove(aRoom);
      rooms.add(index, aRoom);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addRoomAt(aRoom, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfCells()
  {
    return 0;
  }
  /* Code from template association_AddUnidirectionalMany */
  public boolean addCell(Cell aCell, int x, int y)
  {
    boolean wasAdded = false;
    cells[x][y] = aCell;
    return wasAdded;
  }
//
//  public boolean removeCell(Cell aCell)
//  {
//    boolean wasRemoved = false;
//    if (cells.contains(aCell))
//    {
//      cells.remove(aCell);
//      wasRemoved = true;
//    }
//    return wasRemoved;
//  }
//  /* Code from template association_AddIndexControlFunctions */
//  public boolean addCellAt(Cell aCell, int index)
//  {  
//    boolean wasAdded = false;
//    if(addCell(aCell))
//    {
//      if(index < 0 ) { index = 0; }
//      if(index > numberOfCells()) { index = numberOfCells() - 1; }
//      cells.remove(aCell);
//      cells.add(index, aCell);
//      wasAdded = true;
//    }
//    return wasAdded;
//  }
//
//  public boolean addOrMoveCellAt(Cell aCell, int index)
//  {
//    boolean wasAdded = false;
//    if(cells.contains(aCell))
//    {
//      if(index < 0 ) { index = 0; }
//      if(index > numberOfCells()) { index = numberOfCells() - 1; }
//      cells.remove(aCell);
//      cells.add(index, aCell);
//      wasAdded = true;
//    } 
//    else 
//    {
//      wasAdded = addCellAt(aCell, index);
//    }
//    return wasAdded;
//  }

  public void delete()
  {
    rooms.clear();
    //cells.clear();
  }

  // line 37 "model.ump"
   public void draw(){
    
  }

}