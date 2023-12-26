package domain;

public class PotionSale{
    private int prediction;
    private Potion potion;

    public PotionSale(Ingredient ingr1, Ingredient ingr2, int prediction) {
        this.prediction = prediction;
        this.potion = new Potion(ingr1, ingr2);
    }

	public Potion getPotion() {
		return potion;
	}

	public void setPotion(Potion potion) {
		this.potion = potion;
	}

	public int getPrediction() {
		return prediction;
	}

	public void setPrediction(int prediction) {
		this.prediction = prediction;
	}
	

    
}