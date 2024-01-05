package domain.controllers;

import domain.DeductionBoard;
import domain.KUAlchemistsGame;
import domain.Potion;

public class DeductionBoardHandler{

    public DeductionBoardHandler(){
    }

    public void markResultsTriangle(int index, int quality) {
    	DeductionBoard dbBoard = KUAlchemistsGame.getInstance().getCurrentPlayer().getdBoard();
    	dbBoard.markResultsTriangle(index, new Potion(quality));
    	
    }

    public void markDeductionGrid(int ingrIndex, int markerIndex) {
    	DeductionBoard dbBoard = KUAlchemistsGame.getInstance().getCurrentPlayer().getdBoard();
    	dbBoard.markDeductionGrid(ingrIndex, markerIndex);
    	
    }
}