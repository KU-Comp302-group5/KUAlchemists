package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import domain.AlchemyMarker;
import domain.Aspect;
import domain.Ingredient;
import domain.PublicationTrack;
import domain.Theory;

/**
 * This class is for testing publishTheory method of PublicationTrack class
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PublishTheoryTest {
	PublicationTrack publicationTrack;
	
	// JUnit 5 setup before all tests
    @BeforeAll
    public void setUpBeforeAll() {
        System.out.println("This is a test for publishTheory() method from PublicationTrack class.");
    }

    // JUnit 5 setup before each test
	@BeforeEach
	void setUp(){
		publicationTrack = PublicationTrack.getInstance();
		publicationTrack.populateTrack();
		assertNotNull(publicationTrack, "getInstance() returns null");
		assertTrue(publicationTrack instanceof PublicationTrack, "getInstance() does not return PublicationTrack");
	}

	@Test // This tests that the correct Theory instance is created and publishedTheories are updated.
	final void testTheoryInstanceCreated() {
		
		Aspect as1 = new Aspect(true, true);
		Aspect as2 = new Aspect(true, false);
		Aspect as3 = new Aspect(false, false);
		Aspect as4 = new Aspect(false, true);
		
		Ingredient mushroom = new Ingredient("mushroom", 6, as4, as2, as3);
		
		AlchemyMarker marker2 = new AlchemyMarker(as1, as1, as1, 2);
		
		int playerNo = 1;
		
		publicationTrack.publishTheory(mushroom, marker2, playerNo);
		
		assertEquals(publicationTrack.getPublishedTheories().get(0).getIngredient(), mushroom);
		assertEquals(publicationTrack.getPublishedTheories().get(0).getMarker(), marker2);
		assertEquals(publicationTrack.getPublishedTheories().get(0).getPlayerNo(), playerNo);
	}
	
	@Test //
	final void test() {
		
	}
	

}
