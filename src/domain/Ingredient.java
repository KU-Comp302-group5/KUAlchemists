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

	@Override
	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Aspect getRedAspect() {
		return redAspect;
	}

	public void setRedAspect(Aspect redAspect) {
		this.redAspect = redAspect;
	}

	public Aspect getGreenAspect() {
		return greenAspect;
	}

	public void setGreenAspect(Aspect greenAspect) {
		this.greenAspect = greenAspect;
	}

	public Aspect getBlueAspect() {
		return blueAspect;
	}

	public void setBlueAspect(Aspect blueAspect) {
		this.blueAspect = blueAspect;
	}
    
}
