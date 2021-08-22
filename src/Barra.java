import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Barra {
	private int xBarra=350;

	public int getxBarra() {
		return xBarra;
	}

	public void setxBarra(int xBarra) {
		this.xBarra = xBarra;
	}
	
	public void left(){
		xBarra-=15;
	}
	
	public void right(){
		xBarra+=15;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(xBarra, 570, 100, 20);
	}

	public Rectangle getBarra() {
		return new Rectangle(xBarra, 570, 100, 20);
	}
}
