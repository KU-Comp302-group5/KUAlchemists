package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import domain.DBListener;
import domain.DeductionBoard;
import domain.KUAlchemistsGame;
import domain.Potion;
import domain.controllers.HandlerFactory;

public class DeductionBoardDialog extends JDialog implements DBListener{
	JPanel resultsTriangleJPanel, deductionGridJPanel, ingredientsJPanel;
	String[] ingredients; // = {"toad", "claw", "scorpion", "fern", "feather", "mushroom", "flower", "root"}; 
	


	int selectedQuality;
	DeductionBoard dBoard;
	
	
	public DeductionBoardDialog(Frame parent) {
		super(parent, "Deduction Board", true);
		
		this.dBoard = KUAlchemistsGame.getInstance().getCurrentPlayer().getdBoard();
		this.selectedQuality = 2;
		this.ingredients = new String[]{"toad", "claw", "scorpion", "fern", "feather", "mushroom", "flower", "root"}; 
		
		setResultsTriangle(new JPanel());
		getResultsTriangle().setLayout(null);
		getResultsTriangle().setBounds(0,0,400,300);
		configureResultsTriangle();
		
		this.add(getResultsTriangle());
		
		setIngredientsJPanel(new JPanel());
		getIngredientsJPanel().setBounds(0, 300, 400, 50);
		getIngredientsJPanel().setLayout(null);
		IngredientPanel();
		this.add(getIngredientsJPanel());
		
		setDeductionGridJPanel(new JPanel());
		getDeductionGridJPanel().setLayout(null);
		getDeductionGridJPanel().setBounds(0,350,400,400);
		configureDeductionGrid();
		
		this.add(getDeductionGridJPanel());
	}
	
	
	

    public void IngredientPanel() {
    	 
        int imageWidth = 25;  // Adjust based on your image dimensions
        
                
        
        for (int i = 0; i < 8; i++) {
            ImageIcon image = createImageIcon("ingredient-" + this.ingredients[i] + ".png", 25, 50);
            JLabel label = new JLabel(image);
            //label.setPreferredSize(new Dimension(imageWidth, image.getIconHeight()));  // Maintain aspect ratio
            label.setBounds(15 + 50*i, 0, 25, 50);
            getIngredientsJPanel().add(label);
        }
        
    }
	
	private ImageIcon createImageIcon(String path, int width, int height){
		ImageIcon icon = null;
		try {
			System.out.println(path);
            BufferedImage image = ImageIO.read(new File(path));
            Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            icon = new ImageIcon(resizedImage);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
		return icon;
	}
	
	// GETTERS AND SETTERS
	public JPanel getIngredientsJPanel() {
		return ingredientsJPanel;
	}

	public void setIngredientsJPanel(JPanel ingredientsJPanel) {
		this.ingredientsJPanel = ingredientsJPanel;
	}
	
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
				ImageIcon marker = createImageIcon(this.ingredients[i] + ".png", 50, 50);
				JButton button = new JButton(marker);
				button.setOpaque(true); // Set opaque to true to see the background color
                if (dGrid[j][i]) {
                	button.setBackground(Color.RED); // set red if marked by user 
                }
                else{
                	button.setBackground(Color.WHITE); // Set initial background color
                }
                button.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Add border for clarity
                button.setBounds(j * 50, i * 50, 50, 50);
                
                button.addActionListener(e -> {
        			HandlerFactory.getInstance().getDeductionBoardHandler().markDeductionGrid(tempj, tempi);
                });
                
                button.setText("#" + (i+1));
                getDeductionGridJPanel().add(button); // Add label to the frame
                
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
	            label.setFocusable(true);
	            label.addMouseListener(new MouseAdapter() {
	                @Override
	                public void mouseClicked(MouseEvent e) {
	                    if (selectedQuality != 2) {
	                    	HandlerFactory.getInstance().getDeductionBoardHandler().markResultsTriangle(tempindex, selectedQuality);
	                    	selectedQuality = 2;
	                    	System.out.println("results triangle mark sent to handler by ui");
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
		SwingUtilities.invokeLater(() -> {
			getDeductionGridJPanel().removeAll();
			getResultsTriangle().removeAll();
			getIngredientsJPanel().removeAll();
	        configureDeductionGrid();
	        configureResultsTriangle();
	        IngredientPanel();
	        // Remove and re-add components to the dialog's content pane
	        this.getContentPane().removeAll();
	        this.getContentPane().add(getResultsTriangle());
	        this.getContentPane().add(getDeductionGridJPanel());
	        this.getContentPane().add(getIngredientsJPanel());
	        revalidate(); // Revalidate the container to update the layout
	        repaint(); // Repaint to reflect the changes
	    });
	}

}
