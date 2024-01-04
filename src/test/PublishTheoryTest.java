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

import domain.PublicationTrack;

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

	@Test 
	final void testPublishTheory() {
		System.out.println("Not yet implemented"); // TODO
	}

}
