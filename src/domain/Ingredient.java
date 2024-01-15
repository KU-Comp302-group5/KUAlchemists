package domain;

public class Ingredient {
    private String name;
    private int id;
    private Aspect redAspect;
    private Aspect greenAspect;
    private Aspect blueAspect;
    private String image; 
    
	public Ingredient(String name, int id, Aspect redAspect, Aspect greenAspect, Aspect blueAspect) {
		this.name = name;
		this.id = id;
		this.redAspect = redAspect;
		this.greenAspect = greenAspect;
		this.blueAspect = blueAspect;
		switch(id) {
		case 1:
			this.image="rat.png";
			break;
		case 2:
			this.image="birdi.png";
			break;
		case 3:
			this.image="garlic.png";
			break;
		case 4:
			this.image="clover.png";
			break;
		case 5:
			this.image="aloevera.png";
			break;
		case 6:
			this.image="mushroomi.png";
			break;
		case 7:
			this.image="floweri.png";
			break;
		case 8:
			this.image="bluelotus.png";
			break;
		}
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Ingredient [name=" + name + ", id=" + id + "]";
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
