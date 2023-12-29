package domain;

import java.util.ArrayList;
import java.util.List;

public class DeductionBoard {
    private Potion[] resultsTriangle;
    private Boolean[][] deductionGrid;

    
    public DeductionBoard() {
    	
    	// elements initially null
    	// structure:
    	//        [1]
    	//      [2] [3]
    	//    [4] [5] [6] ...
    	this.resultsTriangle = new Potion[28];
    	
    	// all elements initialized to false, no X mark
    	this.deductionGrid = new Boolean[8][];
    	for (int i = 0; i < 8; i++) {
            deductionGrid[i] = new Boolean[8];
            for (int k = 0; i < 8; i++) {
            	deductionGrid[i][k] = false;
            }
        }
	}

	public void markResultsTriangle(int index, Potion pt) {
		resultsTriangle[index] = pt;
		// notify listeners
    }

    public void markDeductionGrid(int ingrIndex, int markerIndex) {
    	deductionGrid[ingrIndex][markerIndex] = !deductionGrid[ingrIndex][markerIndex];
    	// notify listeners
    }
}
