import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Zombie {
	public int xZombie= (int) (Math.random()* 500 +1), yZombie=280;
	public int speedXZombie=6, speedYZombie=3;
	private int frame=0;
	private int direccion1=2;
	private int direccion2=1;
	public Image zombie1;
	public Image zombie2;
	public boolean voltear;
	
	public Zombie() {
		ImageIcon ii = new ImageIcon(Assets.zombie1);
		zombie1 = ii.getImage();
		
		ImageIcon ii2 = new ImageIcon(Assets.zombie2);
		zombie2 = ii2.getImage();
	}
	
	public void right() {
		speedXZombie = 3;
		speedYZombie = 0;
		direccion1=2;
	}
	
	public void draw1(Graphics g) {
		g.drawImage(zombie1, xZombie, yZombie, xZombie+100, yZombie+100, frame*100, direccion1*100, (frame+1)*100, (direccion1+1)*100, null);
	}
	
	public void draw2(Graphics g) {
		g.drawImage(zombie2, xZombie, yZombie, xZombie+100, yZombie+100, frame*100, direccion2*100, (frame+1)*100, (direccion2+1)*100, null);
	}
	
	public void update(boolean choque) {
		yZombie=280;
		
		frame = ++frame%4;
		
		xZombie+=speedXZombie;
		yZombie+=speedYZombie;
		
		if(xZombie >= 700) {
			speedXZombie*=-1;
			voltear=true;
		}
		
		if(xZombie <= 0) {
			right();
			voltear=false;
		}
		
		//Cuanod choque la bola con el zombie, que el zombie desaparezca
		if(choque == true) {
			zombie1 = null;
			zombie2 = null;
		}
	}
	
	//Colision bola con el zombie
	public Rectangle getZombie() {
		return new Rectangle(xZombie, yZombie, 80, 80);
	}
}
