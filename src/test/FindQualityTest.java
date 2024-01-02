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
		Ingredient ingr1 = new Ingredient("1", 0 , a, a, a);
		Ingredient ingr2 = new Ingredient("2", 0 , a, b, c);
		Ingredient ingr3 = new Ingredient("3", 0 , a, b, c);
		assertEquals(0, ps.findQuality(ingr1, ingr1));
		assertEquals(0, ps.findQuality(ingr2, ingr3));
	}
	
	@Test
	public void testWithSameSize() {
		Ingredient ingr1 = new Ingredient("1", 0 , a, b, a);
		Ingredient ingr2 = new Ingredient("2", 0 , c, d, c);
		assertEquals(0, ps.findQuality(ingr1, ingr2));
		
		Ingredient ingr3 = new Ingredient("3", 0 , a, c, c);
		Ingredient ingr4 = new Ingredient("4", 0 , c, a, c);
		assertEquals(0, ps.findQuality(ingr3, ingr4));
	}
	
	//test with different size different sign --> return 0
	//test with different size same sign --> 1 if sign == true, -1 if sign == false
	//test with more than one aspect with different size same sign (which aspect determines quality?)

}
