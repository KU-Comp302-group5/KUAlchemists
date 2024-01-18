package domain;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.io.Serializable;
import javax.swing.ImageIcon;


public class Avatar implements Serializable {
	 //private int avatarType;
    
	//  public static ImageIcon avatar1 = new ImageIcon("avatar1.png");
	//  public static ImageIcon avatar2 = new ImageIcon("avatar2.png");
	//  public static ImageIcon avatar3 = new ImageIcon("avatar3.png");
	//  public static ImageIcon avatar4 = new ImageIcon("avatar4.png");
	//  public static ImageIcon avatar5 = new ImageIcon("avatar5.png");
	//  public static ImageIcon avatar6 = new ImageIcon("avatar6.png");
    
    public static ImageIcon getAvatarImage(Integer avatarType) {
        ImageIcon selectedAvatar = null;
        switch (avatarType) {
            case 1:
            	/*try {
                    BufferedImage image = ImageIO.read(new File("avatar1.png"));
                    Image resizedImage = image.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
                    selectedAvatar = new ImageIcon(resizedImage);
                    
                } catch (IOException ex) {
                    ex.printStackTrace();
                }*/
            	selectedAvatar = new ImageIcon("images/avatar1.png");
                break;
            case 2:
            	/*try {
                    BufferedImage image = ImageIO.read(new File("avatar2.png"));
                    Image resizedImage = image.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
                    selectedAvatar = new ImageIcon(resizedImage);
                    
                } catch (IOException ex) {
                    ex.printStackTrace();
                }*/
            	selectedAvatar = new ImageIcon("images/avatar2.png");
                break;
            case 3:
            	/*try {
                    BufferedImage image = ImageIO.read(new File("avatar3.png"));
                    Image resizedImage = image.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
                    selectedAvatar = new ImageIcon(resizedImage);
                    
                } catch (IOException ex) {
                    ex.printStackTrace();
                }*/
            	selectedAvatar = new ImageIcon("images/avatar3.png");
                break;
            case 4:
            	/*try {
                    BufferedImage image = ImageIO.read(new File("avatar4.png"));
                    Image resizedImage = image.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
                    selectedAvatar = new ImageIcon(resizedImage);
                    
                } catch (IOException ex) {
                    ex.printStackTrace();
                }*/
            	selectedAvatar = new ImageIcon("images/avatar4.png");
                break;
            case 5:
            	/*try {
                    BufferedImage image = ImageIO.read(new File("avatar5.png"));
                    Image resizedImage = image.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
                    selectedAvatar = new ImageIcon(resizedImage);
                    
                } catch (IOException ex) {
                    ex.printStackTrace();
                }*/
            	selectedAvatar = new ImageIcon("images/avatar5.png");
                break;
            case 6:
            	/*try {
                    BufferedImage image = ImageIO.read(new File("avatar6.png"));
                    Image resizedImage = image.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
                    selectedAvatar = new ImageIcon(resizedImage);
                    
                } catch (IOException ex) {
                    ex.printStackTrace();
                }*/
            	selectedAvatar = new ImageIcon("images/avatar6.png");
                break;
            default:
                break;
        }
        return selectedAvatar;
    }
}
