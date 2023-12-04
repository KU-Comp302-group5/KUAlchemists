package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArtifactDeck {
	
	private static ArtifactDeck instance;
	
    private Integer cardNum;
    private List<ArtifactCard> artifacts;
    
    public static ArtifactDeck getInstance() {
    	
		if (instance == null) {
			instance = new ArtifactDeck();
		}
		
		return instance;
	}
    
    public ArtifactDeck() {
		super();
		this.cardNum = 2;
		List<ArtifactCard> artifacts = new ArrayList<ArtifactCard>();
		artifacts.add(new ArtifactCard("Elixir of Insight", 0));
		artifacts.add(new ArtifactCard("Philosopher's Compass", 1));
		Collections.shuffle(artifacts);
		this.artifacts = artifacts ;
	}


	public ArtifactCard getTopCard() {
    	ArtifactCard card = artifacts.get(cardNum-1);
    	artifacts.remove(cardNum-1);
    	cardNum--;
    	return card;
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