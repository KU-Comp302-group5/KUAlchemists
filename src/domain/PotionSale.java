package domain;

public class PotionSale{
    private int prediction;
    private Potion potion;

    public PotionSale(Ingredient ingr1, Ingredient ingr2, int prediction) {
        this.prediction = prediction;
        int quality = findQuality(ingr1, ingr2);
        this.potion = new Potion(quality);
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
	
public int findQuality(Ingredient ingr1, Ingredient ingr2) {
	
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
		return quality;
	}
	

    
}