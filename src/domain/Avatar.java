package domain;

import javax.swing.ImageIcon;

public class Avatar {
    private int avatarType;
    public static ImageIcon avatar1 = new ImageIcon("avatar1.png");
    public static ImageIcon avatar2 = new ImageIcon("avatar2.png");
    public static ImageIcon avatar3 = new ImageIcon("avatar3.png");
    
    public static ImageIcon getAvatarImage(int avatarType) {
        ImageIcon selectedAvatar = null;
        switch (avatarType) {
            case 1:
                selectedAvatar = avatar1;
                break;
            case 2:
                selectedAvatar = avatar2;
                break;
            case 3:
                selectedAvatar = avatar3;
                break;
            default:
                break;
        }
        return selectedAvatar;
    }
}
