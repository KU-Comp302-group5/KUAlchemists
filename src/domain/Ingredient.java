package domain;

public class Ingredient {
    private String name;
    private int id;
    private Aspect redAspect;
    private Aspect greenAspect;
    private Aspect blueAspect;
    
	public Ingredient(String name, int id, Aspect redAspect, Aspect greenAspect, Aspect blueAspect) {
		this.name = name;
		this.id = id;
		this.redAspect = redAspect;
		this.greenAspect = greenAspect;
		this.blueAspect = blueAspect;
	}
    
    
}
