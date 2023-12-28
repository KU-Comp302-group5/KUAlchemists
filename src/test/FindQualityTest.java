package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import domain.Aspect;
import domain.Ingredient;
import domain.PotionSale;

public class FindQualityTest {
	
	PotionSale ps = new PotionSale(null, null, 0);
	
	@Test
	public void expectedNullPointerException() {
		assertThrows(NullPointerException.class, ()-> {
		    ps.findQuality(null, null); 
		});
		assertThrows(NullPointerException.class, ()-> {
		    ps.findQuality(new Ingredient(null, 0 ,null, null, null) , new Ingredient(null, 0 ,null, null, null)); 
		});
	}
	
	@Test
	public void testWithSameIngredient() {
		Aspect a = new Aspect(true, true);
		assertEquals(0, ps.findQuality(new Ingredient("", 0 , a, a, a) , new Ingredient("", 0 , a, a, a)));
	}
	
	@Test
	public void testWithSameSize() {
		Aspect a = new Aspect(true, true);
		Aspect b = new Aspect(false, true);
		Aspect c = new Aspect(true, false);
		Aspect d = new Aspect(false, false);
		assertEquals(0, ps.findQuality(new Ingredient("", 0 , a, b, a) , new Ingredient("", 0 , c, d, c)));
	}
	
	//test with different size different sign --> return 0
	//test with different size same sign --> 1 if sign == true, -1 if sign == false
	//test with more than one aspect with different size same sign (which aspect determines quality?)

}
