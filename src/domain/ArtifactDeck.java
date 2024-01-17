package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArtifactDeck {
	
	private static ArtifactDeck instance;
	
    private int cardNum;
    private List<ArtifactCard> artifacts;
    
    public static ArtifactDeck getInstance() {
    	
		if (instance == null) {
			instance = new ArtifactDeck();
		}
		
		return instance;
	}
    
    public ArtifactDeck() {
		super();
		this.cardNum = 4;
		List<ArtifactCard> artifacts = new ArrayList<ArtifactCard>();
		artifacts.add(new ArtifactCard("Elixir of Insight", 0, true));
		artifacts.add(new ArtifactCard("Printing Press", 1, false));
		//wisdom idol -> id = 3
		//printing press -> id = 1
		artifacts.add(new ArtifactCard("Magic Mortar", 2, false));
		artifacts.add(new ArtifactCard("Wisdom Idol", 3, false));
		Collections.shuffle(artifacts);
		this.artifacts = artifacts ;
	}

	public ArtifactCard getTopCard() {
		if (cardNum > 0) {
			ArtifactCard card = artifacts.get(cardNum-1);
	    	artifacts.remove(cardNum-1);
	    	cardNum--;
	    	return card;
		}
		else {
			System.out.println("No cards to draw in the artifact cards deck");
			return null;
		}
    }


	public Integer getCardNum() {
		return cardNum;
	}


	public void setCardNum(Integer cardNum) {
		this.cardNum = cardNum;
	}


	public List<ArtifactCard> getArtifacts() {
		return artifacts;
	}


	public void setArtifacts(List<ArtifactCard> artifacts) {
		this.artifacts = artifacts;
	}
	
	@Override
	public String toString() {
		return "ArtifactDeck [cardNum=" + cardNum + ", artifacts=" + artifacts + "]";
	}
}