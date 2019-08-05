package swen225;

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
  private List<Card> allCards;
  private List<Room> rooms;
  private List<String> playersNames;
  private List<String> weaponNames;
  private List<String> roomsNames;
  private Board board;
  private CharacterCard murder;
  private RoomCard mRoom;
  private WeaponCard mWeapon;
  private int numPlayers;
  private boolean won;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Game()
  {
    players = new ArrayList<Player>();
    cards = new ArrayList<Card>();
    allCards = new ArrayList<Card>();
    rooms = new ArrayList<Room>();
    setUpRooms();
    setUpBoard();
    //board.printBoard();
    setUpCharacterCards();
    setUpRoomCards();
    setUpWeaponCards();
    setUpPlayers();
    createLists();
    playTheGame();
    
  }
  
	  public static void main(String args[]) {
		  Game g = new Game();
	  }
	  
	  public void createLists() {
		  playersNames = new ArrayList();
		  weaponNames = new ArrayList();
		  roomsNames = new ArrayList();
		  playersNames.add("ms");
		  playersNames.add("cm");
		  playersNames.add("mw");
		  playersNames.add("mg");
		  playersNames.add("mp");
		  playersNames.add("pp");
		  weaponNames.add("c");
		  weaponNames.add("d");
		  weaponNames.add("p");
		  weaponNames.add("g");
		  weaponNames.add("r");
		  weaponNames.add("s");
		  roomsNames.add("kitchen");
		  roomsNames.add("ballroom");
		  roomsNames.add("conservatory");
		  roomsNames.add("billiard");
		  roomsNames.add("library");
		  roomsNames.add("study");
		  roomsNames.add("hall");
		  roomsNames.add("lounge");
		  roomsNames.add("dining");
	  }
	  
	  public void playTheGame() {
		  int count = 1;
		  int i =0;
		  while(!won) {
			  Player p = players.get(count);
			  if(!p.isLost()) { 
			  System.out.println("Player " + count + " turn");
			  int roll = rollDice();
			  System.out.println("You rolled a " + roll);
			  p.move(roll,board, new ArrayList<Cell>());
			  if(p.getRoom() != null) {
				  InputStreamReader in = new InputStreamReader(System.in);
				  Scanner scan = new Scanner(in);
					  List<String> options = new ArrayList();
					  options.add("suggest");
					  options.add("accuse");
					  options.add("neither");
					  System.out.println("Do you want to suggest, accuse or neither");
					  String choice = scan.next();
					  if(!options.contains(choice)) {
						  System.out.println("Do you want to suggest, accuse or neither");
						  choice = scan.next();
					  }
					  if(choice.contentEquals("suggest")) {
						  List<String> suggestions = p.suggest(roomsNames, playersNames, weaponNames);
						  refuteSuggestion(suggestions,p);
					  } else if (choice.contentEquals("accuse")) {
						  List<String> accuse = p.accuse(roomsNames, playersNames, weaponNames);
						  refuteAccuse(accuse,p);
					  }
				  }
			  }
			  count++;
			  if(count>numPlayers) {
				  count = 0;
			  }
		  }
	  }
	  
	  public void refuteSuggestion(List<String> suggestions, Player p) {
		  String player = "";
		  String room = "";
		  String weapon = "";
		  for(int i = 0;i<suggestions.size();i++) {
			  String value = suggestions.get(i);
			  if(playersNames.contains(value)) {
				  player = value;
			  }
			  if(roomsNames.contains(value)) {
				  room = value;
			  }
			  if(weaponNames.contains(value)) {
				  weapon = value;
			  }
		  }
		  Room r = null;
		  for(int i =0;i<rooms.size();i++) {
			  Room r1 = rooms.get(i);
			  if(r1.getName().equals(room)) {
				  r =r1;
				  break;
			  }
		  }
		  Player suggest = null;
		  for(int i =0;i<players.size();i++) {
			  Player p1 = players.get(i);
			  if(p1.getName().equals(player)) {
				  suggest = p1;;
				  break;
			  }
		  }
		  if(r.getInRoom().contains(suggest)) {
			  movePlayerToRoom(r,suggest);
		  }
		  if(r.getWeapons().contains(weapon)) {
			  r.removeWeapon(weapon);
			  moveWeaponToRoom(r,weapon);
		  }
		  List<String> refuteCards = new ArrayList();
		  for(int i =1; i<=players.size();i++) {
			  Player p1 = players.get(i);
			  if(p1 != p) {
				  List<String> refute = p1.refute(suggestions);
				  if(refute.size()==0) {
					  System.out.println("Player " + i + " has not cards");
				  } else if (refute.size()==1) {
					  refuteCards.add(refute.get(0));
				  } else {
					  System.out.println("Player " + i + " please pick a card to show");
					  System.out.println(refute);
					  InputStreamReader in = new InputStreamReader(System.in);
					  Scanner scan = new Scanner(in);
					  System.out.println("Please pick a card to show");
					  String s = scan.next();
					  if(!refute.contains(s)) {
						  System.out.println("Please pick a card to show");
						  s = scan.next();
					  }
					  refuteCards.add(s);
				  }
			  }
		  }
		  
		  System.out.println("Original Player may now look at the cards");
		  System.out.println(refuteCards);
	  }
	  
	  public void movePlayerToRoom(Room r, Player p) {
		  for(int i =0;i<23;i++) {
			  for(int j =0;j<24;j++) {
				  Cell c = board.getCell(i, j);
				  if(c.getRoom() == r && c.getAccessable() && !c.isIsOccupied()) {
					  p.setCurrent(c);
					  return;
				  }
			  }
		  }
	  }
	  
	  public void moveWeaponToRoom(Room r, String weapon) {
		  for(int i =0;i<23;i++) {
			  for(int j =0;j<24;j++) {
				  Cell c = board.getCell(i, j);
				  if(c.getRoom() == r && c.getAccessable() && !c.isIsOccupied()) {
					  r.addToWeapon(weapon);
					  c.setIsOccupied(true);
					  c.setOccupier(weapon);
					  return;
				  }
			  }
		  }
	  }
		public void refuteAccuse(List<String> accuse, Player p) {
			for(int i =0;i<accuse.size();i++) {
				String name = accuse.get(i);
				if(!(name.equals(murder.name) || name.equals(mRoom.name) || name.equals(mWeapon.name))) {
					p.setLost(true);
					System.out.println("Unfortunately that is not right");
					return;
				}
			}
			System.out.println("Congratulations, that is correct");
			won = true;
		}
  
	  public void setUpPlayers() {
		  InputStreamReader in = new InputStreamReader(System.in);
		  Scanner scan = new Scanner(in);
		  System.out.println("How many people are playing?");
		  while(!scan.hasNextInt()) {
			scan.next();
			System.out.println("Please enter an Integer");
		}
		  int number = scan.nextInt();
		  while(number<3 || number>6) {
			  System.out.println("How many people are playing?");
			  while(!scan.hasNextInt()) {
				scan.next();
				System.out.println("Please enter an Integer between 3 and 6");
			}
			 number = scan.nextInt();
		  }
		  numPlayers = number;
		  List<String> chars = new ArrayList();
		  chars.add("ms");
		  chars.add("cm");
		  chars.add("mw");
		  chars.add("mg");
		  chars.add("mp");
		  chars.add("pp");
		  for(int i = 1;i<= numPlayers;i++) {
			  System.out.println(chars);
			  System.out.println("Player " + i + " please pick the player from the list");
			  String name = scan.next();
			  while(!chars.contains(name)) {
				  System.out.println("Player " + i + " please pick the player from the list");
				  name = scan.next();
			  }
			  Player p = new Player(name,new ArrayList<Card>(),false,null,null);
			  players.add(p);
			  chars.remove(name);
		  }
		  divideCards();
		  for(int i = 0; i<chars.size();i++) {
			  String n = chars.get(i);
			  Player p = new Player(n,new ArrayList<Card>(),true,null,null);
			  players.add(p);
		  }
		  movePlayersToStart();
		  moveWeapons();
	  }
	  
	  public void moveWeapons() {
		  List<String> weap = new ArrayList();
		  weap.add("c");
		  weap.add("d");
		  weap.add("p");
		  weap.add("g");
		  weap.add("r");
		  weap.add("s");
		  for(int i =0;i<6;i++) {
			  String weapon = weap.get(i);
			  int num = (int) (Math.random() * ((8) +1));
			  Room r = rooms.get(num);
			  while(r.weapons.size()>0) {
				  num = (int) (Math.random() * ((8) +1));
				  r = rooms.get(num);
			  }
			  r.addToWeapon(weapon);
		  }
	  }
	  
	  public void movePlayersToStart() {
		  Map<String,Cell> starting = new HashMap();
		  starting.put("mw",board.getCell(9, 0));
		  starting.put("mg",board.getCell(14, 0));
		  starting.put("mp",board.getCell(23, 6));
		  starting.put("pp",board.getCell(23, 19));
		  starting.put("ms",board.getCell(7, 24));
		  starting.put("cm",board.getCell(0, 17));
		  for(int i =0;i<players.size();i++) {
			  Player p = players.get(i);
			  Cell c = starting.get(p.getName());
			  p.setCurrent(c);
		  }
	  }
	  
	  public void divideCards() {
		  Collections.shuffle(cards);
		  int count =0;
		  for(int i =0;i<cards.size();i++) {
			  Card c = cards.get(i);
			  Player p = players.get(count);
			  p.addToHand(c);
			  count++;
			  if(count >=numPlayers) {
				  count = 0;
			  }
		  }
	  }
	  
	  public void setUpCharacterCards() {
		  ArrayList<CharacterCard> card = new ArrayList();
		  CharacterCard scarlett = new CharacterCard("ms");
		  CharacterCard mustard = new CharacterCard("cm");
		  CharacterCard white = new CharacterCard("mw");
		  CharacterCard green = new CharacterCard("mg");
		  CharacterCard peacock = new CharacterCard("mp");
		  CharacterCard plum = new CharacterCard("pp");
		  card.add(scarlett);
		  card.add(mustard);
		  card.add(white);
		  card.add(green);
		  card.add(peacock);
		  card.add(plum);
		  allCards.addAll(card);
		  Collections.shuffle(card);
		  murder = card.remove(0);
		  cards.addAll(card);
	  }
  
	public void setUpRoomCards() {
		ArrayList<RoomCard> card = new ArrayList();
		RoomCard kitchen = new RoomCard("kitchen");
		RoomCard ballroom = new RoomCard("ballroom");
		RoomCard conservatory = new RoomCard("conservatory");
		RoomCard billiard = new RoomCard("billiard");
		RoomCard library = new RoomCard("library");
		RoomCard study= new RoomCard("study");
		RoomCard hall = new RoomCard("hall");
		RoomCard lounge = new RoomCard("lounge");
		RoomCard dining = new RoomCard("dining");
		card.add(kitchen);
		card.add(ballroom);
		card.add(conservatory);
		card.add(billiard);
		card.add(library);
		card.add(study);
		card.add(hall);
		card.add(lounge);
		card.add(dining);
		allCards.addAll(card);
		Collections.shuffle(card);
		mRoom = card.remove(0);
		cards.addAll(card);
	  }
	
	public void setUpWeaponCards() {
		 ArrayList<WeaponCard> card = new ArrayList();
		 WeaponCard candle = new WeaponCard("c");
		 WeaponCard dagger = new WeaponCard("d");
		 WeaponCard pipe = new WeaponCard("p");
		 WeaponCard gun = new WeaponCard("g");
		 WeaponCard rope = new WeaponCard("r");
		 WeaponCard spanner = new WeaponCard("s");
		 card.add(candle);
		 card.add(dagger);
		 card.add(pipe);
		 card.add(gun);
		 card.add(rope);
		 card.add(spanner);
		 allCards.addAll(card);
		 Collections.shuffle(card);
		 mWeapon = card.remove(0);
		 cards.addAll(card);
	}
  
  public void setUpRooms() {
	  Room kitchen = new Room("kitchen", new ArrayList<Player>(),new ArrayList<String>());
	  Room ballroom = new Room("ballroom",new ArrayList<Player>(),new ArrayList<String>());
	  Room conservatory = new Room("conservatory",new ArrayList<Player>(),new ArrayList<String>());
	  Room billiard = new Room("billiard",new ArrayList<Player>(),new ArrayList<String>());
	  Room library = new Room("library",new ArrayList<Player>(),new ArrayList<String>());
	  Room study = new Room("study",new ArrayList<Player>(),new ArrayList<String>());
	  Room hall = new Room("hall",new ArrayList<Player>(),new ArrayList<String>());
	  Room lounge = new Room("lounge",new ArrayList<Player>(),new ArrayList<String>());
	  Room dining = new Room("dining",new ArrayList<Player>(),new ArrayList<String>());
	  Room none = new Room(null,new ArrayList<Player>(),new ArrayList<String>());
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
	  board = new Board();
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
			Cell c = new Cell(rooms.get(room),false,null,x,y,accessable);
			board.addCell(c, x, y);
			
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
	   int dice1 = 1 + (int) (Math.random() * ((6-1) +1));
	   int dice2 = 1 + (int) (Math.random() * ((6-1) +1));
    return dice1 + dice2;
  }

}