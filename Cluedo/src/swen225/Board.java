package swen225;

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

  /**
   * Get the list of rooms
   * @return
   */
  public List<Room> getRooms()
  {
    List<Room> newRooms = Collections.unmodifiableList(rooms);
    return newRooms;
  }

  /**
   * Get the number of rooms
   * @return
   */
  public int numberOfRooms()
  {
    int number = rooms.size();
    return number;
  }

  /**
   * Checks that there is at least one room
   * @return
   */
  public boolean hasRooms()
  {
    boolean has = rooms.size() > 0;
    return has;
  }

  /**
   * Get the index of a room
   * @param aRoom
   * @return
   */
  public int indexOfRoom(Room aRoom)
  {
    int index = rooms.indexOf(aRoom);
    return index;
  }

  /**
   * Get a cell at an x and y value
   * @param x
   * @param y
   * @return
   */
  public Cell getCell(int x,int y)
  {
    Cell aCell = cells[x][y];
    return aCell;
  }
  
  /**
   * Print the board. Used for testing to check that all the cells were there
   */
  public void printBoard() {
	  for(int i =0;i<24;i++) {
		  for(int j =0;j<25;j++) {
			  System.out.println(cells[i][j]);
		  }
	  }
  }


  /**
   * Add a room
   * @param aRoom
   * @return
   */
  public boolean addRoom(Room aRoom)
  {
    boolean wasAdded = false;
    if (rooms.contains(aRoom)) { return false; }
    rooms.add(aRoom);
    wasAdded = true;
    return wasAdded;
  }

  /**
   * Remove a room
   * @param aRoom
   * @return
   */
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
  /**
   * Add a room at an index
   * @param aRoom
   * @param index
   * @return
   */
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

  /**
   * Add or move a room at an index
   * @param aRoom
   * @param index
   * @return
   */
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

  /**
   * Delete the board information
   */
  public void delete()
  {
    rooms.clear();
    cells = new Cell[24][25];
  }

  // line 37 "model.ump"
  /**
   * Draw the board
   */
  public void draw(){
	  String line = "";
	  for (int i = 0; i < 25; i++) {
		  for (int y = 0; y < 24; y++) {
			  line += ("|" + cells[y][i].toString());
		  }
		  line += "|";
		  System.out.println(line);
		  line = "";
	  }
	   
	  }

}