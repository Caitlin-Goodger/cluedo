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
		Player p = new Player("test",new ArrayList<Card>(),false,null,null);
		assertTrue("test".equals(p.getName()));
	}
	
	@Test public void test02() {
		Player p = new Player("test",new ArrayList<Card>(),false,null,null);
		assertTrue(false == p.getLost());
	}
	
	@Test public void test03() {
		Room r = new Room("room", new ArrayList(), new ArrayList());
		Player p = new Player("test",new ArrayList<Card>(),false,null,r);
		assertTrue(p.getRoom().equals(r));
	}
	
	@Test public void test04() {
		Player p = new Player("test",new ArrayList<Card>(),false,null,null);
		assertTrue(p.getHand().size()==0);
	}
	
	@Test public void test05() {
		Player p = new Player("test",new ArrayList<Card>(),false,null,null);
		Card c = new WeaponCard("Card");
		p.addToHand(c);
		assertTrue(p.getHand().size()==1);
	}
	
	@Test public void test06() {
		Player p = new Player("test",new ArrayList<Card>(),false,null,null);
		assertTrue("test".equals(p.getName()));
	}
	
	@Test public void test07() {
		Player p = new Player("test",new ArrayList<Card>(),false,null,null);
		assertTrue("test".equals(p.getName()));
	}
	
	@Test public void test08() {
		Player p = new Player("test",new ArrayList<Card>(),false,null,null);
		assertTrue("test".equals(p.getName()));
	}
	
	@Test public void test09() {
		Player p = new Player("test",new ArrayList<Card>(),false,null,null);
		assertTrue("test".equals(p.getName()));
	}
	
	@Test public void test10() {
		Player p = new Player("test",new ArrayList<Card>(),false,null,null);
		assertTrue("test".equals(p.getName()));
	}
	
	@Test public void test11() {
		Player p = new Player("test",new ArrayList<Card>(),false,null,null);
		assertTrue("test".equals(p.getName()));
	}
	
	@Test public void test12() {
		Player p = new Player("test",new ArrayList<Card>(),false,null,null);
		assertTrue("test".equals(p.getName()));
	}
	
	@Test public void test13() {
		Player p = new Player("test",new ArrayList<Card>(),false,null,null);
		assertTrue("test".equals(p.getName()));
	}
	
	@Test public void test14() {
		Player p = new Player("test",new ArrayList<Card>(),false,null,null);
		assertTrue("test".equals(p.getName()));
	}
	
	@Test public void test15() {
		Player p = new Player("test",new ArrayList<Card>(),false,null,null);
		assertTrue("test".equals(p.getName()));
	}
	
	@Test public void test16() {
		Player p = new Player("test",new ArrayList<Card>(),false,null,null);
		assertTrue("test".equals(p.getName()));
	}
	
	@Test public void test17() {
		Player p = new Player("test",new ArrayList<Card>(),false,null,null);
		assertTrue("test".equals(p.getName()));
	}
	
	@Test public void test18() {
		Player p = new Player("test",new ArrayList<Card>(),false,null,null);
		assertTrue("test".equals(p.getName()));
	}
	
	@Test public void test19() {
		Player p = new Player("test",new ArrayList<Card>(),false,null,null);
		assertTrue("test".equals(p.getName()));
	}
	
	@Test public void test20() {
		Player p = new Player("test",new ArrayList<Card>(),false,null,null);
		assertTrue("test".equals(p.getName()));
	}
}
