package domain;

public class PotionMaker {
    private Potion potion;
    private int ID;

    
    public PotionMaker() {
	}

	public Potion mixIngredients(Ingredient ingr1, Ingredient ingr2) {
		boolean ingr1redsize = ingr1.getRedAspect().isCircleSize();
		boolean ingr1redsign = ingr1.getRedAspect().isSign();
		boolean ingr1greensize = ingr1.getGreenAspect().isCircleSize();
		boolean ingr1greensign = ingr1.getGreenAspect().isSign();
		boolean ingr1bluesize = ingr1.getBlueAspect().isCircleSize();
		boolean ingr1bluesign = ingr1.getBlueAspect().isSign();
		
		boolean ingr2redsize = ingr2.getRedAspect().isCircleSize();
		boolean ingr2redsign = ingr2.getRedAspect().isSign();
		boolean ingr2greensize = ingr2.getGreenAspect().isCircleSize();
		boolean ingr2greensign = ingr2.getGreenAspect().isSign();
		boolean ingr2bluesize = ingr2.getBlueAspect().isCircleSize();
		boolean ingr2bluesign = ingr2.getBlueAspect().isSign();
		
		int quality = 0;
		
		if (ingr1redsize == !ingr2redsize) {
			if(ingr1redsign == ingr2redsign) {
				if(ingr1redsign) {
					quality=1;
				}
				else {
					quality=-1;
				}
			}
		}
		
		else if (ingr1greensize == !ingr2greensize) {
			if(ingr1greensign == ingr2greensign) {
				if(ingr1greensign) {
					quality=1;
				}
				else {
					quality=-1;
				}
			}
		}
		
		else if (ingr1bluesize == !ingr2bluesize) {
			if(ingr1bluesign == ingr2bluesign) {
				if(ingr1bluesign) {
					quality=1;
				}
				else {
					quality=-1;
				}
			}
		}
		
		Potion pt = new Potion(ingr1, ingr2, quality);
		
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
