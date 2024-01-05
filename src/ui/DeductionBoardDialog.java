package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import domain.DBListener;
import domain.DeductionBoard;
import domain.KUAlchemistsGame;
import domain.Potion;
import domain.controllers.HandlerFactory;

public class DeductionBoardDialog extends JDialog implements DBListener{
	JPanel resultsTriangleJPanel, deductionGridJPanel;
	int selectedQuality;
	DeductionBoard dBoard;
	
	
	public DeductionBoardDialog(Frame parent) {
		super(parent, "Deduction Board", true);
		
		this.dBoard = KUAlchemistsGame.getInstance().getCurrentPlayer().getdBoard();
		this.selectedQuality = 2;
		
		setResultsTriangle(new JPanel());
		getResultsTriangle().setLayout(null);
		getResultsTriangle().setBounds(0,0,400,300);
		configureResultsTriangle();
		
		this.add(getResultsTriangle());
		
		setDeductionGridJPanel(new JPanel());
		getDeductionGridJPanel().setLayout(new GridLayout(8,8));
		getDeductionGridJPanel().setBounds(0,300,400,300);
		configureDeductionGrid();
		
		this.add(getDeductionGridJPanel());
	}
	
	
	// GETTERS AND SETTERS
	public JPanel getResultsTriangle() {
		return resultsTriangleJPanel;
	}

	public void setResultsTriangle(JPanel resultsTriangle) {
		this.resultsTriangleJPanel = resultsTriangle;
	}

	public JPanel getDeductionGridJPanel() {
		return deductionGridJPanel;
	}

	public void setDeductionGridJPanel(JPanel deductionGridJPanel) {
		this.deductionGridJPanel = deductionGridJPanel;
	}

	public void configureDeductionGrid() {
		Boolean[][] dGrid = dBoard.getDeductionGrid();
		for (int i = 0; i < 8; i++) {	// iterate over alchemy markers
			int tempi = i;
			for (int j = 0; j < 8; j++) {	//iterate over ingredients
				int tempj = j;
				JLabel label = new JLabel();
                label.setOpaque(true); // Set opaque to true to see the background color
                if (dGrid[j][i]) {
                	label.setBackground(Color.RED); // set red if marked by user 
                }
                else{
                	label.setBackground(Color.WHITE); // Set initial background color
                }
                label.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Add border for clarity
                
                // Add a MouseListener to each label
                label.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                    	
                        HandlerFactory.getInstance().getDeductionBoardHandler().markDeductionGrid(tempj, tempi);
                        
                    }
                });
                
                label.setText("Alchemy marker #" + i);
                getDeductionGridJPanel().add(label); // Add label to the frame
                
			}
		}
	}
	
	public void configureResultsTriangle() {
		Potion[] rTriangle = dBoard.getResultsTriangle();
		
		JButton positiveButton = new JButton("+");
        JButton negativeButton = new JButton("-");
        JButton neutralButton = new JButton("N");
        
        positiveButton.setFont(positiveButton.getFont().deriveFont(7f));
        negativeButton.setFont(negativeButton.getFont().deriveFont(7f));
        neutralButton.setFont(neutralButton.getFont().deriveFont(7f));

        // Add action listeners to the buttons
        positiveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedQuality = 1; // Update selectedPotion based on user selection
                
            }
        });

        negativeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	selectedQuality = -1; // Update selectedPotion based on user selection
                
            }
        });

        neutralButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	selectedQuality = 0; // Update selectedPotion based on user selection
                
            }
        });
        
        positiveButton.setBounds(0, 0, 40, 40);
        negativeButton.setBounds(40, 0, 40, 40);
        neutralButton.setBounds(80, 0, 40, 40);
        
        // Add buttons to the results triangle panel
        getResultsTriangle().add(positiveButton);
        getResultsTriangle().add(negativeButton);
        getResultsTriangle().add(neutralButton);
		
		int index = 0;
		int gap = 10;
		int halfButton = 20;
		
		for (int i = 1; i < 8; i++) {
			int startX = (200 - (i*20 + (i / 2)*10));
			int startY = (i - 1)*40;
			
			for (int j = 0; j < i; j++) {
				int tempindex = index;
				JLabel label = new JLabel();
				label.setOpaque(true); // Set opaque to true to see the background color
				label.setBackground(Color.YELLOW);
	            label.setBorder(BorderFactory.createLineBorder(Color.GRAY)); // Add border for clarity
	            label.setBounds(startX + (j * 2 * halfButton + j * gap), startY, 40, 40);
	            
	            if (rTriangle[index] != null) {
	            	String str = null;
	            	switch (rTriangle[index].getQuality()) {
	            	case 1: 
	            		str="positive";
	            		break;
	            	case -1:
	            		str="negative";
	            		break;
	            	case 0:
	            		str="neutral";
	            		break;
	            	}
	            	label.setText(str);
	            }
	            else {
	            	label.setText("-------");
	            }
	            label.setFont(label.getFont().deriveFont(8f)); // Set the font size
	            label.setHorizontalAlignment(SwingConstants.CENTER); // Center text horizontally
	            
	            label.addMouseListener(new MouseAdapter() {
	                @Override
	                public void mouseClicked(MouseEvent e) {
	                    if (selectedQuality != 2) {
	                    	HandlerFactory.getInstance().getDeductionBoardHandler().markResultsTriangle(tempindex, selectedQuality);
	                    	selectedQuality = 2;
	                    }
	                }
	            });
	            
				getResultsTriangle().add(label);
				index++;
				
			}
		}
		
	}


	@Override
	public void onDBChange() {
		// TODO Auto-generated method stub
		configureDeductionGrid();
		configureResultsTriangle();
	}

}
