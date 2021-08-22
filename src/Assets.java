import java.awt.Image;

import javax.swing.ImageIcon;

public class Assets {

    //IMAGENES
    public static Image zombie1;
    public static Image zombie2;
    public static Image fondo;
    public static Image pizza;
    
    
    public static void loadAssets() {
   	 fondo = new ImageIcon("src/img/fondo.png").getImage();
   	 zombie1 = new ImageIcon("src/img/zombie1C.png").getImage();
   	 zombie2 = new ImageIcon("src/img/zombie2.png").getImage();
   	 //pizza = new ImageIcon("src/img/pizza60.png").getImage();
   	 pizza = new ImageIcon(Assets.class.getResource("/img/pizza60.png")).getImage();
   	 
    }

}
