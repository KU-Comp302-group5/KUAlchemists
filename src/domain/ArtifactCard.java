package domain;

public class ArtifactCard {
    private String name;
    private Integer ID;
    
    public ArtifactCard(String name, Integer ID) {
    	this.name = name;
    	this.ID = ID;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	@Override
	public String toString() {
		return "ArtifactCard [name=" + name + "]";
	}
	
	public void obtainAbility() {
		if(this.ID == 0) {
			// UI : IngredientDeckUI.showTopThreeCards()
			// and IngredientDeckUI.rearrange() --> IngredientDeck.rearrange()
		}
		if (this.ID == 1) {
			// UI : DeductionBoardUI.swap() --> DeductionBoard.swap(alchemyMarker1, alchemyMarker2)
			// buradan emin olamadým, bu sadece UI funvtionality de olabilir.
		}
	}
    
    
    
    
}