package swen225;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4597.b7ac3a910 modeling language!*/



// line 25 "model.ump"
// line 65 "model.ump"
public class CharacterCard implements Card
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------
		public String name;
  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CharacterCard(String name)
  {
	  this.name = name;
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