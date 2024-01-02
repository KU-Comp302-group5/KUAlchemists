package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import domain.Aspect;
import domain.Ingredient;
import domain.PotionSale;

public class FindQualityTest {
	
	Aspect a = new Aspect(true, true);
	Aspect b = new Aspect(false, true);
	Aspect c = new Aspect(true, false);
	Aspect d = new Aspect(false, false);
	
	PotionSale ps = new PotionSale(new Ingredient("", 0 , a, a, a), new Ingredient("", 0 , a, a, a), 0);
	
	@Test
	public void expectedNullPointerException() {
		assertThrows(NullPointerException.class, ()-> {
		    ps.findQuality(null, null); 
		});
		Ingredient ingr1 = new Ingredient(null, 0 ,null, null, null);
		Ingredient ingr2 = new Ingredient("", 0 ,a, b, c);
		assertThrows(NullPointerException.class, ()-> {
		    ps.findQuality(ingr1, ingr2); 
		});
		assertThrows(NullPointerException.class, ()-> {
		    ps.findQuality(ingr1, ingr1); 
		});
	}
	
	@Test
	public void testWithSameIngredient() {
		assertEquals(0, ps.findQuality(new Ingredient("", 0 , a, a, a) , new Ingredient("", 0 , a, a, a)));
	}
	
	@Test
	public void testWithSameSize() {
		assertEquals(0, ps.findQuality(new Ingredient("", 0 , a, b, a) , new Ingredient("", 0 , c, d, c)));
	}
	
	//test with different size different sign --> return 0
	//test with different size same sign --> 1 if sign == true, -1 if sign == false
	//test with more than one aspect with different size same sign (which aspect determines quality?)

}
