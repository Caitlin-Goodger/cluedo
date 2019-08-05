package swen225;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
  
  public boolean addToHand(Card c) {
	    boolean wasSet = false;
	    hand.add(c);
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
    if(current != null) {
	    room.removePlayer(this);
	    current.setIsOccupied(false);
		current.setOccupier(null);
    }
	aCurrent.setIsOccupied(true);
	aCurrent.setOccupier(this.name);
    current = aCurrent;
    room = aCurrent.getRoom();
    if(room != null) {
    	room.addToRoom(this);
    }
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
	   for(int i = 0; i<hand.size();i++) {
		   System.out.println(hand.get(i).getName());
	   }
  }

  // line 16 "model.ump"
   public List<String> suggest(List<String> rooms, List<String> characters, List<String> weapons){
	   if(!lost) {
		   List<String> options = new ArrayList();
		   InputStreamReader in = new InputStreamReader(System.in);
			  Scanner scan = new Scanner(in);
			  String roomP = room.getName();
			  options.add(roomP);
			  System.out.println(characters);
			  System.out.println("What character do you want?");
			  String character = scan.next();
			  if(!characters.contains(character)) {
				  System.out.println("Please pick a character from the list");
				  character = scan.next();
			  }
			  options.add(character);
			  System.out.println(weapons);
			  System.out.println("What weapon do you want?");
			  String weapon = scan.next();
			  if(!weapons.contains(weapon)) {
				  System.out.println("Please pick a weapon from the list");
				  weapon = scan.next();
			  }
			  options.add(weapon);
			  return options;
		   }
	   return null;
  }

  // line 17 "model.ump"
   public List<String> accuse(List<String> rooms, List<String> characters, List<String> weapons){
	   if(!lost) {
		   List<String> options = new ArrayList();
		   InputStreamReader in = new InputStreamReader(System.in);
			  Scanner scan = new Scanner(in);
			  System.out.println(rooms);
			  System.out.println("What room do you want?");
			  String room = scan.next();
			  if(rooms.contains(room)) {
				  System.out.println("Please pick a room from the list");
				  room = scan.next();
			  }
			  options.add(room);
			  System.out.println(characters);
			  System.out.println("What character do you want?");
			  String character = scan.next();
			  if(characters.contains(character)) {
				  System.out.println("Please pick a character from the list");
				  character = scan.next();
			  }
			  options.add(character);
			  System.out.println(weapons);
			  System.out.println("What weapon do you want?");
			  String weapon = scan.next();
			  if(weapons.contains(weapon)) {
				  System.out.println("Please pick a weapon from the list");
				  weapon = scan.next();
			  }
			  options.add(weapon);
			  return options;
		   }
	   return null;
  }

  // line 18 "model.ump"
   public List<String> refute(List<String> suggest){
	   List<String> cards = new ArrayList();
	   for(int i =0;i<hand.size();i++) {
		   Card c = hand.get(i);
		   if(suggest.contains(c.getName())) {
			   cards.add(c.getName());
		   }
	   }
    return cards;
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

public void move(int moves, Board board,List<Cell> visited) {
	// TODO Auto-generated method stub
	  for(int i =0;i<moves;i++) {
		  String direction = getDirection();
		  if(direction.contentEquals("left")) {
			  if(current.getX()==0) {
				  System.out.println("Can't move this way");
				  move(moves-i,board,visited);
			  }
			  Cell next = board.getCell(current.getX()-1, current.getY());
			  if(visited.contains(next)) {
				  System.out.println("You've already visited this square");
				  move(moves-i,board,visited);
			  }
			  if(!next.getAccessable()) {
				  System.out.println("Can't move this way");
				  move(moves-i,board,visited);
			  }
			  visited.add(next);
			  current = next;
		  } else if(direction.contentEquals("right")) {
			  if(current.getX()==23) {
				  System.out.println("Can't move this way");
				  move(moves-i,board,visited);
			  }
			  Cell next = board.getCell(current.getX()+1, current.getY());
			  if(visited.contains(next)) {
				  System.out.println("You've already visited this square");
				  move(moves-i,board,visited);
			  }
			  if(!next.getAccessable()) {
				  System.out.println("Can't move this way");
				  move(moves-i,board,visited);
			  }
			  visited.add(next);
			  current = next;
		  } else if(direction.contentEquals("down")) {
			  if(current.getY()==0) {
				  System.out.println("Can't move this way");
				  move(moves-i,board,visited);
			  }
			  Cell next = board.getCell(current.getX(), current.getY()-1);
			  if(visited.contains(next)) {
				  System.out.println("You've already visited this square");
				  move(moves-i,board,visited);
			  }
			  if(!next.getAccessable()) {
				  System.out.println("Can't move this way");
				  move(moves-i,board,visited);
			  }
			  visited.add(next);
			  current = next;
		  } else if(direction.contentEquals("up")) {
			  if(current.getX()==24) {
				  System.out.println("Can't move this way");
				  move(moves-i,board,visited);
			  }
			  Cell next = board.getCell(current.getX(), current.getY()+1);
			  if(visited.contains(next)) {
				  System.out.println("You've already visited this square");
				  move(moves-i,board,visited);
			  }
			  if(!next.getAccessable()) {
				  System.out.println("Can't move this way");
				  move(moves-i,board,visited);
			  }
			  visited.add(next);
			  setCurrent(next);
			  current = next;
		  }
		  
	  }
}

	public String getDirection() {
		List<String> directions = new ArrayList();
		directions.add("left");
		directions.add("right");
		directions.add("up");
		directions.add("down");
		InputStreamReader in = new InputStreamReader(System.in);
		  Scanner scan = new Scanner(in);
		System.out.println("What directions do you want to move?");
		  String direction = scan.next();
		  while(!directions.contains(direction)) {
			  System.out.println("Left, right, up or down");
			  direction = scan.next();
		  }
		  return direction;
	}
}