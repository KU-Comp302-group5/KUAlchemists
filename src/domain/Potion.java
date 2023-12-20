package domain;

public class Potion {
    private Ingredient ingr1;
    private Ingredient ingr2;
    private int quality;
    
	public Potion(Ingredient ingr1, Ingredient ingr2, int quality) {
		super();
		this.ingr1 = ingr1;
		this.ingr2 = ingr2;
		this.quality = quality;
	}

	public Ingredient getIngr1() {
		return ingr1;
	}

	public void setIngr1(Ingredient ingr1) {
		this.ingr1 = ingr1;
	}

	public Ingredient getIngr2() {
		return ingr2;
	}

	public void setIngr2(Ingredient ingr2) {
		this.ingr2 = ingr2;
	}

	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}
	
}
