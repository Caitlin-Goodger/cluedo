package tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;

import org.junit.Test;
import swen225.*;


public class CluedoTest {

	@Test public void test01() {
		Player p = new Player("test",new ArrayList<Card>(),false,null,null,null);
		assertTrue("test".equals(p.getName()));
	}
	
	@Test public void test02() {
		Player p = new Player("test",new ArrayList<Card>(),false,null,null,null);
		assertTrue(false == p.getLost());
	}
	
	@Test public void test03() {
		Room r = new Room("room", new ArrayList(), new ArrayList());
		Player p = new Player("test",new ArrayList<Card>(),false,null,r,null);
		assertTrue(p.getRoom().equals(r));
	}
	
	@Test public void test04() {
		Player p = new Player("test",new ArrayList<Card>(),false,null,null,null);
		assertTrue(p.getHand().size()==0);
	}
	
	@Test public void test05() {
		Player p = new Player("test",new ArrayList<Card>(),false,null,null,null);
		Card c = new WeaponCard("Card","c");
		p.addToHand(c);
		assertTrue(p.getHand().size()==1);
	}
	
	@Test public void test06() {
		Player p = new Player("test",new ArrayList<Card>(),false,null,null,null);
		p.setLost(true);
		assertTrue(p.getLost());
	}
	
	@Test public void test07() {
		Cell c = new Cell(null,false,null,0,0,false);
		Player p = new Player("test",new ArrayList<Card>(),false,c,null,null);
		assertTrue(p.getCurrent() == c);
	}
	
	@Test public void test08() {
		Cell c = new Cell(null,false,null,0,0,false);
		assertTrue(!c.getIsOccupied());
	}
	
	@Test public void test09() {
		Cell c = new Cell(null,false,null,0,0,false);
		c.setIsOccupied(true);
		assertTrue(c.getIsOccupied());
	}
	
	@Test public void test10() {
		Cell c = new Cell(null,false,null,0,0,false);
		assertTrue(!c.getAccessable());
	}
	
	@Test public void test11() {
		Cell c = new Cell(null,false,null,0,0,false);
		c.setAccessable(true);
		assertTrue(c.getAccessable());
	}
	
	@Test public void test12() {
		Room r = new Room("room", new ArrayList(), new ArrayList());
		Cell c = new Cell(r,false,null,0,0,false);
		assertTrue(c.getRoom()==r);
	}
	
	@Test public void test13() {
		Cell c = new Cell(null,false,"Weapon",0,0,false);
		assertTrue(c.getOccupier().equals("Weapon"));
	}
	
	@Test public void test14() {
		Cell c = new Cell(null,false,"Weapon",5,0,false);
		assertTrue(c.getX()==5);
	}
	
	@Test public void test15() {
		Cell c = new Cell(null,false,"Weapon",5,7,false);
		assertTrue(c.getY()==7);
	}
	
	@Test public void test16() {
		Room r = new Room("room", new ArrayList(), new ArrayList());
		assertTrue(r.getName().equals("room"));
	}
	
	@Test public void test17() {
		Room r = new Room("room", new ArrayList(), new ArrayList());
		r.addToWeapon("weapon");
		assertTrue(r.getWeapons().size()==1);
	}
	
	@Test public void test18() {
		Room r = new Room("room", new ArrayList(), new ArrayList());
		Player p = new Player("test",new ArrayList<Card>(),false,null,null,null);
		r.addToRoom(p);
		assertTrue(r.getInRoom().size()==1);
	}
	
	@Test public void test19() {
		WeaponCard weapon = new WeaponCard("weapon","c");
		assertTrue(weapon.getName().equals("weapon"));
	}
	
	@Test public void test20() {
		RoomCard room = new RoomCard("room");
		assertTrue(room.getName().equals("room"));
	}
	
	@Test public void test21() {
		CharacterCard cc = new CharacterCard("cc");
		assertTrue(cc.getName().equals("cc"));
	}
}
