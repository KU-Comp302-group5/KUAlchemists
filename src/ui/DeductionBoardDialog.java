package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import domain.KUAlchemistsGame;
import domain.controllers.HandlerFactory;

public class DeductionBoardDialog extends JDialog{
	JPanel resultsTriangle, deductionGridJPanel;
	
	
	public DeductionBoardDialog(Frame parent) {
		super(parent, "Elixir of Insight", true);
		
		setResultsTriangle(new JPanel());
		getResultsTriangle().setLayout(null);
		
		setDeductionGridJPanel(new JPanel());
		getDeductionGridJPanel().setLayout(new GridLayout(8,8));
		getDeductionGridJPanel().setBounds(100,100,320,320);;
		configureDeductionGrid();
		
		this.add(getDeductionGridJPanel());
				
		
	}
	
	
	// GETTERS AND SETTERS
	public JPanel getResultsTriangle() {
		return resultsTriangle;
	}

	public void setResultsTriangle(JPanel resultsTriange) {
		this.resultsTriangle = resultsTriange;
	}

	public JPanel getDeductionGridJPanel() {
		return deductionGridJPanel;
	}

	public void setDeductionGridJPanel(JPanel deductionGridJPanel) {
		this.deductionGridJPanel = deductionGridJPanel;
	}

	public void configureDeductionGrid() {
		for (int i = 0; i < 8; i++) {
			int tempi = i;
			for (int j = 0; j < 8; j++) {
				int tempj = j;
				JLabel label = new JLabel();
                label.setOpaque(true); // Set opaque to true to see the background color
                label.setBackground(Color.WHITE); // Set initial background color
                label.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Add border for clarity
                
                // Add a MouseListener to each label
                label.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                    	// get the label if we want to do something with it later
                        JLabel clickedLabel = (JLabel) e.getSource();
                        
                        HandlerFactory.getInstance().getDeductionBoardHandler().markDeductionGrid(tempj, tempi);
                        
                    }
                });
                
                label.setText("Alchemy marker #" + i); // Set a name for the label (optional)
                getDeductionGridJPanel().add(label); // Add label to the frame
                
			}
		}
		
		
	}

}
