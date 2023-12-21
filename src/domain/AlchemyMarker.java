package domain;

public class AlchemyMarker {
    private Aspect redAspect;
    private Aspect blueAspect;
    private Aspect greenAspect;
    private int ID;
    
	public AlchemyMarker(Aspect redAspect, Aspect blueAspect, Aspect greenAspect, int ID) {
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
