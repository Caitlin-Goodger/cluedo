package swen225;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4597.b7ac3a910 modeling language!*/



// line 31 "model.ump"
// line 75 "model.ump"
public class RoomCard implements Card
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------
		String name;
  //------------------------
  // CONSTRUCTOR
  //------------------------

  public RoomCard(String name)
  {
	  this.name = name;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}
  
  public String getName() {
	  return name;
  }

}