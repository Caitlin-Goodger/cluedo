/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4597.b7ac3a910 modeling language!*/


import java.io.*;
import java.util.*;

// line 2 "model.ump"
// line 52 "model.ump"
public class Game
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Game Associations
  private List<Player> players;
  private List<Card> cards;
  private List<Room> rooms;
  private Board board;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Game()
  {
    players = new ArrayList<Player>();
    cards = new ArrayList<Card>();
    setUpRooms();
    setUpBoard();
    setUpCharacterCards();
    setUpRoomCards();
    setUpWeaponCards();
  }
  
  public static void main(String args[]) {
	  Game g = new Game();
  }
  
	  public void setUpCharacterCards() {
		  
	  }
  
	public void setUpRoomCards() {
		  
	  }
	
	public void setUpWeaponCards() {
		  
	}
  
  public void setUpRooms() {
	  Room kitchen = new Room("kitchen", null,null);
	  Room ballroom = new Room("ballroom",null,null);
	  Room conservatory = new Room("conservatory",null,null);
	  Room billiard = new Room("billiard",null,null);
	  Room library = new Room("library",null,null);
	  Room study = new Room("study",null,null);
	  Room hall = new Room("hall",null,null);
	  Room lounge = new Room("lounge",null,null);
	  Room dining = new Room("dining",null,null);
	  Room none = new Room("none",null,null);
	  rooms.add(kitchen);
	  rooms.add(ballroom);
	  rooms.add(conservatory);
	  rooms.add(billiard);
	  rooms.add(library);
	  rooms.add(study);
	  rooms.add(hall);
	  rooms.add(lounge);
	  rooms.add(dining);
	  rooms.add(none);
	  
  }
  
  public void setUpBoard() {
	  try {
		BufferedReader buffer = new BufferedReader(new FileReader(new File("cellData.csv")));
		String line;
		while((line = buffer.readLine()) !=null) {
			String[] split = line.split(",");
			int y = Integer.parseInt(split[0]);
			int x = Integer.parseInt(split[1]);
			int room = Integer.parseInt(split[2]);
			int access = Integer.parseInt(split[3]);
			boolean accessable = true;
			if(access==0) {
				accessable = false;
			}
			Cell c = new Cell(rooms.get(room),false,null,x,y);
			
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (NumberFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
  public Player getPlayer(int index)
  {
    Player aPlayer = players.get(index);
    return aPlayer;
  }

  public List<Player> getPlayers()
  {
    List<Player> newPlayers = Collections.unmodifiableList(players);
    return newPlayers;
  }

  public int numberOfPlayers()
  {
    int number = players.size();
    return number;
  }

  public boolean hasPlayers()
  {
    boolean has = players.size() > 0;
    return has;
  }

  public int indexOfPlayer(Player aPlayer)
  {
    int index = players.indexOf(aPlayer);
    return index;
  }
  /* Code from template association_GetMany */
  public Card getCard(int index)
  {
    Card aCard = cards.get(index);
    return aCard;
  }

  public List<Card> getCards()
  {
    List<Card> newCards = Collections.unmodifiableList(cards);
    return newCards;
  }

  public int numberOfCards()
  {
    int number = cards.size();
    return number;
  }

  public boolean hasCards()
  {
    boolean has = cards.size() > 0;
    return has;
  }

  public int indexOfCard(Card aCard)
  {
    int index = cards.indexOf(aCard);
    return index;
  }
  /* Code from template association_GetOne */
  public Board getBoard()
  {
    return board;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfPlayers()
  {
    return 0;
  }
  /* Code from template association_AddUnidirectionalMany */
  public boolean addPlayer(Player aPlayer)
  {
    boolean wasAdded = false;
    if (players.contains(aPlayer)) { return false; }
    players.add(aPlayer);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removePlayer(Player aPlayer)
  {
    boolean wasRemoved = false;
    if (players.contains(aPlayer))
    {
      players.remove(aPlayer);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addPlayerAt(Player aPlayer, int index)
  {  
    boolean wasAdded = false;
    if(addPlayer(aPlayer))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPlayers()) { index = numberOfPlayers() - 1; }
      players.remove(aPlayer);
      players.add(index, aPlayer);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePlayerAt(Player aPlayer, int index)
  {
    boolean wasAdded = false;
    if(players.contains(aPlayer))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPlayers()) { index = numberOfPlayers() - 1; }
      players.remove(aPlayer);
      players.add(index, aPlayer);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPlayerAt(aPlayer, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfCards()
  {
    return 0;
  }
  /* Code from template association_AddUnidirectionalMany */
  public boolean addCard(Card aCard)
  {
    boolean wasAdded = false;
    if (cards.contains(aCard)) { return false; }
    cards.add(aCard);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeCard(Card aCard)
  {
    boolean wasRemoved = false;
    if (cards.contains(aCard))
    {
      cards.remove(aCard);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addCardAt(Card aCard, int index)
  {  
    boolean wasAdded = false;
    if(addCard(aCard))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCards()) { index = numberOfCards() - 1; }
      cards.remove(aCard);
      cards.add(index, aCard);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveCardAt(Card aCard, int index)
  {
    boolean wasAdded = false;
    if(cards.contains(aCard))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCards()) { index = numberOfCards() - 1; }
      cards.remove(aCard);
      cards.add(index, aCard);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addCardAt(aCard, index);
    }
    return wasAdded;
  }
  /* Code from template association_SetUnidirectionalOne */
  public boolean setBoard(Board aNewBoard)
  {
    boolean wasSet = false;
    if (aNewBoard != null)
    {
      board = aNewBoard;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    players.clear();
    cards.clear();
    board = null;
  }

  // line 6 "model.ump"
   public int rollDice(){
    return 0;
  }

}