package mygamecar.Modelo;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class EnemyCar {
	private int x, y;
	private int height, widht;
	private Image enemy;
	private boolean isVisivel;
	
	private static int VELOCIDADE = 4;
	
	public EnemyCar(int positionX, int positionY) {
		x = positionX-10;
		y = positionY-50;
		isVisivel = true;
	}
	
	public void loadEnemy (int num) {
		ImageIcon image;
		if(num%2 == 0) {
			image = new ImageIcon("Imagens//PlayerCarBlue.png");
		}else {
			image = new ImageIcon("Imagens//PlayerCarGreen.png");
		}
		enemy = image.getImage();
		
		height = enemy.getHeight(null);
		widht = enemy.getWidth(null);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, widht, height);
	}
	
	public void movimented () {
		y -= VELOCIDADE;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Image getEnemy() {
		return enemy;
	}

	public void setEnemy(Image enemy) {
		this.enemy = enemy;
	}

	public boolean isVisivel() {
		return isVisivel;
	}

	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}

	public static int getVELOCIDADE() {
		return VELOCIDADE;
	}

	public static void setVELOCIDADE(int vELOCIDADE) {
		VELOCIDADE = vELOCIDADE;
	}
	
	
}
