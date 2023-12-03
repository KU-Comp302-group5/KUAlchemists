package domain;

public class HandlerFactory {
	private static HandlerFactory instance;
	
	private BuyArtifactHandler buyArtifactHandler;
	private UseArtifactHandler useArtifactHandler;
	
	public static HandlerFactory getInstance() {
		if (instance == null) {
			instance = new HandlerFactory();
		}
		
		return instance;
	}

	public HandlerFactory() {
		super();
		this.buyArtifactHandler= new BuyArtifactHandler();
	}

	public BuyArtifactHandler getBuyArtifactHandler() {
		return buyArtifactHandler;
	}

	public void setBuyArtifactHandler(BuyArtifactHandler buyArtifactHandler) {
		this.buyArtifactHandler = buyArtifactHandler;
	}

	public UseArtifactHandler getUseArtifactHandler() {
		return useArtifactHandler;
	}

	public void setUseArtifactHandler(UseArtifactHandler useArtifactHandler) {
		this.useArtifactHandler = useArtifactHandler;
	}
	
	

	
}
