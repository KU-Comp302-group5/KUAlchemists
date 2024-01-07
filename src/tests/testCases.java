package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import domain.ArtifactCard;
import domain.Ingredient;
import domain.Player;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class testCases {
    private Player p;
    
    @BeforeAll
    public void setUpBeforeAll() {
        p = new Player("bugra", 1);
        System.out.println("Setting up a new player for all tests.");
    }
    
    @AfterAll
    public void tearDownAfterAll() {
        p = null; // Cleanup after all tests are done
        System.out.println("Cleaning up after all tests.");
    }
    @Test
    @DisplayName("Test initial sickness")
    public void testInitialSickness() {
        assertEquals(0, p.getSickness(), "Initial sickness should be 0");
        
        System.out.println("testInitialSickness: done");

    }
    @Test
    @DisplayName("Test initial gold")
    public void testInitialGold() {
        int initialGold = p.getGold();
        assertEquals(10, initialGold, "Initial gold should be 10");
    }
    @Test
    @DisplayName("Test setting and getting username")
    public void testSetGetUsername() {
        p.setUsername("John");
        assertNotEquals("bugra", p.getUsername(), "Username is not bugra, it is changed already.");
        assertEquals("John", p.getUsername(), "Username should be John");
        System.out.println("testSetGetUsername: done");
    }
    
    @Test
    @DisplayName("Test adding an artifact")
    public void testAddArtifact() {
        int initialSize = p.getArtifacts().size();
        p.getArtifacts().add(new ArtifactCard("Artifact card [testing]", 100, true));
        assertTrue(p.getArtifacts().size() > initialSize, "Artifact card is added");
        System.out.println("testAddArtifact: done");
    }
    
    @Test
 @DisplayName("Test removing a potion")
 public void testRemovePotion() {
     assertThrows(IndexOutOfBoundsException.class, () -> {
     	
         p.getPotions().remove(0);
     }, 
     		"Removing potion should throw UnsupportedOperationException");
     
     System.out.println("testRemovePotion: 'we do not have any potion initially' done");
 }
}

