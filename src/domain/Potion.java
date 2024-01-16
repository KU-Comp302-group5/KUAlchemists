package domain;

import java.io.Serializable;

public class Potion implements Serializable {
    //private Ingredient ingr1;
    //private Ingredient ingr2;
    private int quality;
    
	public Potion(int quality) {
		super();
		//this.ingr1 = ingr1;
		//this.ingr2 = ingr2;
		//int quality = this.findQuality();
		this.quality = quality;
	}

	/*public Ingredient getIngr1() {
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
	}*/

	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}
	
	/*public int findQuality() {
		
		Ingredient ingr1 = this.ingr1;
		boolean ingr1redsize = ingr1.getRedAspect().isCircleSize();
		boolean ingr1redsign = ingr1.getRedAspect().isSign();
		boolean ingr1greensize = ingr1.getGreenAspect().isCircleSize();
		boolean ingr1greensign = ingr1.getGreenAspect().isSign();
		boolean ingr1bluesize = ingr1.getBlueAspect().isCircleSize();
		boolean ingr1bluesign = ingr1.getBlueAspect().isSign();
		
		Ingredient ingr2 = this.ingr2;
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
	}*/
	
	
}
