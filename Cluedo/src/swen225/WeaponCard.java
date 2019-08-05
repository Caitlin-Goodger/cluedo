package swen225;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4597.b7ac3a910 modeling language!*/



// line 28 "model.ump"
// line 70 "model.ump"
public class WeaponCard implements Card
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------
		String name;
		String initial;
  //------------------------
  // CONSTRUCTOR
  //------------------------

  public WeaponCard(String name, String i)
  {
	  this.name = name;
	  this.initial = i;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}
  
  /**
   * Get the name of the card
   */
  public String getName() {
	  return name;
  }

}