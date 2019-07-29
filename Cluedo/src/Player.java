import java.util.List;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4597.b7ac3a910 modeling language!*/



// line 9 "model.ump"
// line 59 "model.ump"
public class Player
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Player Attributes
  private String name;
  private List<Card> hand;
  private boolean lost;
  private Cell current;
  private Room room;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Player(String aName, List<Card> aHand, boolean aLost, Cell aCurrent, Room aRoom)
  {
    name = aName;
    hand = aHand;
    lost = aLost;
    current = aCurrent;
    room = aRoom;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setHand(List<Card> aHand)
  {
    boolean wasSet = false;
    hand = aHand;
    wasSet = true;
    return wasSet;
  }

  public boolean setLost(boolean aLost)
  {
    boolean wasSet = false;
    lost = aLost;
    wasSet = true;
    return wasSet;
  }

  public boolean setCurrent(Cell aCurrent)
  {
    boolean wasSet = false;
    current = aCurrent;
    wasSet = true;
    return wasSet;
  }

  public boolean setRoom(Room aRoom)
  {
    boolean wasSet = false;
    room = aRoom;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public List<Card> getHand()
  {
    return hand;
  }

  public boolean getLost()
  {
    return lost;
  }

  public Cell getCurrent()
  {
    return current;
  }

  public Room getRoom()
  {
    return room;
  }
  /* Code from template attribute_IsBoolean */
  public boolean isLost()
  {
    return lost;
  }

  public void delete()
  {}

  // line 15 "model.ump"
   public void displayCards(){
    
  }

  // line 16 "model.ump"
   public List<Card> suggest(){
    return null;
  }

  // line 17 "model.ump"
   public List<Card> accuse(){
    return null;
  }

  // line 18 "model.ump"
   public List<Card> refute(){
    return null;
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "lost" + ":" + getLost()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "hand" + "=" + (getHand() != null ? !getHand().equals(this)  ? getHand().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "current" + "=" + (getCurrent() != null ? !getCurrent().equals(this)  ? getCurrent().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "room" + "=" + (getRoom() != null ? !getRoom().equals(this)  ? getRoom().toString().replaceAll("  ","    ") : "this" : "null");
  }
}