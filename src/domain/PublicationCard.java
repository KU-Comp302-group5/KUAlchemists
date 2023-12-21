package domain;

public class PublicationCard {
	private Aspect aspect;
	private Ingredient ingredient;
	
	public PublicationCard(Aspect aspect, Ingredient ingredient) {
		this.aspect = aspect;
		this.ingredient = ingredient;
	}

	public Aspect getAspect() {
		return aspect;
	}

	public void setAspect(Aspect aspect) {
		this.aspect = aspect;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}
        
    }
}