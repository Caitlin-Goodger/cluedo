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

  /**
   * Add players to the room
   * @param aInRoom
   * @return
   */
  public boolean setInRoom(List<Player> aInRoom)
  {
    boolean wasSet = false;
    inRoom = aInRoom;
    wasSet = true;
    return wasSet;
  }

  /**
   * Add weapons to the room
   * @param aWeapons
   * @return
   */
  public boolean setWeapons(List<String> aWeapons)
  {
    boolean wasSet = false;
    weapons = aWeapons;
    wasSet = true;
    return wasSet;
  }
  
  /**
   * Add weapon to the room
   * @param aWeapon
   * @return
   */
  public boolean addToWeapon(String aWeapon)
  {
    boolean wasSet = false;
    weapons.add(aWeapon);
    wasSet = true;
    return wasSet;
  }
  
  /**
   * Add player to the room
   * @param player
   * @return
   */
  public boolean addToRoom(Player player)
  {
    boolean wasSet = false;
    inRoom.add(player);
    wasSet = true;
    return wasSet;
  }

  /**
   * Get the list of players in the room
   * @return
   */
  public List<Player> getInRoom()
  {
    return inRoom;
  }

  /**
   * Get list of weapons in the room
   * @return
   */
  public List<String> getWeapons()
  {
    return weapons;
  }
  
  /**
   * Get name of the room
   * @return
   */
  public String getName()
  {
    return name;
  }

  public void delete()
  {}
  
  /**
   * Remove a weapon from the room
   * @param weapon
   */
  public void removeWeapon(String weapon)
  {
	  weapons.remove(weapon);
  }
  
  /**
   * Remove player from the room
   * @param p
   */
  public void removePlayer(Player p)
  {
	  inRoom.remove(p);
  }


  public String toString()
  {
	 //Return the room's numerical value
	 if (name == "kitchen") {
		 return "0";
	 }
	 else if (name == "ballroom") {
		 return "1";
	 }
	 else if (name == "conservatory") {
		 return "2";
	 }
	 else if (name == "billiard") {
		 return "3";
	 }
	 else if (name == "library") {
		 return "4";
	 }
	 else if (name == "study") {
		 return "5";
	 }
	 else if (name == "hall") {
		 return "6";
	 }
	 else if (name == "lounge") {
		 return "7";
	 }
	 else if (name == "dining") {
		 return "8";
	 }
	 else {
		 return " ";
	 }
  }


}