package ui;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import domain.Ingredient;
import domain.PotionMaker;
import domain.controllers.HandlerFactory;

public class MagicMortarDialog extends JDialog{

	private static Ingredient selectedIngr;
	private static JPanel panelArtifact;
	

	public static JPanel getPanelArtifact() {
		return panelArtifact;
	}


	public static void setPanelArtifact(JPanel panelArtifact) {
		MagicMortarDialog.panelArtifact = panelArtifact;
	}


	public Ingredient getSelectedIngr() {
		return selectedIngr;
	}


	public void setSelectedIngr(Ingredient selectedIngr) {
		this.selectedIngr = selectedIngr;
	}


	public MagicMortarDialog(Frame parent) {
		// display the ingredients used in making the potion
		// when the user clicks one of them, call UseArtifactHandler().useCard(list)
		// where list is a list of ingredients (only one in this case)
		super(parent, "Magic Mortar", true);
		setPanelArtifact(new JPanel());
		getPanelArtifact().setLayout(null);
		
		// get the ingredient objects from potionmaker
		Ingredient ingr1 = PotionMaker.getInstance().getIngr1();
		Ingredient ingr2 = PotionMaker.getInstance().getIngr2();
		
		// initialize potion maker
		JLabel labelDescription = new JLabel("Click the card to NOT discard");
		labelDescription.setBounds(100, 100, 400, 20);
		getPanelArtifact().add(labelDescription);
		
		// initialize ingredient buttons and submit button
		JButton ingrButton1 = new JButton(ingr1.getName());
		JButton ingrButton2 = new JButton(ingr2.getName());
		JButton submitButton = new JButton("Submit Choice");
		
		ingrButton1.setBounds(70, 170, 100, 60);
		ingrButton1.setForeground(Color.BLACK);
		ingrButton1.setBackground(Color.WHITE);
		
		ingrButton2.setBounds(190, 170, 100, 60);
		ingrButton2.setForeground(Color.BLACK);
		ingrButton2.setBackground(Color.WHITE);
		
		submitButton.setBounds(190, 300, 100, 60);
		submitButton.setVisible(false);
		
		submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HandlerFactory.getInstance().getUseArtifactHandler().performArtifact(getSelectedIngr());
            	System.out.println("Magic mortar decision submitted");
            }
        });
		
		ingrButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setSelectedIngr(ingr1);
                submitButton.setVisible(true);
            }
        });
		
		ingrButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setSelectedIngr(ingr2);
                submitButton.setVisible(true);
            }
        });
		
		getPanelArtifact().add(submitButton);
		getPanelArtifact().add(ingrButton1);
		getPanelArtifact().add(ingrButton2);
		
		
		
		
		
				
	}
}
