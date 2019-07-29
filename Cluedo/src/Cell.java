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
  private String occupier;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Cell(Room aRoom, boolean aIsOccupied, String aOccupier)
  {
    room = aRoom;
    isOccupied = aIsOccupied;
    occupier = aOccupier;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setRoom(Room aRoom)
  {
    boolean wasSet = false;
    room = aRoom;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsOccupied(boolean aIsOccupied)
  {
    boolean wasSet = false;
    isOccupied = aIsOccupied;
    wasSet = true;
    return wasSet;
  }

  public boolean setOccupier(String aOccupier)
  {
    boolean wasSet = false;
    occupier = aOccupier;
    wasSet = true;
    return wasSet;
  }

  public Room getRoom()
  {
    return room;
  }

  public boolean getIsOccupied()
  {
    return isOccupied;
  }

  public String getOccupier()
  {
    return occupier;
  }
  /* Code from template attribute_IsBoolean */
  public boolean isIsOccupied()
  {
    return isOccupied;
  }

  public void delete()
  {}

  // line 44 "model.ump"
   public void draw(){
    
  }


  public String toString()
  {
    return super.toString() + "["+
            "isOccupied" + ":" + getIsOccupied()+ "," +
            "occupier" + ":" + getOccupier()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "room" + "=" + (getRoom() != null ? !getRoom().equals(this)  ? getRoom().toString().replaceAll("  ","    ") : "this" : "null");
  }
}