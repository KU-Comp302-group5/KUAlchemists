package domain;

import java.io.Serializable;

public class ArtifactCard implements Serializable {
    private String name;
    private Integer ID;
    private Boolean hasPanel;
    private String image;
    
    public ArtifactCard(String name, Integer ID, Boolean hasPanel) {
    	this.name = name;
    	this.ID = ID;
    	this.hasPanel = hasPanel;
    	switch(ID) {
		case 0:
			this.image="images/elixirartf.png";
			break;
		case 1:
			this.image="images/printingpressartf.png";
			break;
		case 2:
			this.image="images/magicmortarartf.png";
			break;
		case 3:
			this.image="images/wisdomidolartf.png";
			break;
		}
    }

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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
	
	@Override
   public boolean equals(Object obj) { // implemented for the "contains" functionality of Lists
      ArtifactCard ac = (ArtifactCard)obj;
      return this.ID == ac.ID && this.name.equalsIgnoreCase(ac.name) && this.hasPanel == ac.hasPanel;
   }

	public Boolean getHasPanel() {
		return hasPanel;
	}

	public void setHasPanel(Boolean hasPanel) {
		this.hasPanel = hasPanel;
	}
	
	// now in UseArtifactHandler
	/*
	public void obtainAbility() {
		if(this.ID == 0) {
			// UI : IngredientDeckUI.showTopThreeCards()
			// and IngredientDeckUI.rearrange() --> IngredientDeck.rearrange()
		}
		if (this.ID == 1) {
			// UI : DeductionBoardUI.swap() --> DeductionBoard.swap(alchemyMarker1, alchemyMarker2)
			// buradan emin olamad�m, bu sadece UI funvtionality de olabilir.
		}
	}
    */
    
    
    
}