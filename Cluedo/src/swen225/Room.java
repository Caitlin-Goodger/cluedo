package swen225;

import java.util.List;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4597.b7ac3a910 modeling language!*/



// line 46 "model.ump"
// line 85 "model.ump"
public class Room
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Room Attributes
  private List<Player> inRoom;
  public List<String> weapons;
  private String name;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Room(String aName,List<Player> aInRoom, List<String> aWeapons)
  {
	name = aName;
    inRoom = aInRoom;
    weapons = aWeapons;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setInRoom(List<Player> aInRoom)
  {
    boolean wasSet = false;
    inRoom = aInRoom;
    wasSet = true;
    return wasSet;
  }

  public boolean setWeapons(List<String> aWeapons)
  {
    boolean wasSet = false;
    weapons = aWeapons;
    wasSet = true;
    return wasSet;
  }
  
  public boolean addToWeapon(String aWeapon)
  {
    boolean wasSet = false;
    weapons.add(aWeapon);
    wasSet = true;
    return wasSet;
  }
  
  public boolean addToRoom(Player player)
  {
    boolean wasSet = false;
    inRoom.add(player);
    wasSet = true;
    return wasSet;
  }

  public List<Player> getInRoom()
  {
    return inRoom;
  }

  public List<String> getWeapons()
  {
    return weapons;
  }
  
  public String getName()
  {
    return name;
  }

  public void delete()
  {}
  
  public void removeWeapon(String weapon)
  {
	  weapons.remove(weapon);
  }
  
  public void removePlayer(Player p)
  {
	  inRoom.remove(p);
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "inRoom" + "=" + (getInRoom() != null ? !getInRoom().equals(this)  ? getInRoom().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "weapons" + "=" + (getWeapons() != null ? !getWeapons().equals(this)  ? getWeapons().toString().replaceAll("  ","    ") : "this" : "null");
  }
}