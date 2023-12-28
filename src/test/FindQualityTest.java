package test;

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
	

}
