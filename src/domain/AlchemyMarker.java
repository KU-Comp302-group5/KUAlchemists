package domain;

public class AlchemyMarker {
    private Aspect redAspect;
    private Aspect blueAspect;
    private Aspect greenAspect;
    
	public AlchemyMarker(Aspect redAspect, Aspect blueAspect, Aspect greenAspect) {
		this.redAspect = redAspect;
		this.blueAspect = blueAspect;
		this.greenAspect = greenAspect;
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
