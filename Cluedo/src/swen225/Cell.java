package swen225;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4597.b7ac3a910 modeling language!*/



// line 40 "model.ump"
// line 80 "model.ump"
public class Cell
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Cell Attributes
  private Room room;
  private boolean isOccupied;
  private boolean accessable;
  private String occupier;
  private int x;
  private int y;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Cell(Room aRoom, boolean aIsOccupied, String aOccupier, int x, int y, boolean access)
  {
    room = aRoom;
    isOccupied = aIsOccupied;
    occupier = aOccupier;
    accessable = access;
    this.x=x;
    this.y=y;
  }

  //------------------------
  // INTERFACE
  //------------------------

  /**
   * Set the room the cell is in
   * @param aRoom
   * @return
   */
  public boolean setRoom(Room aRoom)
  {
    boolean wasSet = false;
    room = aRoom;
    wasSet = true;
    return wasSet;
  }

  /**
   * Set whether the cell is occupied
   * @param aIsOccupied
   * @return
   */
  public boolean setIsOccupied(boolean aIsOccupied)
  {
    boolean wasSet = false;
    isOccupied = aIsOccupied;
    wasSet = true;
    return wasSet;
  }
  
  /**
   * Set whether the cell is accessable
   * @param access
   * @return
   */
  public boolean setAccessable(boolean access)
  {
    boolean wasSet = false;
    accessable = access;
    wasSet = true;
    return wasSet;
  }

  /**
   * Set what is occupying the room
   * @param aOccupier
   * @return
   */
  public boolean setOccupier(String aOccupier)
  {
    boolean wasSet = false;
    occupier = aOccupier;
    wasSet = true;
    return wasSet;
  }
  
/**
 * Get the room the cell is in
 * @return
 */
  public Room getRoom()
  {
    return room;
  }

  /**
   * Get whether the cell is occupied
   * @return
   */
  public boolean getIsOccupied()
  {
    return isOccupied;
  }
  
  /**
   * Get whether the cell is accessable
   * @return
   */
  public boolean getAccessable()
  {
    return accessable;
  }

  /**
   * Get what is occupying the cells
   * @return
   */
  public String getOccupier()
  {
	  if(occupier.length()>2) {
		  return " " +occupier.substring(0, 1);
	  }
    return occupier;
  }
  /* Code from template attribute_IsBoolean */
  public boolean isIsOccupied()
  {
    return isOccupied;
  }

  /**
   * Delete the cell
   */
  public void delete()
  {}

  // line 44 "model.ump"
  /**
   * Draw the cell
   */
   public void draw(){
    
  }
   /**
    * Get the s value of the cell
    * @return
    */
   public int getX() {
	   return x;
   }
   
   /**
    * Get the y value of the cell
    * @return
    */
   public int getY() {
	   return y;
   }


   public String toString()
   {
  //If this cell contains a character or weapon, return the value of that
	  if (getIsOccupied()) {
		  if (getOccupier().length() > 2) {
			  return (" " + getOccupier() + " ");
		  }
		  else {
			  return getOccupier() + " "; //char
		  }
	  }
  //If this cell does not contain anything, print the room value or the visual
  //representation of an inaccesible cell
	  else {
		  if (!getAccessable()) {
			  return "###";
		  }
		  else {
			  return (" " + getRoom().toString() + " ");
		  }
	  }
   }
}