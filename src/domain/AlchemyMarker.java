package domain;

public class AlchemyMarker {
    private Aspect redAspect;
    private Aspect greenAspect;
    private Aspect blueAspect;
    private int ID;
    
	public AlchemyMarker(Aspect redAspect, Aspect greenAspect, Aspect blueAspect, int ID) {
		this.redAspect = redAspect;
		this.blueAspect = blueAspect;
		this.greenAspect = greenAspect;
		this.ID = ID;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Aspect getRedAspect() {
		return redAspect;
	}

	public void setRedAspect(Aspect redAspect) {
		this.redAspect = redAspect;
	}

	public Aspect getBlueAspect() {
		return blueAspect;
	}

	public void setBlueAspect(Aspect blueAspect) {
		this.blueAspect = blueAspect;
	}

	public Aspect getGreenAspect() {
		return greenAspect;
	}

	public void setGreenAspect(Aspect greenAspect) {
		this.greenAspect = greenAspect;
	}
	
}
