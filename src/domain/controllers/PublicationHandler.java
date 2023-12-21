package domain.controllers;

import domain.AlchemyMarker;
import domain.Ingredient;
import domain.Player;
import domain.PublicationTrack;

public class PublicationHandler {
	
	public void makePublication(Ingredient ingr, AlchemyMarker marker, int playerNo){
		PublicationTrack.getInstance().publishTheory(ingr, marker, playerNo);
	}
}
