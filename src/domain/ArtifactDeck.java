package domain;

import java.util.List;

public class ArtifactDeck {
    private Integer cardNum;
    private List<ArtifactCard> artifacts;

    
    public ArtifactDeck(Integer cardNum, List<ArtifactCard> artifacts) {
		super();
		this.cardNum = cardNum;
		this.artifacts = artifacts;
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
	
	
}