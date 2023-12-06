package domain.controllers;

import java.util.ArrayList;
import java.util.List;

import domain.ArtListener;
import domain.IngListener;

public class HandlerFactory {
	private static HandlerFactory instance;
	
	private LoginHandler loginHandler;
	private BuyArtifactHandler buyArtifactHandler;
	private UseArtifactHandler useArtifactHandler;
	private ForageIngHandler forageIngHandler;
	private TransmuteIngredientHandler transmuteIngHandler;
	
	public static HandlerFactory getInstance() {
		if (instance == null) {
			instance = new HandlerFactory();
		}
		return instance;
	}

	public HandlerFactory() {
		super();
		this.buyArtifactHandler= new BuyArtifactHandler();
		this.forageIngHandler= new ForageIngHandler();
		this.transmuteIngHandler= new TransmuteIngredientHandler();
		this.useArtifactHandler= new UseArtifactHandler();
		this.loginHandler= new LoginHandler();
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

	public ForageIngHandler getForageIngHandler() {
		return forageIngHandler;
	}

	public void setForageIngHandler(ForageIngHandler forageIngHandler) {
		this.forageIngHandler = forageIngHandler;
	}

	public TransmuteIngredientHandler getTransmuteIngHandler() {
		return transmuteIngHandler;
	}

	public void setTransmuteIngHandler(TransmuteIngredientHandler transmuteIngHandler) {
		this.transmuteIngHandler = transmuteIngHandler;
	}

	public LoginHandler getLoginHandler() {
		return loginHandler;
	}

	public void setLoginHandler(LoginHandler loginHandler) {
		this.loginHandler = loginHandler;
	}
	
}
