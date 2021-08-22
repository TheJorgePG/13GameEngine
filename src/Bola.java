import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

public class Bola implements ImageObserver {
	public int xBola=50, yBola=50;
	public int xPizza=60, yPizza=60;
	public int speedX=5, speedY=5;
	public Image pizza;
	
//	public Bola() {
//		
//		ImageIcon ii = new ImageIcon(Assets.pizza);
//		pizza = ii.getImage();
//	}
	

	public void update(boolean choque, int getxBarra) {
		xBola+=speedX;
		yBola+=speedY;
		
//		xPizza+=speedX;
//		yPizza+=speedY;
		
		if(choque == true) {			
			//Primera Dirección
			if(xBola + 20 >= getxBarra + 0 && xBola + 20 <= getxBarra + 20) {
		   		 if(yBola + 40 >= 530) {
		   			 speedX = ((int)(-10*(Math.cos(Math.PI/3))));
		   			 speedY = ((int)(-10*(Math.sin(Math.PI/3))));
		   		 }
		   	 }
			
			//Segunda Dirección
			if(xBola + 20 >= getxBarra + 20 && xBola + 20 <= getxBarra + 40) {
		   		 if(yBola + 40 >= 530) {
		   			 speedX = ((int)(-5*(Math.cos(Math.PI/3))));
		   			 speedY = ((int)(-10*(Math.sin(Math.PI/3))));
		   		 }
		   	 }
			
			//Tercera Dirección
			if(xBola + 20 >= getxBarra + 40 && xBola + 20 <= getxBarra + 60) {
		   		 if(yBola + 40 >= 530) {
		   			 speedX = ((int)(-2*(Math.cos(Math.PI/2))));
		   			 speedY = ((int)(-10*(Math.sin(Math.PI/2))));
		   		 }
		   	 }
			
			//Cuarta Dirección
			if(xBola + 20 >= getxBarra + 60 && xBola + 20 <= getxBarra + 80) {
		   		 if(yBola + 40 >= 530) {
		   			 speedX = ((int)(5*(Math.cos(Math.PI/3))));
		   			 speedY = ((int)(-10*(Math.sin(Math.PI/3))));
		   		 }
		   	 }
			
			//Quinta dirección
			if(xBola + 20 >= getxBarra + 80 && xBola + 20 <= getxBarra + 100) {
		   		 if(yBola + 40 >= 530) {
		   			 speedX = ((int)(10*(Math.cos(Math.PI/3))));
		   			 speedY = ((int)(-10*(Math.sin(Math.PI/3))));
		   		 }
		   	 }
		}
	}
	
	public void draw(Graphics g) {
//		g.drawImage(pizza, xPizza, yPizza, this);
		g.setColor(Color.RED);
		g.fillOval(xBola, yBola, 20, 20);
	}
	
	public Rectangle getBola() {
		return new Rectangle(xBola, yBola, 20, 20);
	}


	@Override
	public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		return false;
	}
}
