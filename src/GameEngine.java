import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;

public class GameEngine extends JFrame {

	/**
	 * Paco Pulido 16-10-2019
	 */
	private static final long serialVersionUID = 1L;
	private static final int VECESMUEVEZOMBIE = 4;

	boolean isRunning = true;

	private BufferedImage bufferedImage;
	private InputHandler input;
	
	private Barra barra;
	private Bola bola;
	private int mueveZombie = 0;
	private Zombie zombie;
	private Image fondo;
	private ArrayList<Zombie> muchosZombies;
	private int salidaZombieScreen=0;
	private int sumaPuntos;
	
	public static void main(String[] args) {
		GameEngine game = new GameEngine();
		new GameLoop(game).start();
	}

	public GameEngine() {
		Assets.loadAssets();
		setTitle("Game Engine");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setSize(800,600);
		setLocationRelativeTo(null);
		fondo = new ImageIcon(Assets.fondo).getImage();

		bufferedImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
		input = new InputHandler(this);
		
		barra = new Barra();
		bola = new Bola();
		
		zombie = new Zombie();
		muchosZombies = new ArrayList<Zombie>();
		
		nuevosZombies();
		
	}

	void update() {
		// handle inputs
		if (input.isKeyDown(KeyEvent.VK_RIGHT)) {
			barra.right();
		}
		if (input.isKeyDown(KeyEvent.VK_LEFT)) {
			barra.left();
		}
		// update sprites
		bola.update(choque(barra.getBarra()), barra.getxBarra());
		
		mueveZombie = ++mueveZombie % VECESMUEVEZOMBIE;
		for (Zombie zombie : muchosZombies) {
			if(mueveZombie==0) {
				zombie.update(choqueZombie(zombie.getZombie()));
			}
		}
		
		//Rebote bola por la pantalla
		reboteBolaScreen();
		
		salidaZombieScreen++;
		if(salidaZombieScreen == 400) {
			nuevosZombies();
			salidaZombieScreen=0;
		}
		
		if(bola.yBola > 600) {

			finjuego();
		}else {
			sumaPuntos++;
		}

		if(zombie.zombie1 == null || zombie.zombie2 == null) {
			System.out.println(sumaPuntos++);
		}
	}

	void draw() {
		Graphics g = getGraphics();
		Graphics bbg = bufferedImage.getGraphics();
		// Fondo
		bbg.setColor(Color.LIGHT_GRAY);
		bbg.fillRect(0, 0, getWidth(), getHeight());
		bbg.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
	
		// draws sprites
		barra.draw(bbg);
		
		bola.draw(bbg);
		
		for (Zombie zombie : muchosZombies) {
			if(zombie.voltear == true) {
				zombie.draw2(bbg);
			}else {
				zombie.draw1(bbg);
			}
		}
		
		g.drawImage(bufferedImage, 0, 0, this);
        
		
		
//      g.setColor(Color.white);
//		g.setFont(new Font("Verdana", Font.BOLD, 30));
//		g.drawString("SCORE", 10, 100);
	}
	
	public boolean choque(Rectangle barra) {
		return bola.getBola().intersects(barra);
	}
	
	public boolean choqueZombie(Rectangle zombie) {
		return bola.getBola().intersects(zombie);
	}
	
	void reboteBolaScreen() {
		if(bola.xBola >= 780 || bola.xBola <= 0) {
			bola.speedX*=-1;
		}
		if(bola.yBola <= 22) {
			bola.speedY*=-1;
		}
	}
	
	void nuevosZombies() {
		for(int i=0; i <=10; i++) {
			muchosZombies.add(new Zombie());
		}
	}
	
	public void finjuego() {
		//Mensaje
		JOptionPane.showMessageDialog(null, "GAME OVER!!! " + "SCORE: " + sumaPuntos);
		//Salir del juego
		System.exit(-1);
	}
}

