package domain;

public class PotionMaker {
    private Potion potion;
    private int ID;

    
    public PotionMaker() {
	}

	public Potion mixIngredients(Ingredient ingr1, Ingredient ingr2) {		
		Potion pt = new Potion(ingr1, ingr2);
		
		this.potion = pt;
		
		return pt;
    }
	
	public int tryPotion(String experimental) {
		
		if(this.potion.getQuality()==-1) {
			if (experimental.equals("student")){
				return 0;
			}
			else {
				return 1; //try on yourself
			}
		}
		
		return -1; //positive or neutral potion
		
	}
}
