package domain.controllers;

import domain.DeductionBoard;
import domain.KUAlchemistsGame;

public class DeductionBoardHandler{

    public DeductionBoardHandler(){
    }

    public void markResultsTriangle() {
    }

    public void markDeductionGrid(int ingrIndex, int markerIndex) {
    	DeductionBoard dbBoard = KUAlchemistsGame.getInstance().getCurrentPlayer().getdBoard();
    	dbBoard.markDeductionGrid(ingrIndex, markerIndex);
    	
    }
}