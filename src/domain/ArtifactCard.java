package domain;

public class ArtifactCard {
    private String name;
    private Integer ID;
    
    public ArtifactCard(String name, Integer ID) {
    	this.name = name;
    	this.ID = ID;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	@Override
	public String toString() {
		return "ArtifactCard [name=" + name + "]";
	}
    
    
    
    
}