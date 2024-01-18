package ui;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import domain.ArtifactCard;
import domain.controllers.HandlerFactory;

public class WisdomIdolDialog extends JDialog {
	
private static JPanel panelArtifact;
	
	public static JPanel getPanelArtifact() {
		return panelArtifact;
	}

	public static void setPanelArtifact(JPanel panelArtifact) {
		WisdomIdolDialog.panelArtifact = panelArtifact;
	}

	public WisdomIdolDialog(Frame parent) {
		
		super(parent, "Wisdom Idol", true);
		setPanelArtifact(new JPanel());
		getPanelArtifact().setLayout(null);
		
		JLabel labelDescription = new JLabel("Do you want to keep your reputation as a Wisdom Idol?");
		labelDescription.setBounds(100, 100, 400, 20);
		getPanelArtifact().add(labelDescription);
		
		JButton Button1 = new JButton("Yes");
		JButton Button2 = new JButton("No");
		
		Button1.setBounds(70, 170, 100, 60);
		Button1.setForeground(Color.BLACK);
		Button1.setBackground(Color.WHITE);
		
		Button2.setBounds(190, 170, 100, 60);
		Button2.setForeground(Color.BLACK);
		Button2.setBackground(Color.WHITE);
		
		Button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	HandlerFactory.getInstance().getUseArtifactHandler().useArtifact(new ArtifactCard("Wisdom Idol", 3, false));
                HandlerFactory.getInstance().getUseArtifactHandler().performArtifact(1);
            	dispose();
            }
        });
		
		Button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

		getPanelArtifact().add(Button1);
		getPanelArtifact().add(Button2);
	}
}