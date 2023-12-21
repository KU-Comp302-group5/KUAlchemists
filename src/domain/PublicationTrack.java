package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PublicationTrack {
	
	private static PublicationTrack instance;
	
    private List<AlchemyMarker> availableAlchemies;
    private List<Ingredient> availableIngredients;
    private List<Theory> publishedTheories;
    
    
	public static PublicationTrack getInstance() {
		if (instance == null) {
			instance = new PublicationTrack();
		}
		return instance;
	}
    
	public PublicationTrack() {
		populateTrack();
		this.publishedTheories = new ArrayList<Theory>();
	}
	
	public void publishTheory(Ingredient ingr, AlchemyMarker marker, int playerNo) {
		Theory publishedTheory = new Theory(ingr, marker, playerNo);
		publishedTheories.add(publishedTheory);
	}

	private void populateTrack() {
		populateAvailableAlchemies();
		populateAvailableIngredients();
	}

	private void populateAvailableIngredients() {
		
		List<Ingredient> ingrs = new ArrayList<Ingredient>();
		
		Aspect as1 = new Aspect(true, true);
		Aspect as2 = new Aspect(true, false);
		Aspect as3 = new Aspect(false, false);
		Aspect as4 = new Aspect(false, true);
		
		//Ingredient(name, ID, red, green, blue)
		Ingredient toad = new Ingredient("toad", 1, as3, as1, as4);
		Ingredient claw = new Ingredient("claw", 2, as1, as1, as1);
		Ingredient scorpion = new Ingredient("scorpion", 3, as3, as1, as4);
		Ingredient fern = new Ingredient("fern", 4, as2, as2, as2);
		Ingredient feather = new Ingredient("feather", 5, as1, as4, as3);
		Ingredient mushroom = new Ingredient("mushroom", 6, as4, as2, as3);
		Ingredient flower = new Ingredient("flower", 7, as4, as3, as1);
		Ingredient root = new Ingredient("root", 8, as2, as3, as4);
		
		ingrs.add(toad);
		ingrs.add(claw);
		ingrs.add(scorpion);
		ingrs.add(fern);
		ingrs.add(feather);
		ingrs.add(mushroom);
		ingrs.add(flower);
		ingrs.add(root);
		
		Collections.shuffle(ingrs);
		
		this.availableIngredients = ingrs;
	}

	private void populateAvailableAlchemies() {
		
		List<AlchemyMarker> markers = new ArrayList<AlchemyMarker>();
		
		Aspect as1 = new Aspect(true, true);
		Aspect as2 = new Aspect(true, false);
		Aspect as3 = new Aspect(false, false);
		Aspect as4 = new Aspect(false, true);
		
		//AlchemyMarker(red, green, blue)
		AlchemyMarker marker1 = new AlchemyMarker(as3, as1, as4);
		AlchemyMarker marker2 = new AlchemyMarker(as1, as1, as1);
		AlchemyMarker marker3 = new AlchemyMarker(as3, as1, as4);
		AlchemyMarker marker4 = new AlchemyMarker(as2, as2, as2);
		AlchemyMarker marker5 = new AlchemyMarker(as1, as4, as3);
		AlchemyMarker marker6 = new AlchemyMarker(as4, as2, as3);
		AlchemyMarker marker7 = new AlchemyMarker(as4, as3, as1);
		AlchemyMarker marker8 = new AlchemyMarker(as2, as3, as4);
		
		markers.add(marker1);
		markers.add(marker2);
		markers.add(marker3);
		markers.add(marker4);
		markers.add(marker5);
		markers.add(marker6);
		markers.add(marker7);
		markers.add(marker8);
		
		Collections.shuffle(markers);
		
		this.availableAlchemies = markers;	
	}
}
